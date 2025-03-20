package cz.cvut.fel.pjv.impl;

import cz.cvut.fel.pjv.Node;
import cz.cvut.fel.pjv.Tree;

public class TreeImpl implements Tree {

    private Node root;

    public TreeImpl() {
        this.root = null;
    }

    @Override
    public void setTree(int[] values) {
        if (values == null || values.length == 0) {
            root = null;
        } else {
            root = buildTree(values, 0, values.length - 1);
        }
    }

    private Node buildTree(int[] values, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        if ((end - start + 1) % 2 == 0) {
            mid++;
        }
        NodeImpl node = new NodeImpl(values[mid]);
        node.setLeft(buildTree(values, start, mid - 1));
        node.setRight(buildTree(values, mid + 1, end));
        return node;

    }

    @Override
    public Node getRoot() {
        return root;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb, 0);
        return sb.toString();
    }

    private void buildString(Node node, StringBuilder sb, int depth) {
        if (node == null) {
            return;
        }
        sb.append(" ".repeat(Math.max(0, depth)));
        sb.append("- ").append(node.getValue()).append("\n");
        buildString(node.getLeft(), sb, depth + 1);
        buildString(node.getRight(), sb, depth + 1);
    }

}
