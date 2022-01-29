package PO;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.security.PublicKey;

public class ConstructorPageStellarBurgers extends BasePageStellarBurgers {

    //Локатор кнопки Войти в аккаунт
    @FindBy(how = How.XPATH, using = ".//button[text() = 'Войти в аккаунт']")
    private SelenideElement logInButton;
    //Локатор кнопки перехода в раздел Булки
    @FindBy(how = How.XPATH, using = ".//span[text() = 'Булки']")
    private SelenideElement bunsSectionButton;
    //Локатор кнопки перехода в раздел Соусы
    @FindBy(how = How.XPATH, using = ".//span[text() = 'Соусы']")
    private SelenideElement saucesSectionButton;
    //Локатор кнопки перехода в раздел Начинки
    @FindBy(how = How.XPATH, using = ".//span[text() = 'Начинки']")
    private SelenideElement fillingsSectionButton;

    //метод клика на кнопку Войти в аккаунт
    public void logInButtonClick() {
        logInButton.click();
    }

    //метод клика на кнопку перехода в раздел Булки
    public void bunsSectionButtonClick() {
        bunsSectionButton.click();
    }

    //метод клика на кнопку перехода в раздел Соусы
    public void saucesSectionButtonClick() {
        bunsSectionButton.click();
    }

    //метод клика на кнопку перехода в раздел Начинки
    public void fillingsSectionButtonClick() {
        bunsSectionButton.click();
    }
}
