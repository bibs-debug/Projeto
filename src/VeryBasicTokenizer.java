//Beatriz Lima de Moura     RA: 10416616
//Beatriz Santos de Souza   RA: 10417803
//Jessica Bispo             RA: 10410798

package src;

import java.util.ArrayList;
import java.util.List;

public class VeryBasicTokenizer {

    private static final String OPERATORS = "+-*/()";

    private char[] input;
    private int index;

    public VeryBasicTokenizer(String str) {
        input = str.toCharArray();
        index = 0;
    }

    public String tokenize() {
        List<String> tokens = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        char currChar = getNextChar();

        boolean isTokenizing = true;
        while (isTokenizing) {
            while (Character.isWhitespace(currChar))
                currChar = getNextChar();

            if (Character.isDigit(currChar)) { 
                sb.setLength(0);
                while (Character.isDigit(currChar)) {
                    sb.append(currChar);
                    currChar = getNextChar();
                }
                tokens.add(sb.toString());
                
            } else if (OPERATORS.contains(String.valueOf(currChar))){
                tokens.add(String.valueOf(currChar));

                currChar = getNextChar();
            } else if (currChar == '\0') {
                isTokenizing = false;

            } else {
                System.out.println("Token não reconhecido: " + currChar);
                isTokenizing = false;
            }
        }

        String output = "";
        for (String token : tokens) {
            output += token + " ";
        }

        return output;
    }

    private char getNextChar() {
        if (index >= input.length) { return '\0'; }
        return input[index++];
    }
}
