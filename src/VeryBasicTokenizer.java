//Beatriz Lima de Moura     RA: 10416616
//Beatriz Santos de Souza   RA: 10417803
//Jessica Bispo             RA: 10410798

package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class VeryBasicTokenizer {

    // operadores aceitos pelo tokenizer
    private static final String OPERATORS = "+-*/()";

    private char[] input;  // string de entrada convertida para array de char 
    private int index;     // índice atual do char que está sendo processado

    public VeryBasicTokenizer(String str) {
        input = str.toCharArray();  // converte a string em um array de caracteres
        index = 0;  // inicializa o índice com 0
    }

    // método principal que realiza a quebra e validação da string de entrada
    public String tokenize() {
        List<String> tokens = new ArrayList<>();  // lista para armazenar os tokens
        StringBuilder sb = new StringBuilder();   // usado para construir tokens de múltiplos dígitos, concatenação de operadores, etc
        char currChar = getNextChar();            // obtém o primeiro caractere da entrada

        if(!verifyParentheses(new String(input))){
            throw new IllegalArgumentException(" parênteses desbalanceados");
        }

        boolean isTokenizing = true;
        while (isTokenizing) {
            // ignora os espaços em branco
            while (Character.isWhitespace(currChar))
                currChar = getNextChar();

            // se o caractere atual for um dígito, cria um token de número
           if (Character.isDigit(currChar) || (currChar == '.' && Character.isDigit(getNextChar()))) {
            sb.setLength(0);  
            boolean decimalFound = false;  // flag to track if a decimal point has been found
            while (Character.isDigit(currChar) || (currChar == '.' && !decimalFound)) {
                if (currChar == '.') {
                    decimalFound = true;  // set the flag if a decimal point is found
                }
                sb.append(currChar);
                currChar = getNextChar();
            }
            tokens.add(sb.toString());  
            // se for um operador, adiciona diretamente como token
            } else if (OPERATORS.contains(String.valueOf(currChar))) {
                tokens.add(String.valueOf(currChar));
                currChar = getNextChar();

            // se o caractere nulo for encontrado, encerra a execução do metodo
            } else if (currChar == '\0') {
                isTokenizing = false;

            // caso contrário, é um token não reconhecido
            } else {
                throw new IllegalArgumentException("Token não reconhecido: " + currChar);
            }
        }

        // junta os tokens em uma única string separada por espaços
        String output = "";
        for (String token : tokens) {
            output += token + " ";
        }

        return output.trim();  // retorna a string DE tokens
    }

    private boolean verifyParentheses(String expression) {
       Stack<Character> stack = new Stack<>();

         for (int i = 0; i < expression.length(); i++) {
              char c = expression.charAt(i);
              if (c == '(') {
                stack.push(c);
              } else if (c == ')') {
                if (stack.isEmpty()) {
                     return false;
                }
                stack.pop();
              }
         }

        return stack.isEmpty();
    }

    // obtem o próximo caractere da string de entrada
    private char getNextChar() {
        if (index >= input.length) { return '\0'; }  // retorna caractere nulo se final da string for alcançado
        return input[index++];  // retorna o caractere atual e incrementa o índice
    }
}