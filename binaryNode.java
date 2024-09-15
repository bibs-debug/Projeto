package project;

public class BinaryNode<T> {
    // nodes esquerda e direita
    private BinaryNode<T> rightNode;
    private BinaryNode<T> leftNode;
    // node pai
    private BinaryNode<T> parent;
    // valor do node
    private T value;

    // Construtor com valor
    public BinaryNode(T value) {
        this.value = value;
    }

    // Construtor com valor e nó pai
    public BinaryNode(T value, BinaryNode<T> parent) {
        this.value = value;
        this.parent = parent;
        this.rightNode = null;
        this.leftNode = null;
    }

    public void setRightNode(BinaryNode<T> rightNode) {
        this.rightNode = rightNode;
    }

    public BinaryNode<T> getRightNode() {
        return rightNode;
    }

    public void setLeftNode(BinaryNode<T> leftNode) {
        this.leftNode = leftNode;
    }

    public BinaryNode<T> getLeftNode() {
        return leftNode;
    }

    public void setParent(BinaryNode<T> parent) {
        this.parent = parent;
    }

    public BinaryNode<T> getParent() {
        return parent;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public boolean isRoot() {
        return parent == null;
    }

    public boolean isLeaf() {
        return getRightNode() == null && getLeftNode() == null;
    }

    public int degree() {
        int degree = 0;
        if (getRightNode() != null) {
            degree++;
        }
        if (getLeftNode() != null) {
            degree++;
        }
        return degree;
    }

    public int getLevel() {
        if (isRoot()) {
            return 0;
        }
        return 1 + parent.getLevel();
    }

    public int getHeight() {
        if (isLeaf()) {
            return 0;
        }
        return 1 + Math.max(
            getLeftNode() == null ? 0 : getLeftNode().getHeight(),
            getRightNode() == null ? 0 : getRightNode().getHeight());
    }
}


