package com.mycompany.csc229_bst_example;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private BstNode root;

    // Check if the tree is empty
    public boolean isEmpty() {
        return (this.root == null);
    }

    // Insert a new node with the given data
    public void insert(Integer data) {

        System.out.print("[input: " + data + "]");
        if (root == null) {
            this.root = new BstNode(data);
            System.out.println(" -> inserted: " + data);
            return;
        }
        insertNode(this.root, data);
        System.out.print(" -> inserted: " + data);
        System.out.println();
    }

    // Recursively insert a new node in the tree
    private BstNode insertNode(BstNode root, Integer data) {

        BstNode tmpNode = null;
        System.out.print(" ->" + root.getData());
        if (root.getData() >= data) {
            System.out.print(" [L]");
            if (root.getLeft() == null) {
                root.setLeft(new BstNode(data));
                return root.getLeft();
            } else {
                tmpNode = root.getLeft();
            }
        } else {
            System.out.print(" [R]");
            if (root.getRight() == null) {
                root.setRight(new BstNode(data));
                return root.getRight();
            } else {
                tmpNode = root.getRight();
            }
        }
        return insertNode(tmpNode, data);
    }

    // Perform in-order traversal of the tree
    public void inOrderTraversal() {
        doInOrder(this.root);
    }

    // Recursively perform in-order traversal
    private void doInOrder(BstNode root) {
        if (root != null) {
            doInOrder(root.getLeft());
            System.out.print(root.getData() + " ");
            doInOrder(root.getRight());
        }
    }

    // Perform pre-order traversal of the tree
    public void preOrderTraversal() {
        doPreOrder(this.root);
    }

    // Recursively perform pre-order traversal
    private void doPreOrder(BstNode root) {
        if (root != null) {
            System.out.print(root.getData() + " ");
            doPreOrder(root.getLeft());
            doPreOrder(root.getRight());
        }
    }

    // Find the height of the tree
    public Integer findHeight() {
        return findHeight(this.root);
    }

    // Recursively find the height of the tree
    private Integer findHeight(BstNode node) {
        if (node == null) {
            return -1;
        }
        int leftHeight = findHeight(node.getLeft());
        int rightHeight = findHeight(node.getRight());
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Get the depth of a node in the tree
    public int getDepth(BstNode node) {
        return getDepth(this.root, node, 0);
    }

    // Recursively get the depth of a node in the tree
    private int getDepth(BstNode root, BstNode node, int depth) {
        if (root == null) {
            return -1;
        }
        if (root.getData().equals(node.getData())) {
            return depth;
        }
        int leftDepth = getDepth(root.getLeft(), node, depth + 1);
        if (leftDepth != -1) {
            return leftDepth;
        }
        return getDepth(root.getRight(), node, depth + 1);
    }
    
    // Print the tree
    public void print() {
        System.out.println("\n==== BST Print ===== \n");
        print("", root, false);
    }

    // Helper method to print the tree with prefixes to indicate branches
    private void print(String prefix, BstNode node, boolean isLeft) {
        if (node != null) {
            print(prefix + (isLeft ? "|-- " : "|__ "), node.getRight(), false);
            System.out.println(prefix + (isLeft ? "|-- " : "|__ ") + node.getData());
            print(prefix + (isLeft ? "|-- " : "|__ "), node.getLeft(), true);
        }
    }
}
