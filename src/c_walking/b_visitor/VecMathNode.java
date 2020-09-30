package c_walking.b_visitor;

public abstract class VecMathNode extends HeteroAST {
    public VecMathNode() {
    }

    public VecMathNode(Token token) {
        super(token);
    }

    /**
     * 添加访问器
     * @param visitor
     */
    public abstract void visit(VecMathVisitor visitor);
}
