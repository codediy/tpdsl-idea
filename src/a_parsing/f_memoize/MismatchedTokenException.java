package a_parsing.f_memoize;

public class MismatchedTokenException extends RecognitionException{
    public MismatchedTokenException(String message) {
        super(message);
    }
}
