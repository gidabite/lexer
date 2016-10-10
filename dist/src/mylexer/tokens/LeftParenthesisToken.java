package mylexer.tokens;

public class LeftParenthesisToken implements Yytoken {
    private int line;
    private int charBegin;
    private int charEnd;
    public LeftParenthesisToken(int line, int charBegin, int charEnd)
    {
        this.line = line;
        this.charBegin = charBegin;
        this.charEnd = charEnd;
    }
    @Override
    public String toString()
    {
        return "LEFTPARENTHESIS(" + line + ";"+charBegin + ";" + charEnd + ");";
    }
}
