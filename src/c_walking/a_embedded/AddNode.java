package c_walking.a_embedded;

public class AddNode extends ExprNode {
    ExprNode left, right;

    public AddNode(ExprNode left, Token t, ExprNode right) {
        super(t);
        this.left = left;
        this.right = right;
    }

    public void print() {
        left.print();
        System.out.print("+");
        right.print();
    }
}
