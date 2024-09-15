public class BST<T> extends BinaryTree<T> {

	public BST() { super();	}
	public BST(BinaryNode<T> root) { super(root); }

	//	search(data)
	
	//	Busca o nó com a chave data na BST, sendo que os nós continuam contendo apenas um tipo genérico T na parte de dados.
	//	Caso o nó pertença à BST, retorna o nó encontrado. Caso contrário, retorna null.

	//	insert(data)
	//	Insere um novo nó na BST, sendo que data é um valor usado como chave do nó (tipo genérico T).
	//	Caso já exista um nó da BST com a mesma chave, a BST não é alterada.
	//	Opcional: O método pode lançar uma exceção (ex. throw new RuntimeException()) para indicar que já existe um nó com a chave indicada.

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

