package c_walking.b_visitor;

public interface VecMathVisitor {
    void visit(AssignNode n);

    void visit(PrintNode n);

    void visit(StatListNode n);

    void visit(VarNode n);

    void visit(AddNode n);

    void visit(DotProductNode n);

    void visit(IntNode n);

    void visit(MultNode n);

    void visit(VectorNode n);
}
