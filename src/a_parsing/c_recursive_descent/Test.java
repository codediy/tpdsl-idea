package a_parsing.c_recursive_descent;

public class Test {
    public static void main(String[] args) {
        String testStr = "[Hello,Codeling]";
        ListLexer lexer = new ListLexer(testStr);
        ListParser parser = new ListParser(lexer);
        parser.list();
    }
}
