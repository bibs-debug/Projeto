//Beatriz Lima de Moura     RA: 10416616
//Beatriz Santos de Souza   RA: 10417803
//Jessica Bispo             RA: 10410798

package src;

public class Main {
    public static void main(String[] args) {

        // do {
        //     System.out.println("Menu:");
        //     System.out.println("1. Entrada da expressao aritmetica na notação infixa.");
        //     System.out.println("2. Criação da árvore binária de expressão aritmética.");
        //     System.out.println("3. Exibição da árvore binária de expressão aritmética.");
        //     System.out.println("4. Cálculo da expressão (realizando o percurso da árvore).");
        //     System.out.println("5. Encerramento do programa.");
        //     System.out.print("Escolha uma opção: ");
        //     //opcao = scann.nextInt();
            
        //     //(A+B)/(C-D)*E -> infixa/aritmetica
        //     //AB+CD-/E* -> notação posfixa

        //     // switch (opcao) { 
        //     //     case 1:
        //     //         //recebe o input do usuario, valida input do user, retorna ok ou error (antes de inserir na arvore)
        //     //     case 2:
        //     //     case 3:
        //     //     case 4:
        //     //     case 5:
        //     // } 

               
        
        // } while ();

         String expressao = "2*3/(2-1)+5*(4-1)";
                System.out.println("Posfixa: " + ConvertInfixToPosfix.converterParaPosfixa(expressao));

        // String expression = "(3 * 5 + 8) * (20 / 3 + 7) ";

        // BinaryTreeOP tree = new BinaryTreeOP();

        // tree.insertExpression(expression);

        
        //System.out.println(tree.getRoot().getClass().getName());

        // System.out.println(tree.calculateResult());

        // tree.printTree();

    }
}
