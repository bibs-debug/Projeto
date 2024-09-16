package project;

public class OperatorNode extends BinaryNode<String> {
    public OperatorNode(String operator) {
        super(operator);
    }
    // Sobrescreve o método visitar para realizar a operação
    @Override
    public float visit() {
        float leftValue = getLeftNode().visitar();
        float rightValue = getRightNode().visitar();

        switch (getValue()) {
            case "+":
                return leftValue + rightValue;
            case "-":
                return leftValue - rightValue;
            case "*":
                return leftValue * rightValue;
            case "/":
                if (rightValue == 0) {
                    throw new ArithmeticException("Divisão por zero!");
                }
                return leftValue / rightValue;
            default:
                throw new IllegalArgumentException("Operador inválido: " + getValue());
        }
    }
}
