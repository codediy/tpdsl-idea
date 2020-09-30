package c_walking.a_embedded;

public class PrintNode extends StatNode {
    ExprNode value;

    public PrintNode(Token token, ExprNode value) {
        super(token);
        this.value = value;
    }

    /**
     * print value
     */
    public void print(){
        System.out.print("print ");
        value.print();
        System.out.println();
    }
}
