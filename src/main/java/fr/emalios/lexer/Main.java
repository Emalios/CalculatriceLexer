package fr.emalios.lexer;

import fr.emalios.lexer.stream.StringIStream;

public class Main {

    public static void main(String[] args) {
        String test = "6+1";
        System.out.println(new Lexer(test).lexing());
    }

}
