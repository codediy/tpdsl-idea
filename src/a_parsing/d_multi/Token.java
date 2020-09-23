package a_parsing.d_multi;

import a_parsing.c_recursive_descent.ListLexer;

public class Token {
    public int type;
    public String text;

    public Token(int type, String text) {
        this.type = type;
        this.text = text;
    }

    @Override
    public String toString() {
        String tname = LookaheadLexer.tokenNames[type];
        return "<'" + text + "'," + tname + ">";
    }
}
