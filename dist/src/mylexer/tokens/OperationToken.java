package mylexer.tokens;

public class OperationToken implements Yytoken {
    private String op;
    private int line;
    private int charBegin;
    private int charEnd;
    public OperationToken(String op, int line, int charBegin, int charEnd)
    {
        this.op = op;
        this.line = line;
        this.charBegin = charBegin;
        this.charEnd = charEnd;
    }
    @Override
    public String toString()
    {
        return "OPERATION"+"(" +op+";"+ line + ";"+charBegin + ";" + charEnd+");";
    }
}
