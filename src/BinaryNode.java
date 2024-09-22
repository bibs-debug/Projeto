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

    public BinaryNode getRightNode() {
        return rightNode;
    }

    public BinaryNode getLeftNode() {
        return leftNode;
    }

    public BinaryNode getParent() {
        return parent;
    }

    public Object getValue() {
        return value;
    }

    // retorna a altura do nó (distância até o nó folha mais distante)
    public int getHeight() {
        int leftHeight = (leftNode != null) ? leftNode.getHeight() : -1;
        int rightHeight = (rightNode != null) ? rightNode.getHeight() : -1;
        return 1 + Math.max(leftHeight, rightHeight);
    }

    // método de visitação a ser implementado nas subclasses
    public float visit() {
        return 0;  // valor padrão, será sobrescrito nas subclasses
    }
}
