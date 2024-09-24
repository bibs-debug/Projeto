//Beatriz Lima de Moura     RA: 10416616
//Beatriz Santos de Souza   RA: 10417803
//Jessica Bispo             RA: 10410798

package src;
import java.util.Scanner;

// TODO: 
// [ ] make floats with . and , work
// [ ] make it stop and clear when it finds an invalid character
// [ ] make it handle exceptions and appropriate show a messages
// [ ] edge case: when the expression is empty
// [ ] edge case: when the expression is only spaces
// [ ] edge case: when the expression is only a number


public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
		int menu = 0;

        String expression = "";
        BinaryTreeOP tree = new BinaryTreeOP();


        while(menu!= 5) {
			System.out.println("\n\nMenu: \r\n" + "1. Carregar dados\r\n"
             + "2. Criação da árvore binária de expressão aritmética.\r\n" 
             + "3. Exibição da árvore binária de expressão aritmética.\r\n"
             + "4. Cálculo da expressão (realizando o percurso da árvore).\r\n"
             + "5. Encerramento do programa.");
			System.out.print("Escolha sua opção: ");

			menu = scanner.nextInt();
			
			switch(menu) {
				case 1: 
                    System.out.print("Insira a expressão: ");
                    scanner.nextLine();
                    expression = scanner.nextLine().trim();
                    if(!isValidInput(expression)){
                        break;
                    }
                    System.out.println("Expressão carregada com sucesso");
                    break;  
                case 2:
                    System.out.println("Criando árvore binária de expressão aritmética");
                    if(!isValidInput(expression)){
                        break;
                    }
                    System.out.println("Árvore criada com sucesso");
                    tree.createTree(expression);
                    break;              
                case 3:
                    System.out.println("Exibindo árvore binária de expressão aritmética:");
                    if(tree.isEmpty()) {
                        System.out.println("Árvore vazia");
                        break;
                    }
                    tree.printTree();
                    break;                    
                case 4:
                    System.out.println("Calculando expressão");
                    System.out.println("O resultado é " + tree.calculateResult());
                    break;
                case 5:
                    System.out.println("\n\nPrograma encerrado");
					break;
                default: 
                    System.out.println("\n\nOpção inválida. Tente novamente\n");
					break;
            }
        }
        scanner.close();
    }

    private static boolean isValidInput(String expression) {
        expression = expression.trim();
        if(expression.isEmpty() || expression.isBlank() || expression == null) {
            System.err.println("Expressão vazia");
            return false;
        }

        try {
            if(new VeryBasicTokenizer(expression).tokenize().isEmpty()) {
                System.err.println("Expressão inválida");
                return false;
            }
        } catch (Exception e) {
            System.err.println("Expressão inválida: " + e.getMessage());
            return false;
        }
       
        return true;
    }
}
