package fr.emalios.lexer;

import java.util.ArrayList;
import java.util.List;

public class Scanner {

    private final List<Token> tokens;
    private final String source;

    public Scanner(String source) {
        this.tokens = new ArrayList<>();
        this.source = source;
    }
}
