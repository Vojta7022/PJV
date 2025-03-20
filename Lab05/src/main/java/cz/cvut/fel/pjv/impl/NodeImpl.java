package cz.cvut.fel.pjv.impl;

import cz.cvut.fel.pjv.Node;
import lombok.Setter;

public class NodeImpl implements Node {

    private final int value;
    @Setter
    private Node left;
    @Setter
    private Node right;

    public NodeImpl(int value) {
        this.value = value;
    }

    @Override
    public Node getLeft() {
        return left;
    }

    @Override
    public Node getRight() {
        return right;
    }

    @Override
    public int getValue() {
        return value;
    }
}
