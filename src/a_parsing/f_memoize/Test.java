package a_parsing.f_memoize;

public class Test {
    public static void main(String[] args) throws RecognitionException {
        String testStr = "[a,b]=[c,d]";
        BacktrackLexer lexer = new BacktrackLexer(testStr); // parse arg
        BacktrackParser parser = new BacktrackParser(lexer);
        parser.stat(); // begin parsing at rule stat
    }
}
