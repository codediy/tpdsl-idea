package c_walking.a_embedded;

public class MultNode extends ExprNode {
    ExprNode left, right;


    public MultNode(ExprNode left, Token t, ExprNode right) {
        super(t);
        this.left = left;
        this.right = right;
    }

    /**
     * left * right
     */
    public void print() {
        left.print();
        System.out.print("*");
        right.print();
    }

}
