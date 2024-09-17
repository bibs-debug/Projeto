//Beatriz Lima de Moura RA: 10416616
//Beatriz Santos de Souza RA: 10417803
//Jessica Bispo RA: 10410798

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
