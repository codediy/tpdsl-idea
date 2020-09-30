package c_walking.b_visitor;

public class AddNode extends ExprNode {
    ExprNode left, right;

    public AddNode(ExprNode left, Token t, ExprNode right) {
        super(t);
        this.left = left;
        this.right = right;
    }

    @Override
    public void visit(VecMathVisitor visitor) {
        visitor.visit(this);
    }
}
