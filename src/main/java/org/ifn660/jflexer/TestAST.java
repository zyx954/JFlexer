package org.ifn660.jflexer;

import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TestAST {

	public static void main(String[] args) {
		 /* Start the parser */
        try {
            parser p = new parser(new Lexer(new FileReader("resources/" + args[0])));
            //Object result = p.parse().value; // Parses the value of a terminal
            p.parse();
            p.root.resolveNames(null);
            p.root.printNodeReflection(0);
    		File file = new File ("file.il");
    		if (file.exists()){
    			file.delete();
    		}
    		else { 
    			file.createNewFile();
    			}
    		
            p.root.codeGeneration(Paths.get("file.il"), null);
        } catch (Exception e) {
            /* do cleanup here -- possibly rethrow e */
            e.printStackTrace();
        }
	}

}
