/* JFlex example: partial Java language lexer specification */
package org.ifn660.jflexer;

import org.ifn660.jflexer.symbol.Symbol;
import org.ifn660.jflexer.type.TokenType;

/**
 * This class is a simple example lexer.
 */
%%

%class Lexer
%type Symbol
%line
%column
%state STRING

%{
  StringBuffer string = new StringBuffer();

  private Symbol symbol(TokenType type) {
    return new Symbol(type, yyline, yycolumn);
  }
  private Symbol symbol(TokenType type, Object value) {
    return new Symbol(type, yyline, yycolumn, value);
  }
%}

LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace     = {LineTerminator} | [ \t\f]

/* comments */
Comment = {TraditionalComment} | {EndOfLineComment} | {DocumentationComment}

TraditionalComment   = "/*" [^*] ~"*/" | "/*" "*"+ "/"
// Comment can be the last line of the file, without line terminator.
EndOfLineComment     = "//" {InputCharacter}* {LineTerminator}?
DocumentationComment = "/**" {CommentContent} "*"+ "/"
CommentContent       = ( [^*] | \*+ [^/*] )*

Identifier = [:jletter:] [:jletterdigit:]*

DecIntegerLiteral = 0 | [1-9][0-9]*



%%


/* keywords */
<YYINITIAL> "abstract"           { return symbol(TokenType.ABSTRACT); }
<YYINITIAL> "boolean"            { return symbol(TokenType.BOOLEAN); }
<YYINITIAL> "break"              { return symbol(TokenType.BREAK); }
<YYINITIAL> "if"				 { return symbol(TokenType.IF); }
<YYINITIAL> "else"				 { return symbol(TokenType.ELSE); }


<YYINITIAL> {

/* identifiers */ 
  {Identifier}                   { return symbol(TokenType.IDENTIFIER); }
 
 
/* literals */
  {DecIntegerLiteral}            { return symbol(TokenType.INTEGER_LITERAL); }
  \"                             { string.setLength(0); yybegin(STRING); }


/* separators */
  "("                            { return symbol(TokenType.LPAREN); }
  ")"                            { return symbol(TokenType.RPAREN); }
  "{"                            { return symbol(TokenType.LBRACE); }
  "}"                            { return symbol(TokenType.RBRACE); }
  "["                            { return symbol(TokenType.LBRACK); }
  "]"                            { return symbol(TokenType.RBRACK); }
  ";"                            { return symbol(TokenType.SEMICOLON); }
  ","                            { return symbol(TokenType.COMMA); }
  "."                            { return symbol(TokenType.DOT); }


  /* operators */
  "="                            { return symbol(TokenType.EQ); }
  "=="                           { return symbol(TokenType.EQEQ); }
  "+"                            { return symbol(TokenType.PLUS); }


  /* comments */
  {Comment}                      { /* ignore */ }
 
 
  /* whitespace */
  {WhiteSpace}                   { /* ignore */ }
  
}


<STRING> {
  \"                             { yybegin(YYINITIAL); 
                                   return symbol(TokenType.STRING_LITERAL, 
                                   string.toString()); }
  [^\n\r\"\\]+                   { string.append( yytext() ); }
  \\t                            { string.append('\t'); }
  \\n                            { string.append('\n'); }
  \\r                            { string.append('\r'); }
  \\\"                           { string.append('\"'); }
  \\                             { string.append('\\'); }
}


<<EOF>>     {return symbol(TokenType.EOF);}
/* error fallback */
[^]                              { return symbol(TokenType.UNKNOWN); }