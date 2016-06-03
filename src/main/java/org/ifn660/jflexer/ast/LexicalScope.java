package org.ifn660.jflexer.ast;

import java.util.HashMap;
import java.util.Map;

//this class mainly with one hashmap and one 
// LexicalSope x = new LscicalScope  ()  x.parentScope.parentScope.parentScope/.
// this is a recuision ;
// I do not know hwo this data stucutre looks like 
//.this is like the method recuison  -- with in the method we call hte method
//.here is a class with in the class we  state on one variable which is itself.
//so when we initialize one instance(test) for this class . this test is this class and I can use test.parentScope.  parentScope is the variable ofthis calss so I can use the 
public class LexicalScope {
    LexicalScope parentScope;//within this class we inintiala the class itself
    //--actually I think here is quite tracky,
    Map<String, Declaration> symbolTable;//
    
    public LexicalScope() {
        symbolTable = new HashMap<>();
        
    }
    
    public Declaration resolveHere(String symbol) {
        return symbolTable.get(symbol);
    }
    
    public Declaration resolve(String symbol) {
        Declaration local = resolveHere(symbol);
        if (local != null) {
            return local;
        } else if (parentScope != null) {
            return parentScope.resolve(symbol);// this variable will call it self .
        } else {
            return null;
        }
    }
}
