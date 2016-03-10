// UserCode

// this is the place to put package declarations and import statements. 
// It is possible, but not considered good Java style to put helper classes, such as token classes, into this section
package org.ifn660.jflexer;

import static org.ifn660.jflexer.type.TokenType.*;
import org.ifn660.jflexer.type.TokenType;

%%
// Options and declarations

// this is to tell the yyflex scanner method to return an object of type TokenType
%type TokenType

%%
// Lexical rules

[a-zA-Z]   {return CHARACTER;}
[0-9]   {return DIGIT;}
[,]     {return COMMA;}
[ ]    {return SPACE;}
<<EOF>>     {return EOF;}