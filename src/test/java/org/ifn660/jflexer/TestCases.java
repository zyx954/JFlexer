package org.ifn660.jflexer;

import java.io.FileReader;

import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("deprecation")
public class TestCases {
    
    @Test
    public void testPass() throws Exception {
        String[] filenames = {"PassCase1.java", "PassCase2.java", "PassCase3.java"};
        
        final int expectedPass = filenames.length;
        int actualPass  = 0;
        
        for (String filename : filenames) {
            System.out.println("File " + filename);
            parser p = new parser(new Lexer(new FileReader("resources/" + filename)));
            p.parse();
            actualPass++;
        }
        
        Assert.assertEquals(expectedPass, actualPass);
    }
    
    @Test
    public void testFail() {
        String[] filenames = {"FailCase1.java", "FailCase2.java", "FailCase3.java"};
        
        final int expectedFail = filenames.length;
        int actualFail = 0;
        
        for (String filename : filenames) {
            try {
                parser p = new parser(new Lexer(new FileReader("resources/" + filename)));
                p.parse();
                Assert.fail("Grammar fail with " + filename);
            } catch (Exception e) {
                actualFail++;
            }
        }
        
        Assert.assertEquals(expectedFail, actualFail);
    }
}
