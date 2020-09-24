package a_parsing.d_multi;

import java.util.Arrays;

public class Parser {
    Lexer input;
    /*已匹配的Token数组*/
    Token[] lookahead;
    /*往前看匹配的Token数量*/
    int k;
    /*待处理Token位置*/
    int p = 0;

    public Parser(Lexer input, int k) {
        this.input = input;
        this.k = k;

        this.lookahead = new Token[k];

        /*往前看k个Token*/
        for (int i = 1; i <= k; i++) {
            consume();
        }
    }

    public void consume() {
        lookahead[p] = input.nextToken();
        p = (p + 1) % k;

    }

    /**
     * lookahead的第i个Token类型
     *
     * @param i
     * @return
     */
    public int LA(int i) {
        return LT(i).type;
    }

    public Token LT(int i) {
        return lookahead[(p + i - 1) % k];
    }

    /**
     * 匹配检查
     *
     * @param x
     */
    public void match(int x) {
        if (LA(1) == x) {
            consume();
        } else {
            throw new Error("expecting " + input.getTokenName(x) +
                    "; found " + LT(1));
        }
    }
}
