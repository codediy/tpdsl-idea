package c_walking.b_visitor;

import java.util.ArrayList;
import java.util.List;

public class VectorNode extends ExprNode {
    List<ExprNode> elements = new ArrayList<ExprNode>();

    public VectorNode(Token t, List<ExprNode> elements) {
        super(t);
        this.elements = elements;
    }


    @Override
    public void visit(VecMathVisitor visitor) {

    }
}
