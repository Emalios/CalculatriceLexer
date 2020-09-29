package fr.emalios.lexer;

import fr.emalios.lexer.stream.StringIStream;
import fr.emalios.lexer.token.IntToken;
import fr.emalios.lexer.token.SymbolToken;
import fr.emalios.lexer.token.Token;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Lexer {

    private final StringIStream stream;

    public Lexer(String source) {
        this.stream = new StringIStream(source);
    }

    public List<Token> lexing() {
        List<Token> tokens = new ArrayList<>();
        while (!this.stream.atEOF()) {
            tokens.add(this.scan());
            this.stream.next();
        }
        return tokens;
    }

    // retourne le Token correspondant au charactère passé en paramètre
    private Token scan() {
        char character = this.stream.peek().get();
        switch (character) {
            case '-':
                return SymbolToken.SUB;
            case '*':
                return SymbolToken.MUL;
            case '/':
                return SymbolToken.DIV;
            case '+':
                return SymbolToken.ADD;
        }
        if(Character.isDigit(character)) {
            return new IntToken(this.getNumber());
        }
        //c'est pas sensé arriver wesh
        throw new IllegalStateException("Unrecognized character:" + character);
    }

    private int getNumber() {
        StringBuilder literalNumber = new StringBuilder();
        boolean isDigit = true;
        while (isDigit) {
            literalNumber.append(this.stream.peek().get());
            System.out.println("Current char: " + this.stream.peek());
            char next = this.stream.next().get();
            System.out.println("Next char to test : " + next);
            isDigit = Character.isDigit(next);
        }
        return Integer.parseInt(literalNumber.toString());
    }
}
