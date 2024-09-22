//Beatriz Lima de Moura     RA: 10416616
//Beatriz Santos de Souza   RA: 10417803
//Jessica Bispo             RA: 10410798

package src;

import java.util.ArrayList;
import java.util.List;

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

        boolean isTokenizing = true;
        while (isTokenizing) {
            // ignora os espaços em branco
            while (Character.isWhitespace(currChar))
                currChar = getNextChar();

            // se o caractere atual for um dígito, cria um token de número
            if (Character.isDigit(currChar)) {
                sb.setLength(0);  // limpa o StringBuilder para novo token
                while (Character.isDigit(currChar)) {  // continua até o final do número
                    sb.append(currChar);
                    currChar = getNextChar();
                }
                tokens.add(sb.toString());  // adiciona o número como token

            // se for um operador, adiciona diretamente como token
            } else if (OPERATORS.contains(String.valueOf(currChar))) {
                tokens.add(String.valueOf(currChar));
                currChar = getNextChar();

            // se o caractere nulo for encontrado, encerra a execução do metodo
            } else if (currChar == '\0') {
                isTokenizing = false;

            // caso contrário, é um token não reconhecido
            } else {
                System.out.println("Token não reconhecido: " + currChar);
                isTokenizing = false;
            }
        }

        // junta os tokens em uma única string separada por espaços
        String output = "";
        for (String token : tokens) {
            output += token + " ";
        }

        return output.trim();  // retorna a string DE tokens
    }

    // obtem o próximo caractere da string de entrada
    private char getNextChar() {
        if (index >= input.length) { return '\0'; }  // retorna caractere nulo se final da string for alcançado
        return input[index++];  // retorna o caractere atual e incrementa o índice
    }
}