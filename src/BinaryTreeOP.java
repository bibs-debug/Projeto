//Beatriz Lima de Moura     RA: 10416616
//Beatriz Santos de Souza   RA: 10417803
//Jessica Bispo             RA: 10410798

package src;

public class BinaryTreeOP {

	private BinaryNode root;  // raiz da árvore binária
	
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
			return -1;  // se a árvore estiver vazia, retorna -1
		}
		
		return getDegree(root);  // calcula o grau a partir da raiz
	}

	public int getHeight() {
		if (isEmpty()) {
			return -1;  // se a árvore estiver vazia, retorna -1
		}
		
		return root.getHeight();  // obtém a altura da raiz
	}

	public Float calculateResult() {
		return root.visit();
	}

	// insere uma expressão na árvore
	public void createTree(String expression) {

	 	// tokeniza a expressão
		expression = new VeryBasicTokenizer(expression).tokenize();

		// constrói a árvore com base na expressão tokenizada
		setRoot(buildTree(expression.trim())); 
	}

	public boolean validateExpression(String expression) {
		try {
			if (expression.isEmpty()) {
				throw new IllegalArgumentException("Expressão vazia.");
			}
	
			if (expression.trim().isEmpty()) {
				throw new IllegalArgumentException("Expressão contém apenas espaços em branco.");
			}
	
			if (new VeryBasicTokenizer(expression).tokenize().isEmpty()) {
				throw new IllegalArgumentException("Expressão inválida.");
			}
	
			buildTree(expression.trim());
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}

		return false;
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
	
		// verifica se o nó é um número
		if (isNumber(expression)) {
			return new OperatingNode(Float.parseFloat(expression));  // cria um nó com valor numérico
		}
	
		// verifica se a expressão está entre parênteses
		if (expression.startsWith("(") && expression.endsWith(")")) {
			int closingParenthesisIndex = findClosingParenthesisIndex(expression);
			if (closingParenthesisIndex == expression.length() - 1) {
				return buildTree(expression.substring(1, closingParenthesisIndex).trim());
			}
		}
	
		// encontra o operador principal
		int operatorIndex = findMainOperator(expression);
	
		// cria o nó raiz com base no operador
		BinaryNode root = binaryNodeHandler(Character.toString(expression.charAt(operatorIndex)));
	
		// cria os nós filhos recursivamente
		root.setLeftNode(buildTree(expression.substring(0, operatorIndex).trim()));
		root.setRightNode(buildTree(expression.substring(operatorIndex + 1).trim()));
	
		return root;
	}

	// encontra o índice do parêntese de fechamento correspondente
	private int findClosingParenthesisIndex(String expr) {
		int parenthesesDepth = 0;

		for (int i = 0; i < expr.length(); i++) {
			char c = expr.charAt(i);

			if (c == '(') {
				parenthesesDepth++;
			} else if (c == ')') {
				parenthesesDepth--;
				if (parenthesesDepth == 0) {
					return i;
				}
				if (parenthesesDepth < 0) {
					throw new IllegalArgumentException("Parênteses desbalanceados.");
				}
			}
		}
		throw new IllegalArgumentException("Parênteses desbalanceados.");
	}
			
	// cria um nó com base no operador ou número
	private BinaryNode binaryNodeHandler(String expression) {
		if(isNumber(expression)) {
			return new OperatingNode(Float.parseFloat(expression));  // cria nó de número
		}
		// cria o nó do operador correspondente
		switch (expression) {
			case "+":
				return new OperatorNode('+');
			case "-":
				return new OperatorNode('-');
			case "*":
				return new OperatorNode('*');
			case "/":
				return new OperatorNode('/');
			default:
				return new BinaryNode(expression);  // retorna um nó genérico
		}
		
	}

	// encontra o índice do operador principal com base na precedência
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
}
