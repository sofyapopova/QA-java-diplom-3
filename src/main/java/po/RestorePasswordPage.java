package po;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RestorePasswordPage extends BasePageStellarBurgers {

    public static final String URL = ConstructorPageStellarBurgers.URL + "/forgot-password";

    //Локатор кнопки Войти
    @FindBy(how = How.XPATH, using = ".//a[text() = 'Войти']")
    private SelenideElement logInButton;

    //метод клика на кнопку Войти
    @Step("Click sign in button")
    public void clickLogInButton() {
        logInButton.click();
    }
}
