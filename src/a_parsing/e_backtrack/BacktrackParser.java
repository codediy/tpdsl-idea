package a_parsing.e_backtrack;

public class BacktrackParser extends Parse {

    public BacktrackParser(Lexer input) {
        super(input);
    }

    /**
     * stat : list EOF | assign EOF ;
     *
     * @throws RecognitionException
     */
    public void stat() throws RecognitionException {
        if (speculate_stat_alt1()) {
            list();
            match(Lexer.EOF_TYPE);
        } else if (speculate_stat_alt2()) {
            assign();
            match(Lexer.EOF_TYPE);
        } else {
            throw new NoViableAltException("expecting stat found " + LT(1));
        }
    }

    public boolean speculate_stat_alt1() {
        boolean success = true;
        mark();    /*标记起始点*/
        try {
            list();
            match(Lexer.EOF_TYPE);
        } catch (RecognitionException e) {
            success = false;
        }
        release();  /*返回起始点*/
        return success;
    }

    public boolean speculate_stat_alt2() {
        boolean success = true;
        mark();
        try {
            assign();
            match(Lexer.EOF_TYPE);
        } catch (RecognitionException e) {
            success = false;
        }
        release();
        return success;
    }

    /**
     * assign : list '=' list ;
     */
    public void assign() throws RecognitionException {
        list();
        match(BacktrackLexer.EQUALS);
        list();
    }

    /**
     * list : '[' elements ']' ;
     *
     * @throws RecognitionException
     */
    public void list() throws RecognitionException {
        match(BacktrackLexer.LBRACK);
        elements();
        match(BacktrackLexer.RBRACK);
    }

    /**
     * elements : element (',' element)* ;
     */
    void elements() throws RecognitionException {
        element();
        while (LA(1) == BacktrackLexer.COMMA) {
            match(BacktrackLexer.COMMA);
            element();
        }
    }

    /**
     * element : name '=' NAME | NAME | list ;
     *
     * @throws RecognitionException
     */
    void element() throws RecognitionException {
        if (LA(1) == BacktrackLexer.NAME
                && LA(2) == BacktrackLexer.EQUALS) {
            match(BacktrackLexer.NAME);
            match(BacktrackLexer.EQUALS);
            match(BacktrackLexer.NAME);
        } else if (LA(1) == BacktrackLexer.NAME) {
            match(BacktrackLexer.NAME);
        } else if (LA(1) == BacktrackLexer.LBRACK) {
            list();
        } else {
            throw new NoViableAltException("expecting element found " + LT(1));
        }
    }
}
