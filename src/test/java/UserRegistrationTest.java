import PO.ConstructorPageStellarBurgers;
import PO.LogInPageStellarBurgers;
import com.UserOperations;
import com.codeborne.selenide.WebDriverRunner;
import com.github.javafaker.Faker;
import com.model.Tokens;
import com.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserRegistrationTest {

    private User randomUser;
    private ConstructorPageStellarBurgers constructorPageStellarBurgers;

    @Before
    public void setUp() {
        randomUser = User.getRandom();
        constructorPageStellarBurgers = open(ConstructorPageStellarBurgers.URL, ConstructorPageStellarBurgers.class);
    }

    @After
    public void tearDown() {
        UserOperations.delete();
        Tokens.cleanTokens();
    }

    @Test
    public void userSuccessfullyRegistered() {

        constructorPageStellarBurgers.clickLogInButton()
                .clickSighInButton()
                .registerUser(randomUser)
                .navigateToLogInPage();

        String expectedUrl = LogInPageStellarBurgers.URL;
        String actualUrl = WebDriverRunner.url();

        assertEquals("Page URL is incorrect", expectedUrl, actualUrl);

        boolean isUserLoggedIn = Boolean.parseBoolean(UserOperations.login(randomUser).get("success"));

        assertTrue("User is not logged in", isUserLoggedIn);

    }

    @Test
    public void checkErrorWhenUserRegisterWithIncorrectPassword() {

        String incorrectPassword = new Faker().internet().password(1, 5);
        User userWithIncorrectPassword = randomUser.setPassword(incorrectPassword);

        boolean isIncorrectPasswordErrorDisplayed = constructorPageStellarBurgers.clickLogInButton()
                .clickSighInButton()
                .registerUser(userWithIncorrectPassword)
                .isIncorrectPasswordErrorDisplayed();

        assertTrue("Incorrect password error is not displayed", isIncorrectPasswordErrorDisplayed);
    }
}
