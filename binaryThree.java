package projeto;

public class BinaryThree {

    private BinaryNode root;

    public BinaryNode getRoot(){
        return root;
    }

    public boolean isEmpty() {
		return root == null;
	}

    public int getDegree() {
        if (isEmpty()) {
            return -1;
        }
        return getDegree(root);  // Usa um método auxiliar recursivo
    }
    
    // Método auxiliar recursivo para calcular o grau de todos os nós
    private int getDegree(BinaryNode node) {
        if (node == null) {
            return 0;  // Um nó nulo tem grau 0
        }
        
        // Calcula o grau do nó atual
        int nodeDegree = 0;
        if (node.getLeft() != null) nodeDegree++;
        if (node.getRight() != null) nodeDegree++;
        
        // Calcula recursivamente o grau dos nós filhos
        int leftDegree = getDegree(node.getLeft());
        int rightDegree = getDegree(node.getRight());
        
        // O grau da árvore é o maior entre o grau do nó atual e o dos filhos
        return Math.max(nodeDegree, Math.max(leftDegree, rightDegree));
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
	// Nesta implementação, percorrer a árvore significa visitar os nós
	// da árvore e exibir o conteúdo de cada nó na saída padrão do sistema (ex. terminal/tela).
	public void inOrderTraversal() {
		inOrderTraversal(root);
	}
	
	private void inOrderTraversal(BinaryNode root) {
		if (root != null) {
			inOrderTraversal(root.getLeft());
			System.out.print(root.getKey() + "  ");
			inOrderTraversal(root.getRight());
		}
	}
	
	// preOrderTraversal()
	// Percorre a árvore em pré-ordem (NLR).
	public void preOrderTraversal() {
		preOrderTraversal(root);
	}
	
	private void preOrderTraversal(BinaryNode root) {
		if (root != null) {
			System.out.print(root.getKey() + "  ");
			preOrderTraversal(root.getLeft());
			preOrderTraversal(root.getRight());
		}
	}
	
	// postOrderTraversal()
	// Percorre a árvore em pós-ordem (LRN).
	public void postOrderTraversal() {
		postOrderTraversal(root);
	}
	
	private void postOrderTraversal(BinaryNode root) {
		if (root != null) {
			postOrderTraversal(root.getLeft());
			postOrderTraversal(root.getRight());
			System.out.print(root.getKey() + "  ");
		}
	}
	
}
    

