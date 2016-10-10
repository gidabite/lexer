package mylexer.tokens;

public class CommentToken implements Yytoken {
    private String text;
    private int lineBegin;
    private int lineEnd;
    private int charBegin;
    private int charEnd;
    public CommentToken(String text, int lineBegin, int charBegin, int lineEnd, int charEnd)
    {
        this.text = text;
        this.lineBegin = lineBegin;
        this.charBegin = charBegin;
        this.charEnd = charEnd;
        this.lineEnd = lineEnd;
    }
    @Override
    public String toString()
    {
        return "COMMENT(\"" + text + "\";"+ lineBegin + ";"+charBegin + ";" + lineEnd +";"+ charEnd+");";
    }
}
