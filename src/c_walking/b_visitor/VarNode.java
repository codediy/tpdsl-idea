package c_walking.b_visitor;

public class VarNode extends ExprNode {

    public VarNode(Token t) {
        super(t);
    }

    @Override
    public void visit(VecMathVisitor visitor) {
        visitor.visit(this);
    }
}
