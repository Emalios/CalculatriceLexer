package fr.emalios.lexer;

import fr.emalios.lexer.stream.StringIStream;

public class Main {

    public static void main(String[] args) {
        String test = "1 + ( 3 - 1 ) * 6";
        System.out.println(new Lexer(test).lexing());
    }

}
