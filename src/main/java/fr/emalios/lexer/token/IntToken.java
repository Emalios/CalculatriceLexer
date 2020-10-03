package fr.emalios.lexer.token;

import java.util.Objects;

public class IntToken implements Token {

    private final int number;

    public IntToken(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntToken intToken = (IntToken) o;
        return number == intToken.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "IntToken{" +
                "number=" + number +
                '}';
    }
}
