package fr.emalios.lexer.stream;

import java.util.Optional;

public interface BiIterator<T> {

    public Optional<T> next();

    public Optional<T> previous();

    public Optional<T> peek();

    public boolean atEOF();

}
