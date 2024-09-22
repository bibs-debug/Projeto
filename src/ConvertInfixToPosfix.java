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

