package b_ir.d_hetero;

public abstract class HeteroAST {
    Token token;

    public HeteroAST() {
    }

    public HeteroAST(Token token) {
        this.token = token;
    }

    public HeteroAST(int tokenType) {
        this.token = new Token(tokenType);
    }

    public String toString() {
        return token.toString();
    }

    public String toStringTree() {
        return toString();
    }
}
