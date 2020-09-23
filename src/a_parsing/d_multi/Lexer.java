package a_parsing.d_multi;

public abstract class Lexer {
    public static final char EOF = (char) -1;
    public static final int EOF_TYPE = 1;

    String input;
    int i = 0;
    char c;

    public Lexer(String input) {
        this.input = input;
        c = input.charAt(i);
    }

    public void advance() {
        i = i + 1;
        if (i >= input.length()) {
            c = EOF;
        } else {
            c = input.charAt(i);
        }
    }

    /**
     * 移动下一个，并且跳过空格
     */
    public void consume() {
        advance();
        WS();
    }

    public abstract Token nextToken();

    public abstract String getTokenName(int x);

    abstract void WS();
}
