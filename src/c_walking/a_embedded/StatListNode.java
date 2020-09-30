package c_walking.a_embedded;

import java.util.ArrayList;
import java.util.List;

public class StatListNode extends VecMathNode {
    List<StatNode> elements = new ArrayList<StatNode>();

    public StatListNode(List<StatNode> elements) {
        super(new Token(Token.STAT_LIST));
        this.elements = elements;
    }

    public void print() {
        for (VecMathNode n : elements) {
            n.print();
        }
    }
}
