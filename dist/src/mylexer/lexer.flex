/* this is the scanner example from the JLex website 
   (with small modifications to make it more readable) */
package mylexer;
import mylexer.tokens.*;
import mylexer.exceptions.*;
%%

%{
    private int line_begin = 0;
    private int char_begin = 0;
    private String comment = "";
%} 

%line
%char
%unicode
%state ML_COMMENT
%public
%column

LETTERS=[A-Za-z]
DIGITS=[0-9]
NUMBERS = {DIGITS}+{DIGITS}*
IDENTIFIER = ({LETTERS}|_)({LETTERS}|{DIGITS}|_)*
KEYWORD="skip"|"write"|"read"|"while"|"do"|"if"|"then"|"else"
IGNORE=[\n\r\t\b\012\s]
OL_COMMENT="//"+([^\n])*
ML_COMMENT_TEXT=([^*)]|"*"[^)])+
%%
<YYINITIAL> {
    {KEYWORD} {return (Yytoken)(new KeywordToken(yytext(), yyline, yycolumn, yycolumn+yylength()-1));}
    {IDENTIFIER} {return (Yytoken)(new VarToken(yytext(), yyline, yycolumn, yycolumn+yylength()-1));}
    {NUMBERS} {return (Yytoken)(new NumToken(yytext(),yyline, yycolumn, yycolumn+yylength()-1));}
    ":=" {return (Yytoken)(new OperationToken("ASSIGMENT", yyline,yycolumn,yycolumn+1));}
    ":" { return (Yytoken)(new SemicolonToken(yyline,yycolumn,yycolumn)); }
    ";" { return (Yytoken)(new ColonToken(yyline,yycolumn,yycolumn)); }
    "(" { return (Yytoken)(new LeftParenthesisToken(yyline,yycolumn,yycolumn)); }
    ")" { return (Yytoken)(new RightParenthesisToken(yyline,yycolumn,yycolumn)); }
    "+" { return (Yytoken)(new OperationToken("Plus",yyline,yycolumn,yycolumn)); }
    "-" { return (Yytoken)(new OperationToken("Minus",yyline,yycolumn,yycolumn)); }
    "*" { return (Yytoken)(new OperationToken("Mult",yyline,yycolumn,yycolumn)); }
    "/" { return (Yytoken)(new OperationToken("Div",yyline,yycolumn,yycolumn)); }
    "=" { return (Yytoken)(new OperationToken("Eq",yyline,yycolumn,yycolumn)); }
    "!=" { return (Yytoken)(new OperationToken("NotEq",yyline,yycolumn,yycolumn+1)); }
    "<=" { return (Yytoken)(new OperationToken("LessOrEq",yyline,yycolumn,yycolumn+1)); }
    "<"  { return (Yytoken)(new OperationToken("Less",yyline,yycolumn,yycolumn)); }
    ">=" { return (Yytoken)(new OperationToken("GreaterOrEq",yyline,yycolumn,yycolumn+1)); }
    ">"  { return (Yytoken)(new OperationToken("Greater",yyline,yycolumn,yycolumn)); }
    "&&"  { return (Yytoken)(new OperationToken("And",yyline,yycolumn,yycolumn+1)); }
    "||"  { return (Yytoken)(new OperationToken("Or",yyline,yycolumn,yycolumn+1)); }
    "%" { return (Yytoken)(new OperationToken("Mod",yyline,yycolumn,yycolumn)); }
    "**" { return (Yytoken)(new OperationToken("POWER",yyline,yycolumn,yycolumn+1)); }
    {IGNORE} {}
    {OL_COMMENT} {return (Yytoken)(new CommentToken(yytext().substring(2),yyline,yycolumn+2,yyline,yycolumn+yylength()-2)); }
    "(*" {yybegin(ML_COMMENT);  line_begin = yyline; char_begin = yycolumn; comment="";}
    "*)" {throw new TokenException(yytext(),yyline, yycolumn, yycolumn+yylength());}


    . {throw new TokenException(yytext(),yyline, yycolumn, yycolumn+yylength());}
}
<ML_COMMENT> {
    "(*" { }
    "*)" {
            yybegin(YYINITIAL);
            return (Yytoken)(new CommentToken(comment,line_begin,char_begin,yyline,yycolumn-1));
         }
     {ML_COMMENT_TEXT} { comment+=yytext();}
}