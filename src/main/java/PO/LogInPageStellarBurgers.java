package PO;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LogInPageStellarBurgers extends BasePageStellarBurgers {

    //Локатор поля Email
    @FindBy(how = How.XPATH, using = ".//label[text() = 'Email']")
    private SelenideElement emailField;
    //Локатор поля Пароль
    @FindBy(how = How.XPATH, using = ".//label[text() = 'Пароль']")
    private SelenideElement passwordField;
    //Локатор кнопки Войти
    @FindBy(how = How.XPATH, using = ".//button[text() = 'Войти']")
    private SelenideElement logInButton;
    //Локатор кнопки Восстановить пароль
    @FindBy(how = How.XPATH, using = ".//a[text() = 'Восстановить пароль']")
    private SelenideElement restorePasswordButton;
    //Локатор кнопки Зарегистрироваться
    @FindBy(how = How.XPATH, using = ".//a[text() = 'Зарегистрироваться']")
    private SelenideElement signInButton;

    //метод заполнения поля Email
    public void fillInEmailField(String email) {
        emailField.setValue(email);
    }

    //метод заполнения поля Пароль
    public void fillInPasswordField(String password) {
        passwordField.setValue(password);
    }

    //метод клика на кнопку Войти
    public void clickLogInButton() {
        logInButton.click();
    }

    //метод клика на кнопку Зарегистрироваться
    public void clickSighInButton() {
        signInButton.click();
    }

    //метод клика на кнопку Восстановить пароль
    public void clickRestorePasswordButton() {
        restorePasswordButton.click();
    }

}
