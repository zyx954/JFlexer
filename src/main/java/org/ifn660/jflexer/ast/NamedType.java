package org.ifn660.jflexer.ast;

public class NamedType extends Type {
	private String nametype;

	public NamedType(String nametype) {
		this.nametype = nametype;
	}

    @Override
    public boolean resolveName(LexicalScope scope) {
        return true;
    }
	
}