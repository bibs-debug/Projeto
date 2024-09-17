//Beatriz Lima de Moura RA: 10416616
//Beatriz Santos de Souza RA: 10417803
//Jessica Bispo RA: 10410798

package project;

public class BinaryNode {
    // nodes esquerda e direita
    private BinaryNode rightNode;
    private BinaryNode leftNode;
    // node pai
    private BinaryNode parent;
    // valor do node
    private String value;

    // Construtor com valor
    public BinaryNode(String value) {
        setValue(value); 
    }

    // Construtor com valor e nó pai
    public BinaryNode(String value, BinaryNode parent) {
        setValue(value);
        setParent(parent);
        setRightNode(null);
        setLeftNode(null);
    }

    public void setRightNode(BinaryNode rightNode) {
        this.rightNode = rightNode;
    }

    public BinaryNode getRightNode() {
        return rightNode;
    }

    public void setLeftNode(BinaryNode leftNode) {
        this.leftNode = leftNode;
    }

    public BinaryNode getLeftNode() {
        return leftNode;
    }

    public void setParent(BinaryNode parent) {
        this.parent = parent;
    }

    public BinaryNode getParent() {
        return parent;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
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
		if (isRoot() == true){
            return 0;
        }
		
		return 1 + parent.getLevel();
	}

    public int getHeight() {
		if (isLeaf() == true){
            return 0;
        }
		
		return 1 + Math.max(left == null ? 0 : left.getHeight(), //verifica se o filho esquerdo é nulo. Se for, considera a altura dele como 0. Se não for nulo, chama recursivamente o método getHeight() no filho esquerdo.
							right == null ? 0 : right.getHeight()); //Faz o mesmo para o filho direito. Se o filho direito for nulo, considera a altura dele como 0, senão calcula a altura recursivamente.
	}
}

