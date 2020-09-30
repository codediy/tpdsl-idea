package c_walking.b_visitor;

import java.util.ArrayList;
import java.util.List;

public class StatListNode extends VecMathNode {
    public List<StatNode> elements = new ArrayList<StatNode>();

    public StatListNode(List<StatNode> elements) {
        super(new Token(Token.STAT_LIST));
        this.elements = elements;
    }

    @Override
    public void visit(VecMathVisitor visitor) {
        visitor.visit(this);
    }
}
