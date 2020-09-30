package c_walking.b_visitor;

public class DotProductNode extends ExprNode {
    ExprNode left, right;

    public DotProductNode(ExprNode left, Token t, ExprNode right) {
        super(t);
        this.left = left;
        this.right = right;
    }

    public void visit(VecMathVisitor visitor) {
        visitor.visit(this);
    }
}

