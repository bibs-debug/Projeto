package projeto;

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

    public BinaryNode<T> search(BinaryNode<T> node, T data) {
        if (node == null) {
            return null;
        }

        if (data.compareTo(node.getValue()) == 0) {
            return node; // Nó encontrado
        } else if (data.compareTo(node.getValue()) < 0) {
            return search(node.getLeftNode(), data);
        } else {
            return search(node.getRightNode(), data);
        }
    }
    // Método de inserção (insert)
    public BinaryNode<T> insert(BinaryNode<T> node, T data) {
        if (node == null) {
            node = new BinaryNode<>(data);
            return node;
        }

        if (data.compareTo(node.getValue()) < 0) {
            node.setLeftNode(insert(node.getLeftNode(), data));
        } else if (data.compareTo(node.getValue()) > 0) {
            node.setRightNode(insert(node.getRightNode(), data));
        } else {
            throw new RuntimeException("Valor já existe na árvore: " + data);
        }

        return node;
    }

    
    // Método de remoção (remove)
    public BinaryNode<T> remove(BinaryNode<T> node, T value) {
        if (isEmpty()) {
            throw new RuntimeException("Árvore vazia");
        }
        
        remove(BinaryNode<T> node, T value) {
            if (node == null) {
                throw new RuntimeException("Valor não encontrado na árvore: " + value);
            }
        
            if (value.compareTo(node.getValue()) == 0) {
                // Caso 1: O nó a ser removido não tem filhos (nó folha)
                if (node.getLeftNode() == null && node.getRightNode() == null) {
                    return null;
                }
            }
                // Caso 2: O nó a ser removido tem apenas o filho à direita
            else if (node.getLeftNode() == null) {
                return node.getRightNode();
            }
            
            // Caso 3: O nó a ser removido tem apenas o filho à esquerda
            else if (node.getRightNode() == null) {
                return node.getLeftNode();
            }
            
        // Caso 4: O nó a ser removido tem dois filhos
        else {
            BinaryNode<T> rightSubtree = node.getRightNode();  // Subárvore direita
            BinaryNode<T> successor = node.getRightNode();      // Sucessor (menor valor da subárvore direita)
            
            // Encontrar o menor valor na subárvore direita (sucessor)
            while (successor.getLeftNode() != null) {
                successor = successor.getLeftNode();
            }
            
            // O sucessor assume o lugar do nó removido
            successor.setLeftNode(node.getLeftNode()); // Conecta o filho esquerdo do nó removido
            return rightSubtree; // Retorna o novo nó após a remoção
        }
    } 
        // Recurre para o filho direito se o valor for maior
        else if (value.compareTo(node.getValue()) > 0) {
            node.setRightNode(remove(node.getRightNode(), value));
        } 
        // Recurre para o filho esquerdo se o valor for menor
        else {
            node.setLeftNode(remove(node.getLeftNode(), value));
        }
        
        return node;
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
