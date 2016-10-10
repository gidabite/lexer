package mylexer.tokens;

public class NumToken implements Yytoken {
    private String num;
    private int line;
    private int charBegin;
    private int charEnd;
    public NumToken(String num, int line, int charBegin, int charEnd)
    {
        this.num = num;
        this.line = line;
        this.charBegin = charBegin;
        this.charEnd = charEnd;
    }
    @Override
    public String toString()
    {
        return "NUMBERS(" + num + ";" + line + ";"+charBegin + ";" + charEnd+");";
    }
}
