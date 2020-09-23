package a_parsing.d_multi;

public class Test {
    public static void main(String[] args) {
        String testStr = "[Hello=World]";
        LookaheadLexer lexer = new LookaheadLexer(testStr);
        LookaheadParser parser = new LookaheadParser(lexer, 2);
        parser.list();
    }
}
