package project;

import project.BinaryNode;

public class BinaryTree<T> {

    private BinaryNode<T> root;

    public BinaryNode<T> getRoot() {
        return root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int getDegree() {
        if (isEmpty()) {
            return -1;
        }
        return getDegree(root);
    }

    private int getDegree(BinaryNode<T> root) {
		if (root == null || root.isLeaf())
			return 0;
		
		int degree = root.getDegree();
		
		int leftDegree = getDegree(root.getLeftNode());
		int rightDegree = getDegree(root.getRightNode());
		return Math.max(degree, Math.max(leftDegree, rightDegree));
	}
	

    // getHeight()
    // Retorna a altura da árvore (int).
    public int getHeight() {
        if (isEmpty()) {
            return -1;
        }

        return root.getHeight();
    }

    // inOrderTraversal()
    // Percorre a árvore em ordem (LNR --> L = Left, N = Node, R = Right).
    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(BinaryNode<T> node) {
        if (node != null) {
            inOrderTraversal(node.getLeftNode());
            System.out.print(node.getValue() + "  ");
            inOrderTraversal(node.getRightNode());
        }
    }

    // preOrderTraversal()
    // Percorre a árvore em pré-ordem (NLR).
    public void preOrderTraversal() {
        preOrderTraversal(root);
    }

    private void preOrderTraversal(BinaryNode<T> node) {
        if (node != null) {
            System.out.print(node.getValue() + "  ");
            preOrderTraversal(node.getLeftNode());
            preOrderTraversal(node.getRightNode());
        }
    }

    // postOrderTraversal()
    // Percorre a árvore em pós-ordem (LRN).
    public void postOrderTraversal() {
        postOrderTraversal(root);
    }

    private void postOrderTraversal(BinaryNode<T> node) {
        if (node != null) {
            postOrderTraversal(node.getLeftNode());
            postOrderTraversal(node.getRightNode());
            System.out.print(node.getValue() + "  ");
        }
    }
}
    

