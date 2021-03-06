package ru.ayaz;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ru.ayaz.ru.ayaz.exceptions.InvalidNicknameException;
import ru.ayaz.ru.ayaz.exceptions.InvalidUserCommandException;

public class UserIgnoreTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    private User user;

    @Before
    public final void before() throws InvalidNicknameException {
        this.user = new User("Ayaz");
    }

    @Test
    public void shouldNotThrowNullPointerExceptionWhenInitialized() {
        user.isIgnored("someone");
    }

    @Test
    public void shouldNotThrowWhenIgnoreNormal() throws InvalidUserCommandException {
        user.ignoreUser("badGuy333");
    }

    @Test
    public void shouldThrowWhenAlreadyContains() throws InvalidUserCommandException {
        user.ignoreUser("spammer423");

        exception.expect(InvalidUserCommandException.class);

        user.ignoreUser("spammer423");
    }

    @Test
    public void shouldThrowWhenIgnoreYourself() throws InvalidUserCommandException {
        exception.expect(InvalidUserCommandException.class);
        user.ignoreUser("Ayaz");
    }
}