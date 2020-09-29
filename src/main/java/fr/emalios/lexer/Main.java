package fr.emalios.lexer;

import fr.emalios.lexer.stream.StringIStream;

public class Main {

    public static void main(String[] args) {
        String test = "Test kappa";
        StringIStream stringIStream = new StringIStream(test);
        while (!stringIStream.atEOF()) {
            System.out.println("char : " + stringIStream.next());
        }
    }

}
