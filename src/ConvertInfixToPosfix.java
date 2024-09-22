package src;

import java.util.Stack;

public class ConvertInfixToPosfix {

    public static String converterParaPosfixa(String expressaoInfixa){
        String expressaoPosfixa = "";
        Stack<Object> pilha = new Stack<>();

        for (int i = 0; i < expressaoInfixa.length(); i++) {
            char caractere = expressaoInfixa.charAt(i);

            if (Character.isDigit(caractere)) {
                expressaoPosfixa += caractere;
            } else if (caractere == '(') {
                pilha.push(caractere);
            } else if (caractere == ')') {
                while (!pilha.isEmpty() && (char)pilha.peek() != '(') {
                    expressaoPosfixa += pilha.pop();
                }
                pilha.pop(); // remove '(' da stack
            } else {
                while (!pilha.isEmpty() && prioridade(caractere) <= prioridade((char)pilha.peek())) {
                    expressaoPosfixa += pilha.pop();
                }
                pilha.push(caractere);
            }
        }
        while (!pilha.isEmpty()) {
            expressaoPosfixa += pilha.pop();
        }
        return expressaoPosfixa;
    }
        

    public static boolean validarExpressaoPosfixa(String expressaoPosfixa) {
        VeryBasicTokenizer tokenizer = new VeryBasicTokenizer(expressaoPosfixa);
        String[] tokens = tokenizer.tokenize().split(" "); // Tokeniza a expressão
        Stack<Double> pilha = new Stack<>();
        boolean expressaoValida = true; // Flag para a validade da expressão

        for (String token : tokens) {
            // Se for um número, empilha
            if (token.matches("\\d+(\\.\\d+)?")) { // Regex para número inteiro ou decimal
                pilha.push(Double.parseDouble(token));
            } 
            // Se for um operador, realiza a operação
            else if (isOperador(token.charAt(0))) {
                if (pilha.size() < 1) {
                    System.out.println("Erro: Operador '" + token + "' com operandos insuficientes.");
                    expressaoValida = false;
                    break;
                }
                double b = pilha.pop();
                double a = pilha.pop();
                switch (token.charAt(0)) {
                    case '+':
                        pilha.push(a + b);
                        break;
                    case '-':
                        pilha.push(a - b);
                        break;
                    case '*':
                        pilha.push(a * b);
                        break;
                    case '/':
                        if (b == 0) {
                            System.out.println("Erro: Divisão por zero.");
                            expressaoValida = false;
                            break;
                        }
                        pilha.push(a / b);
                        break;
                    default:
                        System.out.println("Erro: Operador desconhecido '" + token + "'.");
                        expressaoValida = false;
                        break;
                }
            } 
            // Token inválido
            else {
                System.out.println("Erro: Token inválido '" + token + "'.");
                expressaoValida = false;
                break;
            }
        }

        // Verifica se a pilha contém exatamente um elemento (resultado final)
        if (expressaoValida && pilha.size() != 1) {
            System.out.println("Erro: Número incorreto de operandos.");
            expressaoValida = false;
        }

        return expressaoValida;
    }

    public static boolean isOperador(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private static int prioridade(char operador) {
        switch (operador) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1; 
        }
    }

    }

