package project;

public class OperandNode extends BinaryNode<Float> {
    public OperandNode(Float value) {
        super(value);
    }
    // Sobrescreve o método visitar para retornar o valor do operando
    @Override
    public float visit() {
        return getValue();
    }
}
