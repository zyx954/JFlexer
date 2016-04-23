package org.ifn660.jflexer.ast;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public abstract class Node {

    public void printNodeReflection(int identSize) {

        Node.indent(identSize);
        System.out.println(this.getClass().getSimpleName()+"@1@"); // print the object//zyx: print the class name 
                                                           // itself first

        Node.indent(identSize);
        System.out.println("{"+"@2@");//zyx: this is just test 

        Field[] fields = this.getClass().getDeclaredFields(); // get all the
                                                              // attributes
                                                              // inside this
                                                              // object
//        System.out.println(fields+"^^^^^^^^");//zyx: this is test 

        try {
            for (Field field : fields) { // iterate through each field
                field.setAccessible(true); // make private method accessible

                

                if (Node.class.isAssignableFrom(field.getType())) {//zyx:@1 is "example  "this is just a string so not inherited from node.
                    //zyx: if the field is node.class it means it will call  the printNodeReflection() method recursively.
                    // if it is an attribute of type inherited from Node
                    // then print out the attribute's name first
                    Node.indent(identSize + 1);
                    System.out.println(field.getName() + ":");//zyx :here field.getName() --get the paramerater name.
                    // then recursively call the printNodeRelfection on this
                    // attribute
                    ((Node) field.get(this)).printNodeReflection(identSize + 2);//zyx: here call the printNodeReflection. recusively.
                    
                   
                    
                } else {//zyx: @1 the "example" come to here.
                    // if not then just print that attribute's value
                    // Node.indent(identSize + 1);
                    if (field.getType().equals(List.class)) {// here it seems it judge if the "example" is the class or not.
                        ParameterizedType genericTypes = (ParameterizedType) field.getGenericType();//zyx : ParameterizedType:--ParameterizedType represents a parameterized type such as Collection<String>. 
                        //zyx:  field.getGenericType(): "Returns a Type object that represents the declared type for the field represented by this Field object." 
                        Class<?> genericType = (Class<?>) genericTypes.getActualTypeArguments()[0];
                        //zyx:genericTypes.getActualTypeArguments()[0]--Returns an array of Type objects representing the actual type arguments to this type. 
                        //zyx:Class<?>--Instances of the class Class represent classes and interfaces in a running Java application. 
                        
                        if (Node.class.isAssignableFrom(genericType)) {//zyx: here judge if the parameter inside of the list is node class  or not. here is just "public/ static" so it is not the class 
                            Node.indent(identSize + 1);
                            System.out.println(field.getName() + ":");
                            List<Node> nodes = (List<Node>) field.get(this);
                            for(Node node : nodes) {
                                node.printNodeReflection(identSize + 3);
                            }
                        } else if (String.class.isAssignableFrom(genericType)) {//zyx :here judge if inside the list is the string or not / it is string "public/ static"
                            Node.indent(identSize + 1);
                            System.out.println(field.getName() + ": " + field.get(this));
                        }
                    } else {//zyx:@ 1 "example "come here
                        Node.indent(identSize + 1);
                        System.out.println(field.getName() + ": " + field.get(this));//zyx: print it.
                        //zyx:here field.getName()--"Returns the name of the field represented by this Field object." will return "public ClassDeclaration (String name, List<String> modifiers, ClassBody classBody)" from here. 
                        //zyx : field.get(this)--"Returns the value of the field represented by this Field, on the specified object"; which is example.
                    }
                }
            }
            
        } catch (Exception e) {
            System.err.println("Print node failed :");
            e.printStackTrace();
        }
        

        Node.indent(identSize);
        System.out.println(identSize+"###");
        System.out.println("}");
        
        
    }

    public static void indent(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("---");
        }
    }
}
