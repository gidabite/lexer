package mylexer.exceptions;

/**
 * Created by sofysmo on 04.10.16.
 */
public class TokenException extends RuntimeException{
    public TokenException() {
        super();
    }

    public TokenException(String s, int line, int charBegin, int charEnd) {
        super("Unrecognized token \"" + s+"\" ("+line+","+charBegin+","+charEnd+")");
    }
    public TokenException(String s) {
        super(s);
    }
    public TokenException(String s, Throwable throwable) {
        super(s, throwable);
    }
    public TokenException(Throwable throwable) {
        super(throwable);
    }
}
