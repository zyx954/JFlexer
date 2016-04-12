package org.ifn660.jflexer.ast;

import java.lang.reflect.Field;

public abstract class Node {
    
    public void printNodeReflection(int identSize) {
        
        Node.indent(identSize);
        System.out.println(this.getClass().getSimpleName()); // print the object itself first
        
        Node.indent(identSize);
        System.out.println("{");
        
        Field[] fields = this.getClass().getDeclaredFields(); // get all the attributes inside this object
        
        try {
            //for (int i = 0; i < size; i++) 
            //x = 
            for (Field field : fields) { // iterate through each field
                field.setAccessible(true); // make private method accessible
                
                Node.indent(identSize + 1);
                
                if (Node.class.isAssignableFrom(field.getType())) {
                    // if it is an attribute of type inherited from Node
                    // then print out the attribute's name first
                    System.out.println(field.getName() + ":");
                    // then recursively call the printNodeRelfection on this attribute
                    ((Node)field.get(this)).printNodeReflection(identSize + 2);
                } else {
                    // if not then just print that attribute's value
                    //Node.indent(identSize + 1);
                    System.out.println(field.getName() + ": " + field.get(this));
                }
            }
        } catch (Exception e) {
            System.err.println("Print node failed :");
            e.printStackTrace();
        }
        
        Node.indent(identSize);
        System.out.println("}");
    }
    
    public static void indent(int n) {
        for(int i = 0; i < n; i++) {
            System.out.print("   ");
        }
    }
}
