package c_walking.a_embedded;

public class AssignNode extends StatNode {
    VarNode id;
    ExprNode value;

    public AssignNode(VarNode id, Token token, ExprNode value) {
        super(token);
        this.id = id;
        this.value = value;
    }

    /**
     * id = value
     */
    public void print() {
        id.print();
        System.out.print("=");
        value.print();
        System.out.println();
    }

}
