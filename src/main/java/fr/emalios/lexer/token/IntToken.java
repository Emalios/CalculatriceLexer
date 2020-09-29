package fr.emalios.lexer.token;

public class IntToken implements Token {

    private int number;

    public IntToken(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "IntToken{" +
                "number=" + number +
                '}';
    }
}
