package PO;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPageStellarBurgers extends BasePageStellarBurgers {

    //Локатор поля Имя
    @FindBy(how = How.XPATH, using = ".//label[text() = 'Имя']")
    private SelenideElement nameField;
    //Локатор поля Email
    @FindBy(how = How.XPATH, using = ".//label[text() = 'Email']")
    private SelenideElement emailField;
    //Локатор поля Пароль
    @FindBy(how = How.XPATH, using = ".//label[text() = 'Пароль']")
    private SelenideElement passwordField;
    //Локатор кнопки Зарегистрироваться
    @FindBy(how = How.XPATH, using = ".//button[text() = 'Зарегистрироваться']")
    private SelenideElement signInButton;
    //Локатор кнопки Войти
    @FindBy(how = How.XPATH, using = ".//a[text() = 'Войти']")
    private SelenideElement logInButton;

    //метод заполнения поля Имя
    public void fillInNameField(String name) {
        nameField.setValue(name);
    }

    //метод заполнения поля Email
    public void fillInEmailField(String email) {
        emailField.setValue(email);
    }

    //метод заполнения поля Пароль
    public void fillInPasswordField(String password) {
        passwordField.setValue(password);
    }

    //метод клика на кнопку Зарегистрироваться
    public void clickSighInButton() {
        signInButton.click();
    }

    //метод клика на кнопку Войти
    public void clickLogInButton() {
        logInButton.click();
    }
}
