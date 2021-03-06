package c_walking.a_embedded;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static IntNode I(int i) {
        return new IntNode(
                new Token(
                        Token.INT,
                        String.valueOf(i)
                )
        );
    }

    public static void main(String[] args) {
        /**/
        List<StatNode> stats = new ArrayList<StatNode>();

        AddNode a = new AddNode(I(3), new Token(Token.PLUS), I(4));
        VarNode x = new VarNode(new Token(Token.ID, "x"));
        AssignNode assign = new AssignNode(x, new Token(Token.ASSIGN), a);
        stats.add(assign);

        Token mult = new Token(Token.MULT, "*");
        List<ExprNode> elements = new ArrayList<>();
        elements.add(I(2));
        elements.add(I(3));
        elements.add(I(4));
        VectorNode v = new VectorNode(new Token(Token.VEC), elements);

        VarNode xref = new VarNode(new Token(Token.ID, "x"));
        ExprNode pv = new MultNode(xref, mult, v);
        PrintNode p = new PrintNode(new Token(Token.PRINT, "print"), pv);

        stats.add(p);
        StatListNode statListNode = new StatListNode(stats);
        statListNode.print();


    }
}
