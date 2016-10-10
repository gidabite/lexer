package mylexer.tokens;

public class VarToken implements Yytoken {
    private String x;
    private int line;
    private int charBegin;
    private int charEnd;
    public VarToken(String x, int line, int charBegin, int charEnd)
    {
        this.x = x;
        this.line = line;
        this.charBegin = charBegin;
        this.charEnd = charEnd;
    }
    @Override
    public String toString()
    {
        return "VARIABLE(\"" + x + "\";" + line + ";"+charBegin + ";" + charEnd+");";
    }

}
