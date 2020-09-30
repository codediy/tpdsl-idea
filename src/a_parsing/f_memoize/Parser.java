package a_parsing.f_memoize;

import java.time.chrono.MinguoDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class Parser {
    public static final int FAILED = -1;

    Lexer input;
    List<Integer> markers;
    List<Token> lookahead;
    int p = 0; /*LT(1) = lookahead[p]*/

    public Parser(Lexer input) {
        this.input = input;
        markers = new ArrayList<Integer>();
        lookahead = new ArrayList<Token>();
        sync(1);
    }

    public void consume() {
        p = p + 1;
        if (p == lookahead.size() && !isSpeculating()) {
            p = 0;
            lookahead.clear();
            clearMemo();
        }
        sync(1);
    }

    /**
     * 从盘开始至少包含i个Tokens
     *
     * @param i
     */
    public void sync(int i) {
        if (p - 1 + i > (lookahead.size() - 1)) {
            int n = (p - 1 + i) - (lookahead.size() - 1);
            fill(n);
        }
    }

    public void fill(int n) {
        for (int i = 1; i <= n; i++) {
            lookahead.add(input.nextToken());
        }
    }

    public Token LT(int i) {
        sync(i);
        return lookahead.get(p - 1 + i);
    }

    public int LA(int i) {
        return LT(i).type;
    }

    public void match(int x) throws MismatchedTokenException {
        if (LA(1) == x) {
            consume();
        } else {
            throw new MismatchedTokenException("expecting " +
                    input.getTokenName(x) + " found " + LT(1));
        }
    }

    /**
     * 记录回溯标记开始
     *
     * @return
     */
    public int mark() {
        markers.add(p);
        return p;
    }

    /**
     * 退回到上一个标记位置
     */
    public void release() {
        int marker = markers.get(markers.size() - 1);
        markers.remove(markers.size() - 1);
        seek(marker);
    }

    /**
     * 移动p到index
     *
     * @param index
     */
    public void seek(int index) {
        p = index;
    }

    /**
     * 标记是否已清空
     *
     * @return
     */
    public boolean isSpeculating() {
        return markers.size() > 0;
    }

    /**
     * 检查是否有记忆的解析
     *
     * @param memoization
     * @return
     */
    public boolean alreadyParsedRule(Map<Integer, Integer> memoization) throws PreviousParseFailedException {
        Integer memoI = memoization.get(index());
        if (memoI == null) {
            return false;
        }
        int memo = memoI.intValue();
        System.out.println("parsed list before at index " + index() +
                "; skip ahead to token index " + memo + ": " +
                lookahead.get(memo).text);
        if (memo == FAILED) {
            throw new PreviousParseFailedException();
        }
        seek(memo);
        return true;
    }

    /**
     * 插入解析记录
     *
     * @param memoization
     * @param startTokenIndex
     * @param failed
     */
    public void memoize(
            Map<Integer, Integer> memoization,
            int startTokenIndex,
            boolean failed
    ) {
        int stopTokenIndex = failed ? FAILED : index();
        memoization.put(startTokenIndex, stopTokenIndex);
    }

    public int index() {
        return p;
    }

    public abstract void clearMemo();
}
