package a_parsing.e_backtrack;

import java.util.ArrayList;
import java.util.List;

public class Parse {
    Lexer input;
    List<Integer> markers;
    List<Token> lookahead;
    int p = 0;

    public Parse(Lexer input) {
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
        }
        /*填充1个*/
        sync(1);
    }

    /**
     * @param i
     */
    public void sync(int i) {
        /*如果i超出了lookahead的索引范围*/
        if (p + i - 1 > (lookahead.size() - 1)) {
            /*再填充n个到i*/
            int n = (p + i - 1) - (lookahead.size() - 1);
            /*填充n个*/
            fill(n);
        }
    }

    /**
     * lookahead添加n个Token
     *
     * @param n
     */
    public void fill(int n) {
        for (int i = 1; i <= n; i++) {
            lookahead.add(input.nextToken());
        }
    }

    public int mark() {
        markers.add(p);
        return p;
    }

    public void release() {
        int marker = markers.get(markers.size() - 1);
        markers.remove(markers.size() - 1);
        seek(marker);
    }


    public void seek(int index) {
        p = index;
    }

    public boolean isSpeculating() {
        return markers.size() > 0;
    }


    public Token LT(int i) {
        sync(i);
        return lookahead.get(p + i - 1);
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
}
