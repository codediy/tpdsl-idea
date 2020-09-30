package b_ir.c_normalized;

import java.util.List;

public class VectorNode extends ExprNode {

    public VectorNode(Token t, List<ExprNode> elements) {
        super(t);
        evalType = tVECTOR;
        for (ExprNode e : elements) {
            addChild(e);
        }
    }
}
