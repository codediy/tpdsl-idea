package b_ir.a_parsetree;

import java.util.ArrayList;
import java.util.List;

public abstract class ParseTree {
    /**
     * 子节点列表
     */
    public List<ParseTree> children;

    public RuleNode addChild(String value) {
        RuleNode r = new RuleNode(value);
        addChild(r);
        return r;
    }

    public TokenNode addChild(Token value) {
        TokenNode t = new TokenNode(value);
        addChild(t);
        return t;
    }

    public void addChild(ParseTree t) {
        if (children == null) {
            children = new ArrayList<ParseTree>();
        }
        children.add(t);
    }
}
