package org.ifn660.jflexer;

import java.io.FileReader;

public class TestParser {
    @SuppressWarnings("deprecation")
    public static void main(String args[]) {
        /* Start the parser */
        try {
            parser p = new parser(new Lexer(new FileReader("resources/" + args[0])));
            //Object result = p.parse().value;
            p.debug_parse();
        } catch (Exception e) {
            /* do cleanup here -- possibly rethrow e */
            e.printStackTrace();
        }
    }
}
