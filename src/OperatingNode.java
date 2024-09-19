//Beatriz Lima de Moura     RA: 10416616
//Beatriz Santos de Souza   RA: 10417803
//Jessica Bispo             RA: 10410798

package src;

public class OperatingNode extends BinaryNode {

    public OperatingNode(Float value, BinaryNode parent) {
        super(value, parent);
    }

    @Override
    public float visit() {
        return (float) getValue();
    }
}
