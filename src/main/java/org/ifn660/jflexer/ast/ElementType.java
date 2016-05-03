package org.ifn660.jflexer.ast;

public class ElementType extends Type {
	private IdentifierNode elementtype;

	public ElementType(IdentifierNode elementtype) {
		this.elementtype = elementtype;
	}

    @Override
    public boolean resolveName(LexicalScope scope) {
        return true;
    }
	
	
}
