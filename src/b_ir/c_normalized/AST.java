package b_ir.c_normalized;

import java.util.ArrayList;
import java.util.List;

public class AST {
    Token token;
    List<AST> children;


    public AST() {
    }

    public AST(Token token) {
        this.token = token;
    }

    public AST(int tokenType) {
        this.token = new Token(tokenType);
    }

    public int getNodeType() {
        return token.type;
    }

    public void addChild(AST t) {
        if (children == null) {
            children = new ArrayList<AST>();
        }
        children.add(t);
    }

    public boolean isNil() {
        return token == null;
    }

    public String toString() {
        return token.toString();
    }

    public String toStringTree() {
        if (children == null || children.size() == 0) {
            return this.toString();
        }
        StringBuilder buf = new StringBuilder();
        /**
         * Token
         */
        if (!isNil()) {
            buf.append("(");
            buf.append(this.toString());
            buf.append(" ");
        }

        /**
         * children
         */
        for (int i = 0; children != null && i < children.size(); i++) {
            AST t = (AST) children.get(i);
            if (i > 0) {
                buf.append(" ");
            }
            buf.append(t.toStringTree());
        }

        if (!isNil()) {
            buf.append(")");
        }
        return buf.toString();
    }


}
