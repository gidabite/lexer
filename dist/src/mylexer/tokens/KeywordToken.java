package mylexer.tokens;

public class KeywordToken implements Yytoken {
    private String kw;
    private int line;
    private int charBegin;
    private int charEnd;
    public KeywordToken(String kw, int line, int charBegin, int charEnd)
    {
        this.kw = kw;
        this.line = line;
        this.charBegin = charBegin;
        this.charEnd = charEnd;
    }
    @Override
    public String toString()
    {
        return "KEYWORD(" +kw + ";" + line + ";"+charBegin + ";" + charEnd+");";
    }
}


