//Beatriz Lima de Moura     RA: 10416616
//Beatriz Santos de Souza   RA: 10417803
//Jessica Bispo             RA: 10410798

package src;

public class OperatorNode extends BinaryNode {

    // construtor que recebe o operador
    public OperatorNode(char operator) {
        super(operator);  // chama o construtor da superclasse com o operador
    }

    // construtor que também recebe o nó pai
    public OperatorNode(char operator, BinaryNode parent) {
        super(operator, parent);  // chama o construtor da superclasse
    }
    
    // implementação do método visit() para calcular o valor da expressão
    @Override
    public float visit() {
        char value = (char) getValue();  // obtém o valor do nó (o operador)
        
        // executa a operação com base no operador
        if (value == '+') { 
            return getLeftNode().visit() + getRightNode().visit();  // soma
        } else if (value == '-') {
            return getLeftNode().visit() - getRightNode().visit();  // subtração
        } else if (value == '*') {
            return getLeftNode().visit() * getRightNode().visit();  // multiplicação
        } else if (value == '/') {
            return getLeftNode().visit() / getRightNode().visit();  // divisão
        }
        return Float.NaN;  // caso o operador seja inválido
    }
}