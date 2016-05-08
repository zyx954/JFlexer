package org.ifn660.jflexer;

import java.io.FileReader;

public class TestAST {

	public static void main(String[] args) {
		 /* Start the parser */
        try {
            parser p = new parser(new Lexer(new FileReader("resources/" + args[0])));// here will save all the informaiton into root variable.
            //Object result = p.parse().value; // Parses the value of a terminal
            p.parse();
            p.root.resolveNames(null);//zyx what is this used for?
            p.root.printNodeReflection(0);//zyx : here is just print the tree structure out.
        } catch (Exception e) {
            /* do cleanup here -- possibly rethrow e */
            e.printStackTrace();
        }
	}

}
