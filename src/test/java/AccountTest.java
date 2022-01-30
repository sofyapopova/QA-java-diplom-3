import PO.AccountPageStellarBurgers;
import PO.ConstructorPageStellarBurgers;
import PO.LogInPageStellarBurgers;
import com.UserOperations;
import com.model.Tokens;
import com.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AccountTest {

    private User randomUser;

    @Before
    public void setUp() {
        randomUser = User.getRandom();
        UserOperations.register(randomUser);
    }

    @After
    public void tearDown() {
        UserOperations.delete();
        Tokens.cleanTokens();
        Tokens.clearLocalStorage();
    }

    @Test
    public void checkUserCanOpenHisAccount() {
        open(ConstructorPageStellarBurgers.URL, ConstructorPageStellarBurgers.class)
                .setTokensInLocalStorage()
                .accountHeaderButtonClick();

        AccountPageStellarBurgers accountPageStellarBurgers = page(AccountPageStellarBurgers.class);

        String expectedUserName = randomUser.getName();
        String actualUserName = accountPageStellarBurgers.getValueFromNameField();

        assertEquals("Incorrect user name in account", expectedUserName, actualUserName);
    }

    @Test
    public void checkUserCanOpenConstructorPageFromHisAccount() {

        open(ConstructorPageStellarBurgers.URL, ConstructorPageStellarBurgers.class)
                .setTokensInLocalStorage()
                .accountHeaderButtonClick();
        page(AccountPageStellarBurgers.class).constructorHeaderButtonClick();

        ConstructorPageStellarBurgers constructorPageStellarBurgers = page(ConstructorPageStellarBurgers.class);

        assertTrue("Create order button is not displayed", constructorPageStellarBurgers.isCreateOrderButtonDisplayed());
    }

    @Test
    public void checkUserCanOpenConstructorFromHisAccountByClickingLogo() {

        open(ConstructorPageStellarBurgers.URL, ConstructorPageStellarBurgers.class)
                .setTokensInLocalStorage()
                .accountHeaderButtonClick();
        page(AccountPageStellarBurgers.class).stellarBurgersLogoClick();

        ConstructorPageStellarBurgers constructorPageStellarBurgers = page(ConstructorPageStellarBurgers.class);

        assertTrue("Create order button is not displayed", constructorPageStellarBurgers.isCreateOrderButtonDisplayed());
    }

    @Test
    public void checkUserCanLogOut() {

        open(ConstructorPageStellarBurgers.URL, ConstructorPageStellarBurgers.class)
                .setTokensInLocalStorage()
                .accountHeaderButtonClick();
        page(AccountPageStellarBurgers.class).logOutButtonClick();

        assertTrue("Log in button is not displayed", page(LogInPageStellarBurgers.class).isLogInButtonDisplayed());
    }
}
