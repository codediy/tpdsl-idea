package b_ir.b_homo;

public class Test {
    public static void main(String[] args) {
        /**
         * token节点
         */
        Token plus = new Token(Token.PLUS, "+");
        Token one = new Token(Token.INT, "1");
        Token two = new Token(Token.INT, "2");

        /**
         * 构造树节点
         */
        AST root = new AST(plus);
        root.addChild(new AST(one));
        root.addChild(new AST(two));
        System.out.println("1+2 tree: " + root.toStringTree());


        /**
         * 构建列表节点
         */
        AST list = new AST();
        list.addChild(new AST(one));
        list.addChild(new AST(two));
        System.out.println("1 and 2 in list: "+list.toStringTree());
    }
}
