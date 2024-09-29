//Beatriz Lima de Moura     RA: 10416616
//Beatriz Santos de Souza   RA: 10417803
//Jessica Bispo             RA: 10410798

package src;
import java.util.Scanner;

// TODO: 
// [X] make floats with . 
// [X] make it stop and clear when it finds an invalid character
// [X] make it handle exceptions and appropriate show a messages
// [X] edge case: when the expression is empty
// [X] edge case: when the expression is only spaces
// [X] edge case: when the expression is only a number


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
             + "5. Encerramento do programa.\r\n"
             + "6. Testes unitários.\r\n");
			System.out.print("Escolha sua opção: ");

            try {
                menu = scanner.nextInt();
            } catch (Exception e) {
                System.err.println("Opção inválida. Tente novamente");
                scanner.nextLine();
                continue;
            }
			
			switch(menu) {
				case 1: 
                    System.out.print("Insira a expressão: ");
                    scanner.nextLine();
                    expression = scanner.nextLine().trim();
                    if(!isValidInput(expression)){
                        expression = "";
                        break;
                    }
                    System.out.println("Expressão carregada com sucesso");
                    break;  
                case 2:
                    if(!isValidInput(expression)){
                        break;
                    }
                    try {
                        tree.createTree(expression);
                    } catch (Exception error) {
                        System.err.println("Erro ao criar árvore: " + error.getMessage());
                    }
                    
                    System.out.println("Criando árvore binária de expressão aritmética");
                    System.out.println("Árvore criada com sucesso");
                    break;              
                case 3:
                    if(tree.isEmpty()) {
                        System.out.println("Árvore vazia");
                        break;
                    }
                    System.out.println("Exibindo árvore binária de expressão aritmética:");
                    tree.printTree();

                    System.out.println("\n\nPercurso pré-ordem:");
                    tree.preOrder();

                    System.out.println("\n\nPercurso em ordem:");
                    tree.inOrder();

                    System.out.println("\n\nPercurso pós-ordem:");
                    tree.postOrder();
                    break;                    
                case 4:
                    if(tree.isEmpty()) {
                        System.out.println("Árvore vazia");
                        break;
                    }
                    System.out.println("Calculando expressão");
                    System.out.println("O resultado é " + tree.calculateResult());
                    break;
                case 5:
                    System.out.println("\n\nPrograma encerrado");
					break;
                case 6:
                   System.out.println("\n\nTestes unitários\n");
                    shouldPassTest();
                    shouldFailTest();
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
          if(new BinaryTreeOP().validateExpression(expression)) {
              throw new IllegalArgumentException("Expressão inválida");
          }
        } catch (Exception error) {
           if(error.getMessage().contains("Expressão vazia")) {
                System.err.println("Expressão vazia");
            } else if(error.getMessage().contains("Expressão contém apenas espaços em branco")) {
                System.err.println("Expressão contém apenas espaços em branco");
            } else if(error.getMessage().contains("Expressão inválida") ||error.getMessage().contains("out of bound")) {
                System.err.println("Expressão inválida");
            } else {
                System.err.println("Erro ao validar expressão: " + error.getMessage());
            }
        }
       
        return true;
    }

    private static void shouldPassTest() {
        System.out.println("\nTestes que devem passar\n");
        BinaryTreeOP tree = new BinaryTreeOP();

        String[] testExpressions = {
            "1+2*3",
            "(45+20) * 2 - 15",
            "0.5*3/0.25",
            "(7 + 3) / (6 - 4) * 9",
            "1.5 +(2 - (3 +4))*5.1"
        };
        String[] testResults = {
            "7.0",
            "115.0",
            "6.0",
            "45.0",
            "-24"
        };

        for (int i = 0; i < testExpressions.length; i++) {
            try {
                tree.createTree(testExpressions[i]);
                float result = tree.calculateResult();
                if (result == Float.parseFloat(testResults[i])) {
                    System.out.println("Teste " + (i + 1) + " passou");
                } else {
                    System.out.println("Teste " + (i + 1) + " falhou");
                }
            } catch (Exception e) {
                System.out.println("Teste " + (i + 1) + " falhou");
            }
        }
    }

    private static void shouldFailTest() {
        System.out.println("\nTestes que devem falhar\n");
        BinaryTreeOP tree = new BinaryTreeOP();

        String[] testExpressions = {
            "x * y",
            "1+2*",
            "((10-2)*3",
            "5 % 2",
            "1 + 2 = 3"
        };

        for (int i = 0; i < testExpressions.length; i++) {
            try {
                tree.createTree(testExpressions[i]);
                System.out.println("Teste " + (i + 1) + " falhou");
                //captura a exception para confirmar que deu errado
            } catch (Exception error) {
                System.out.println("Teste " + (i + 1) + " passou");
            }
        }
    }
}
