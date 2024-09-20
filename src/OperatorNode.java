//Beatriz Lima de Moura     RA: 10416616
//Beatriz Santos de Souza   RA: 10417803
//Jessica Bispo             RA: 10410798

package src;

public class OperatorNode extends BinaryNode {

    public OperatorNode(char operator, BinaryNode parent) {
        super(operator, parent);
    }
    
    @Override
    public float visit() {
        char value = (char) getValue();
        if (value == '+') { 
            return getLeftNode().visit() + getRightNode().visit();
        } else if (value == '-') {
            return getLeftNode().visit() - getRightNode().visit();
        } else if (value == '*') {
            return getLeftNode().visit() * getRightNode().visit();
        } else if (value == '/') {
            return getLeftNode().visit() / getRightNode().visit();
        }
        return Float.NaN;
    }
}
