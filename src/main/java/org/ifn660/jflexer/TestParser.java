package org.ifn660.jflexer;

import java.io.FileReader;

public class TestParser {
    public static void main(String args[]) {
        /* Start the parser */
        try {
            parser p = new parser(new Lexer(new FileReader("resources" + "/" + args[0])));
            Object result = p.parse().value;
            System.out.println(result);
        } catch (Exception e) {
            /* do cleanup here -- possibly rethrow e */
            e.printStackTrace();
        }
    }
}
