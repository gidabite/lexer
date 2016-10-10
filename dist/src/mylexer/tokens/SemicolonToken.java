package mylexer.tokens;

public class SemicolonToken implements Yytoken {
    private int line;
    private int charBegin;
    private int charEnd;
    public SemicolonToken(int line, int charBegin, int charEnd)
    {
        this.line = line;
        this.charBegin = charBegin;
        this.charEnd = charEnd;
    }
    @Override
    public String toString()
    {
        return "SEMICOLON(" + line + ";"+charBegin + ";" + charEnd+");";
    }
}
