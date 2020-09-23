package a_parsing.b_lexer;

public class Test {
    public static void main(String[] args){
        String testStr = "[Hallo,Wereld]";
        ListLexer lexer = new ListLexer(testStr);
        Token t = lexer.nextToken();
        while (t.type != Lexer.EOF_TYPE){
            System.out.println(t);
            t = lexer.nextToken();
        }
        System.out.println(t);
    }
}
