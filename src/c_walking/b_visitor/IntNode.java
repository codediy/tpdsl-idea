package c_walking.b_visitor;

public class IntNode extends ExprNode {

    public IntNode(Token t) {
        super(t);
    }

    @Override
    public void visit(VecMathVisitor visitor) {
        visitor.visit(this);
    }
}
