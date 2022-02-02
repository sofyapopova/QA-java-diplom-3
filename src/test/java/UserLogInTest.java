import po.ConstructorPageStellarBurgers;
import po.LogInPageStellarBurgers;
import po.RegistrationPageStellarBurgers;
import po.RestorePasswordPage;
import com.TestConfig;
import com.UserOperations;
import com.model.Tokens;
import com.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

public class UserLogInTest {

    private User randomUser;

    @Before
    public void setUp() {
        TestConfig.apply();
        randomUser = User.getRandom();
        UserOperations.register(randomUser);
    }

    @After
    public void tearDown() {
        UserOperations.delete();
        Tokens.cleanTokens();
        closeWebDriver();
    }

    @Test
    public void checkLogInByAccountHeaderButton() {

        open(ConstructorPageStellarBurgers.URL, ConstructorPageStellarBurgers.class)
                .clickAccountHeaderButton();

        LogInPageStellarBurgers logInPageStellarBurgers = page(LogInPageStellarBurgers.class);

        boolean isCreateOrderButtonDisplayed = logInPageStellarBurgers.logIn(randomUser)
                .isCreateOrderButtonDisplayed();

        assertTrue("Create order button is not displayed", isCreateOrderButtonDisplayed);
    }

    @Test
    public void checkLogInByButtonOnConstructorPage() {

        open(ConstructorPageStellarBurgers.URL, ConstructorPageStellarBurgers.class)
                .clickLogInButton();

        LogInPageStellarBurgers logInPageStellarBurgers = page(LogInPageStellarBurgers.class);

        boolean isCreateOrderButtonDisplayed = logInPageStellarBurgers.logIn(randomUser)
                .isCreateOrderButtonDisplayed();

        assertTrue("Create order button is not displayed", isCreateOrderButtonDisplayed);
    }

    @Test
    public void checkLogInByButtonOnRegistrationForm() {

        open(RegistrationPageStellarBurgers.URL, RegistrationPageStellarBurgers.class)
                .clickLogInButton();

        LogInPageStellarBurgers logInPageStellarBurgers = page(LogInPageStellarBurgers.class);

        boolean isCreateOrderButtonDisplayed = logInPageStellarBurgers.logIn(randomUser)
                .isCreateOrderButtonDisplayed();

        assertTrue("Create order button is not displayed", isCreateOrderButtonDisplayed);
    }

    @Test
    public void checkLogInByButtonOnRestorePasswordPage() {

        open(RestorePasswordPage.URL, RestorePasswordPage.class)
                .clickLogInButton();

        LogInPageStellarBurgers logInPageStellarBurgers = page(LogInPageStellarBurgers.class);

        boolean isCreateOrderButtonDisplayed = logInPageStellarBurgers.logIn(randomUser)
                .isCreateOrderButtonDisplayed();

        assertTrue("Create order button is not displayed", isCreateOrderButtonDisplayed);
    }
}
