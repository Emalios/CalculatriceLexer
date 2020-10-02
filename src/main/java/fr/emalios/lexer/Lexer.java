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
            Token token = this.scan(this.stream.next().get());
            tokens.add(token);
        }
        return tokens;
    }

    // retourne le Token correspondant au charactère passé en paramètre
    private Token scan(Character character) {
        switch (character) {
            case '-':
                return SymbolToken.SUB;
            case '*':
                return SymbolToken.MUL;
            case '/':
                return SymbolToken.DIV;
            case '+':
                return SymbolToken.ADD;
            case '(':
                return SymbolToken.LEFT_PARENTHESIS;
            case ')':
                return SymbolToken.RIGHT_PARENTHESIS;
        }
        if(Character.isDigit(character)) {
            return new IntToken(this.getNumber(character));
        }
        //c'est pas sensé arriver wesh
        throw new IllegalStateException("Unrecognized character: '" + character + "'");
    }

    private int getNumber(Character character) {
        StringBuilder literalNumber = new StringBuilder();
        literalNumber.append(character);
        char current;
        while(!this.stream.atEOF() && Character.isDigit(current = this.stream.next().get())) {
            literalNumber.append(current);
            if(this.stream.atEOF()) {
                break;
            }
        }
        if (!this.stream.atEOF()) {
            this.stream.previous();
        }
        return Integer.parseInt(literalNumber.toString());
    }
}
