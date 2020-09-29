package fr.emalios.lexer;

import fr.emalios.lexer.stream.StringIStream;
import fr.emalios.lexer.token.SymbolToken;
import fr.emalios.lexer.token.Token;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Lexer {

    private final String source;

    public Lexer(String source) {
        this.source = source;
    }

    public List<Token> lexing() {
        List<Token> tokens = new ArrayList<>();
        StringIStream stream = new StringIStream(this.source);
        while (!stream.atEOF()) {
            tokens.add(this.scan(stream.next()));
        }
        return tokens;
    }

    private Token scan(Optional<Character> next) {
        next.ifPresent(this::getToken);
    }

    private void getToken(Character character) {

    }
}
