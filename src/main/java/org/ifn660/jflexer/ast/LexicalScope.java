package org.ifn660.jflexer.ast;

import java.util.HashMap;

//zyx : Hash table based implementation of the Map interface. This implementation provides all of the optional map operations, and permits null values and the null key. (The HashMap class is roughly equivalent to Hashtable, except that it is unsynchronized and permits nulls.) This class makes no guarantees as to the  order of the map;
import java.util.Map;
//zyx Map: An object that maps keys to values. A map cannot contain duplicate keys; each key can map to at most one value.  This interface takes the place of the Dictionary class, which was a totally abstract class rather than an interface. 

public class LexicalScope {
    LexicalScope parentScope;//zyx  inner class
    Map<String, Declaration> symbolTable; //zyx: get one map /hashtabl 
    
    public LexicalScope() {
        symbolTable = new HashMap<>();//one constructure , when new the LexicalScope class declare one hashMap.
    }
    
    public Declaration resolveHere(String symbol) {//a method which return a Declaration type variable.
        return symbolTable.get(symbol);
    }
    
    public Declaration resolve(String symbol) {
        Declaration local = resolveHere(symbol);
        if (local != null) {
            return local;
        } else if (parentScope != null) {
            return parentScope.resolve(symbol);
        } else {
            return null;
        }
    }
}
