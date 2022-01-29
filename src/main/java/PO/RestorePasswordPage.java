package PO;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RestorePasswordPage extends BasePageStellarBurgers {

    //Локатор кнопки Войти
    @FindBy(how = How.XPATH, using = ".//a[text() = 'Войти']")
    private SelenideElement logInButton;

    //метод клика на кнопку Войти
    public void clickLogInButton() {
        logInButton.click();
    }
}
