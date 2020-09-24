package a_parsing.e_backtrack;

public class BacktrackLexer extends Lexer {

    public static int NAME = 2;
    public static int COMMA = 3;
    public static int LBRACK = 4;
    public static int RBRACK = 5;
    public static int EQUALS = 6;

    public static String[] tokenNames = {
            "n/a", "<EOF>", "NAME", ",", "[", "]", "="
    };

    public BacktrackLexer(String input) {
        super(input);
    }

    @Override
    public Token nextToken() {
        return null;
    }

    @Override
    void WS() {

    }

    @Override
    public String getTokenName(int x) {
        return BacktrackLexer.tokenNames[x];
    }

    boolean isLETTER() {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    Token name() {
        StringBuilder buf = new StringBuilder();
        while (isLETTER()) {
            buf.append(c);
            LETTER();
        }
        return new Token(NAME, buf.toString());
    }

    void LETTER(){
        if ( isLETTER() ){
            consume();
        }else{
            throw new Error("expecting LETTER; found "+c);
        }

    }

}
