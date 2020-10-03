package fr.emalios.lexer;

import fr.emalios.lexer.token.IntToken;
import fr.emalios.lexer.token.SymbolToken;
import fr.emalios.lexer.token.Token;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestLexer {

    private Lexer lexer;
    private List<Token> expected;

    @Before
    public void before() {
        this.lexer = new Lexer();
        this.expected = new ArrayList<>();
    }

    @Test
    public void test_with_one_integer_token() {
        Token token = new IntToken(1);
        this.expected.add(token);
        assert this.expected.equals(this.lexer.lexing("1"));
    }

    @Test
    public void test_with_one_symbol_token() {
        Token token = SymbolToken.ADD;
        this.expected.add(token);
        assert this.expected.equals(this.lexer.lexing("+"));
    }

    @Test
    public void test_with_one_basic_expression() {
        Token addToken = SymbolToken.ADD;
        Token numberOneToken = new IntToken(1);
        this.expected.add(numberOneToken);
        this.expected.add(addToken);
        this.expected.add(numberOneToken);
        assert this.expected.equals(this.lexer.lexing("1+1"));
    }

}
