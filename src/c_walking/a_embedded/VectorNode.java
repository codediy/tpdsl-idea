package c_walking.a_embedded;

import java.util.ArrayList;
import java.util.List;

public class VectorNode extends ExprNode {
    List<ExprNode> elements = new ArrayList<ExprNode>();


    public VectorNode(Token t, List<ExprNode> elements) {
        super(t);
        this.elements = elements;
    }

    /**
     * [a,b]
     */
    public void print() {
        System.out.print("[");
        if (elements != null) {
            for (int i = 0; i < elements.size(); i++) {
                ExprNode child = elements.get(i);
                if (i > 0) System.out.print(", ");
                child.print();
            }
        }
        System.out.print("]");
    }
}
