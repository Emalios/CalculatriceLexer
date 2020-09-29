package fr.emalios.lexer;

import fr.emalios.lexer.stream.StringIStream;

public class Main {

    public static void main(String[] args) {
        String test = "123*5+";
        StringIStream stringIStream = new StringIStream(test);
        System.out.println(new Lexer(test).lexing());
    }

}
