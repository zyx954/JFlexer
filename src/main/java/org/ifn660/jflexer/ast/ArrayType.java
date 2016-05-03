package org.ifn660.jflexer.ast;

public class ArrayType extends Type {
	private ElementType elementtype;

	public ArrayType(ElementType elementtype) {
		this.elementtype = elementtype;
	}

    @Override
    public boolean resolveName(LexicalScope scope) {
        return true;
    }
	
	
}
