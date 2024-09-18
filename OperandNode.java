//Beatriz Lima de Moura RA: 10416616
//Beatriz Santos de Souza RA: 10417803
//Jessica Bispo RA: 10410798
public class OperarandNode extends BinaryNode {

    public OperarandNode(Float value, BinaryNode parent) {
        super(value, parent);
    }

    @Override
    public float visit() {
        return (float) getValue();
    }
}

