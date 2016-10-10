package mylexer.tokens;

public class RightParenthesisToken implements Yytoken {
    private int line;
    private int charBegin;
    private int charEnd;
    public RightParenthesisToken(int line, int charBegin, int charEnd)
    {
        this.line = line;
        this.charBegin = charBegin;
        this.charEnd = charEnd;
    }
    @Override
    public String toString()
    {
        return "RIGHTPARENTHESIS(" + line + ";"+charBegin + ";" + charEnd + ");";
    }
}
