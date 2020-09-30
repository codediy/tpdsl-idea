package b_ir.d_hetero;

import java.util.ArrayList;
import java.util.List;

public class ListNode extends HeteroAST {

    List<HeteroAST> elements = new ArrayList<HeteroAST>();

    public ListNode(List<HeteroAST> elements) {
        this.elements = elements;
    }

    public String toStringTree() {
        if (elements == null || elements.size() == 0) {
            return this.toString();
        }
        StringBuilder buf = new StringBuilder();
        for (int i = 0; elements != null && i < elements.size(); i++) {
            HeteroAST t = (HeteroAST) elements.get(i);
            if (i > 0) {
                buf.append(" ");
            }
            buf.append(t.toStringTree());
        }
        return buf.toString();
    }
}
