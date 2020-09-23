package a_parsing.d_multi;

public class LookaheadLexer extends Lexer {

    public static int NAME = 2;
    public static int COMMA = 3;
    public static int LBRACK = 4;
    public static int RBRACK = 5;
    public static int EQUALS = 6;

    public static String[] tokenNames = {
            "n/a", "<EOF>", "NAME", ",", "[", "]", "="
    };

    public LookaheadLexer(String input) {
        super(input);
    }

    @Override
    public Token nextToken() {
        while (c != EOF) {
            switch (c) {
                case ' ':
                case '\t':
                case '\n':
                case '\r':
                    WS();
                    continue;
                case ',':
                    consume();
                    return new Token(COMMA, ",");
                case '[':
                    consume();
                    return new Token(LBRACK, "[");
                case ']':
                    consume();
                    return new Token(RBRACK, "]");
                case '=':
                    consume();
                    return new Token(EQUALS, "=");
                default:
                    if (isLETTER()) return name();
                    throw new Error("invalid character: " + c);
            }
        }
        return new Token(EOF_TYPE, "<EOF>");
    }

    @Override
    public String getTokenName(int x) {
        return LookaheadLexer.tokenNames[x];
    }

    boolean isLETTER() {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    }

    Token name() {
        StringBuilder buf = new StringBuilder();
        do {
            buf.append(c);
            LETTER();
        } while (isLETTER());
        return new Token(NAME, buf.toString());
    }

    void LETTER() {
        if (isLETTER()) {
            consume();
        } else {
            throw new Error("expecting LETTER; found " + c);
        }
    }

    @Override
    void WS() {
        while (c == ' ' || c == '\t' || c == '\n' || c == '\r') {
            advance();
        }
    }
}
