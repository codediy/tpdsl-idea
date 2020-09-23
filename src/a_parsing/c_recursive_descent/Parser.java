package a_parsing.c_recursive_descent;

public class Parser {

    Lexer input;
    Token lookahead;

    public Parser(Lexer input){
        this.input = input;
        consume();
    }

    /**
     * 预测下一个Token
     * @param x
     */
    public void match(int x){
        if(lookahead.type == x){
            consume();
        }else{
            throw new Error("expecting "+input.getTokenName(x)+
                    "; found "+ lookahead);
        }
    }

    /**
     * 移动到下一个Token
     */
    public void consume(){
        lookahead = input.nextToken();
    }
}
