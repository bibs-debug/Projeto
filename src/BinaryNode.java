//Beatriz Lima de Moura     RA: 10416616
//Beatriz Santos de Souza   RA: 10417803
//Jessica Bispo             RA: 10410798

package src;

public class BinaryNode {

    private BinaryNode rightNode;
    private BinaryNode leftNode;
    private BinaryNode parent;
    private Object value;

    public BinaryNode(Object value) {
        this.value = value;
    }

    public BinaryNode(Object value, BinaryNode parent) {
        this.value = value;
        this.parent = parent;
        this.rightNode = null;
        this.leftNode = null;
    }

    public void setRightNode(BinaryNode rightNode) {
        this.rightNode = rightNode;
    }
        

    public void setLeftNode(BinaryNode leftNode) {
        this.leftNode = leftNode;
    }

    
    public void setParent(BinaryNode parent) {
        this.parent = parent;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public BinaryNode getLeftNode() {
        return leftNode;
    }

    public BinaryNode getRightNode() {
        return rightNode;
    }

    public BinaryNode getParent() {
        return parent;
    }

    public Object getValue() {
        return value;
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
            getRightNode() == null ? 0 : getRightNode().getHeight()
        );
    }

    public boolean isRoot() {
        return parent == null;
    }
    
    public boolean isLeaf() {
        return getRightNode() == null && getLeftNode() == null;
    }

    public int degree() {
        int degree = 0;
        if (getLeftNode() != null) degree++;
        if (getRightNode() != null) degree++;
        return degree;
    }

    public float visit() {
        return Float.NaN;
    }

    public void print() {
        throw new UnsupportedOperationException("Unimplemented method 'print'");
    }
}
