package org.ifn660.jflexer.ast;

import java.lang.reflect.Field;

public abstract class Node {
    
//    public void printNode() throws IllegalArgumentException, IllegalAccessException {
//        Field[] fields = this.getClass().getDeclaredFields();
//        for (Field field : fields) {
//            field.setAccessible(true);
//            if (field.getClass().equals(Node.class)) {
//                field.get
//            }
//            System.out.println(field.get(this));
//        }
//    }
    
    public abstract void printNode();
}
