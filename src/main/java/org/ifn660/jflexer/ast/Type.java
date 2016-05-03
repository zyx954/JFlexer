package org.ifn660.jflexer.ast;

public abstract class Type extends Node {
    public abstract boolean resolveName(LexicalScope scope);
}
