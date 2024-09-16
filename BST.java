package projeto;

public class BST<T> extends BinaryTree<T> {

	public BST() {
		 super();	
	}
	public BST(BinaryNode<T> root) { 
		super(root);

	}

	//	search(data)
	public BinaryNode<T> search(BinaryNode<T> node,T data){
		
		if (node == null) {
			return null;
		}
		
		if (data.compareTo(node.getData()) == 0) {
			return node; // Nó encontrado
		} else if (data.compareTo(node.getData()) < 0) {
			return search(node.getLeft(), data); 
		} else { // result > 0
			return search(node.getRight(), data); 
		}
    }

		public BinaryNode<T> insert(BinaryNode<T> node, T data){
			
			if (node == null) {
				node = new 	BinaryNode<>(data);
				return node;
			}

			if (data.compareTo(node.getValue()) < 0) {
				node.setLeftNode(insert(node.getLeftNode(), data));
			} else if (data.compareTo(node.getValue()) > 0) {
				node.setRightNode(insert(node.getRightNode(), data));
			} else {
				// Se o valor já existe na árvore, lança uma exceção
				throw new RuntimeException("valor já existe na árvore: " + data);
			}
			
			return node;
	}
	//	remove(data)
	//	Remove o nó com a chave data da BST, caso o nó pertença à BST.
	//	Opcional: O método pode lançar uma exceção (ex. throw new RuntimeException()) para indicar que a BST não possui um nó com a chave indicada.

	//	findMin()
	//	Retorna o nó com menor chave OU null caso a BST esteja vazia.

	//	findMax()
	//	Retorna o nó com maior chave OU null caso a BST esteja vazia.

	//	findPredecessor(data)
	//	Retorna o nó antecessor do nó que contém a chave indicada em data OU null caso não exista o nó com chave data na BST.

	//	findSuccessor(data)
	//	Retorna o nó sucessor do nó que contém a chave indicada em data OU null caso não exista o nó com chave data na BST.

	//	clear()
	//	Remove todos os nós da BST e suas conexões (referências para outros nós se tornam null).

}

