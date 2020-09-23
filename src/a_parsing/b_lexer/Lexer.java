package a_parsing.b_lexer;

public abstract class Lexer {

    public static final char EOF = (char) -1;
    public static final int EOF_TYPE= 1;

    /*待解析字符串*/
    String input;
    /*input中当前解析位置*/
    int p = 0;
    /*input中当前待解析字符*/
    char c;

    public Lexer(String input){
        this.input = input;
        c = input.charAt(p);
    }

    /**
     * 移动到下个字符
     */
    public void consume(){
        p = p + 1;
        if(p >= input.length()){
            c = EOF;
        }else{
            c = input.charAt(p);
        }
    }

    /**
     * 预测下一个字符
     * @param x
     */
    public void match(char x){
        if( c== x){
            consume();
        }else{
            throw new Error("expecting"+x+"; found"+c);
        }
    }

    public abstract Token nextToken();
    public abstract String getTokenName(int tokenType);
}
