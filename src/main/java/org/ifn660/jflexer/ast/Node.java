package org.ifn660.jflexer.ast;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class Node {

    public void resolveNames(LexicalScope scope) {
    }

    public void printNodeReflection(int identSize) {

        Node.indent(identSize);
        System.out.println(this.getClass().getSimpleName()); // print the object itself first

        Node.indent(identSize);
        System.out.println("{");

        Field[] fields = this.getClass().getDeclaredFields(); // get all the attributes inside this object

        try {
            // if this a declaration statement, print the declaration object id
            if (Declaration.class.isInstance(this)) {
                Node.indent(identSize + 1);
                System.out.println("declaration id: [" + ((Declaration) this).hashCode() + "]");
            }
            
            for (Field field : fields) { // iterate through each field
                field.setAccessible(true); // make private method accessible

                if (Node.class.isAssignableFrom(field.getType())) {
                    // if it is an attribute of type inherited from Node
                    // then print out the attribute's name first
                    if (field.get(this) != null) {
                        Node.indent(identSize + 1);
                        System.out.println(field.getName() + ":");
                        // then recursively call the printNodeRelfection on this
                        // attribute
                        ((Node) field.get(this)).printNodeReflection(identSize + 2);
                    }
                } else {
                    // if not then just print that attribute's value
                    if (field.getType().equals(List.class)) {
                        ParameterizedType genericTypes = (ParameterizedType) field.getGenericType();
                        Class<?> genericType = (Class<?>) genericTypes.getActualTypeArguments()[0];

                        if (Node.class.isAssignableFrom(genericType)) {
                            Node.indent(identSize + 1);
                            System.out.println(field.getName() + ":");
                            List<Node> nodes = (List<Node>) field.get(this);
                            for (Node node : nodes) {
                                node.printNodeReflection(identSize + 3);
                            }
                        } else if (String.class.isAssignableFrom(genericType)) {
                            Node.indent(identSize + 1);
                            System.out.println(field.getName() + ": " + field.get(this));
                        }
                    } else if (field.getType().equals(Declaration.class)) {//zyx: getType(): Returns a Class object that identifies the declared type for the field represented by this Field object.
                        Node.indent(identSize + 1);
                        System.out.println("declaration reference : [" + field.get(this).hashCode() + "]");//declaration reference:----------
                    } else if (!field.getType().equals(LexicalScope.class)) {//zyx : euqal: Indicates whether some other object is "equal to" this one. 
                        Node.indent(identSize + 1);
                        System.out.println(field.getName() + ": " + field.get(this));//zyx: eg : x=42
                    } 
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
        for (int i = 0; i < n; i++) {
            System.out.print("   ");
        }
    }
}
