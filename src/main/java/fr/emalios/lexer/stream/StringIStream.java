package fr.emalios.lexer.stream;

import java.util.Optional;

public class StringIStream implements IStream<Character> {

    private int current;
    private final String source;

    public StringIStream(String source)  {
        this.source = source;
        this.current = 0;
    }

    @Override
    public Optional<Character> next() {
        return Optional.ofNullable(this.atEOF() ? null : this.source.charAt(this.current++));
    }

    @Override
    public Optional<Character> previous() {
        return Optional.ofNullable(this.current <= 0 ? null : this.source.charAt(--this.current));
    }

    @Override
    public Optional<Character> peek() {
        return Optional.ofNullable(this.current < 0 || this.atEOF() ? null : this.source.charAt(this.current));
    }
}
