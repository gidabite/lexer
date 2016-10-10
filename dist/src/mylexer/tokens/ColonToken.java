package mylexer.tokens;

public class ColonToken implements Yytoken {
    private int line;
    private int charBegin;
    private int charEnd;
    public ColonToken(int line, int charBegin, int charEnd)
    {
        this.line = line;
        this.charBegin = charBegin;
        this.charEnd = charEnd;
    }

    @Override
    public String toString()
    {
        return "COLON(" + line + ";"+charBegin + ";" + charEnd+");";
    }
}
