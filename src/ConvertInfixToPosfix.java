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
            } else if (Character.isWhitespace(caractere)){
                continue;
            }
             else if (caractere == '(') {
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
    expressaoPosfixa = expressaoPosfixa.replaceAll("\\s+", ""); // Remove espaços em branco
    
    Stack<Character> pilha = new Stack<>(); // Usando pilha para operandos
    
    for (int i = 0; i < expressaoPosfixa.length(); i++) {
        char caractere = expressaoPosfixa.charAt(i);

        // Se for letra ou número, considera como operando e empilha
        if (Character.isLetterOrDigit(caractere)) {
            pilha.push(caractere);
        }
        // Se for operador, desempilha dois operandos para realizar a operação
        else if (isOperador(caractere)) {
            if (pilha.size() < 2) {
                System.out.println("Erro: Operador '" + caractere + "' com operandos insuficientes.");
                return false;
            }
            // Realiza a operação desempilhando dois operandos
            pilha.pop(); // Segundo operando
            pilha.pop(); // Primeiro operando

            // Após realizar a operação, adiciona o resultado fictício de volta à pilha
            pilha.push('R'); // 'R' representa um resultado fictício
        } 
        // Se encontrar um caractere inválido
        else {
            System.out.println("Erro: Caractere desconhecido '" + caractere + "'.");
            return false;
        }
    }

    // Se ao final sobrou exatamente um elemento na pilha, a expressão é válida
    if (pilha.size() != 1) {
        System.out.println("Erro: Número incorreto de operandos.");
        return false;
    }

    return true;
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

