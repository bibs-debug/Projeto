//Beatriz Lima de Moura     RA: 10416616
//Beatriz Santos de Souza   RA: 10417803
//Jessica Bispo             RA: 10410798

package src;

public class Main {
    public static void main(String[] args) {
        
        String expression = "3 * 5 + 8 * (2 / 3 + 7)";

        BinaryTreeOP tree = new BinaryTreeOP();

        tree.insertExpression(expression);

        tree.printTree();

    }
}
