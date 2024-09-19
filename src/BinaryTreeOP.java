//Beatriz Lima de Moura     RA: 10416616
//Beatriz Santos de Souza   RA: 10417803
//Jessica Bispo             RA: 10410798

package src;

public class BinaryTreeOP {

	private BinaryNode root;
	
	public BinaryNode getRoot() { 
		return root; 
	}

	public void setRoot(BinaryNode root) { 
		this.root = root;
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
	
	// preOrderTraversal()
	// Percorre a árvore em pré-ordem (NLR).
	public void preOrderTraversal() {
		preOrderTraversal(root);
	}

	// postOrderTraversal()
	// Percorre a árvore em pós-ordem (LRN).
	public void postOrderTraversal() {
		postOrderTraversal(root);
	}

	public void insertExpression(String expression) {

	 	expression = new VeryBasicTokenizer(expression).tokenize();

		root = buildTree(expression.trim()); 
	}
	
	public void printTree() {
		if (isEmpty()) {
			System.out.println("Árvore vazia.");
		} else {
			printTree(root, 0);
		}
	}

	private BinaryNode buildTree(String expression) {
		expression = expression.trim();
	
		if (isNumber(expression)) {
			return new BinaryNode(expression);
		}
	
		if (expression.startsWith("(") && expression.endsWith(")")) {
			return buildTree(expression.substring(1, expression.length() - 1));
		}
	
		int operatorIndex = findMainOperator(expression);
	
		BinaryNode root = new BinaryNode(Character.toString(expression.charAt(operatorIndex)));
	
		root.setLeftNode(buildTree(expression.substring(0, operatorIndex).trim()));
		root.setRightNode(buildTree(expression.substring(operatorIndex + 1).trim()));
	
		return root;
	}

	private int findMainOperator(String expr) {
		int minPrecedence = Integer.MAX_VALUE;
		int operatorIndex = -1;
		int parenthesesDepth = 0;
	
		for (int i = 0; i < expr.length(); i++) {
			char c = expr.charAt(i);
	
			if (c == '(') {
				parenthesesDepth++;
			} else if (c == ')') {
				parenthesesDepth--;
			} else if ((c == '+' || c == '-' || c == '*' || c == '/') && parenthesesDepth == 0) {
				int precedence = getPrecedence(c);
				if (precedence <= minPrecedence) {
					minPrecedence = precedence;
					operatorIndex = i;
				}
			}
		}
	
		return operatorIndex;
	}

	private int getPrecedence(char operator) {
		switch (operator) {
			case '+':
			case '-':
				return 1;
			case '*':
			case '/':
				return 2;
			default:
				return Integer.MAX_VALUE;
		}
	}

	private boolean isNumber(String s) {
		try {
			Float.parseFloat(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private void printTree(BinaryNode node, int level) {
		if (node != null) {
			printTree(node.getRightNode(), level + 1);
			for (int i = 0; i < level; i++) {
				System.out.print("    ");
			}
			System.out.println(node.getValue());
			printTree(node.getLeftNode(), level + 1);
		}
	}
	
	private int getDegree(BinaryNode node) {
		if (node == null) {
			return -1;
		}
		
		int leftDegree = getDegree(node.getLeftNode());
		int rightDegree = getDegree(node.getRightNode());

		return 1 + Math.max(leftDegree, rightDegree);
	}

	private void inOrderTraversal(BinaryNode root) {
		if (root != null) {
			inOrderTraversal(root.getLeftNode());
			System.out.print(root.getValue() + "  ");
			inOrderTraversal(root.getRightNode());
		}
	}

	private void preOrderTraversal(BinaryNode root) {
		if (root != null) {
			System.out.print(root.getValue() + "  ");
			preOrderTraversal(root.getLeftNode());
			preOrderTraversal(root.getRightNode());
		}
	}
	
	private void postOrderTraversal(BinaryNode root) {
		if (root != null) {
			postOrderTraversal(root.getLeftNode());
			postOrderTraversal(root.getRightNode());
			System.out.print(root.getValue() + "  ");
		}
	}
}