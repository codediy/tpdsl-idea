package c_walking.a_embedded;

public abstract class VecMathNode extends HeteroAST {
    public VecMathNode() {

    }

    public VecMathNode(Token token) {
        super(token);
    }

    public void print() {
        System.out.print(
                token != null
                        ? token.toString()
                        : "<null>"
        );
    }
}
