package fr.emalios.lexer.stream;

import java.util.Optional;

public class StringIStream implements IStream<Character> {

    private int current;
    private final String source;

    public StringIStream(String source)  {
        this.source = source.replace(" ", "");
        this.current = 0;
    }

    @Override
    public Optional<Character> next() {
        Optional<Character> character = this.peek();
        character.ifPresent(_character -> this.current++);
        return character;
    }

    @Override
    public Optional<Character> previous() {
        this.current--;
        return this.peek();
    }

    @Override
    public Optional<Character> peek() {
        return Optional.ofNullable(this.current < 0 || this.atEOF() ? null : this.source.charAt(this.current));
    }

    @Override
    public boolean atEOF() {
        return this.current >= this.source.length();
    }
}
