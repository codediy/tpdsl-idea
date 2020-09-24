package a_parsing.e_backtrack;

public class MismatchedTokenException extends RecognitionException {
    public MismatchedTokenException(String msg) {
        super(msg);
    }
}