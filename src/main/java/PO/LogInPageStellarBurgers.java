package PO;

import com.codeborne.selenide.SelenideElement;
import com.model.User;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class LogInPageStellarBurgers extends BasePageStellarBurgers {

    public static final String URL = ConstructorPageStellarBurgers.URL + "/login";

    //Локатор плейсхолдера Email
    @FindBy(how = How.XPATH, using = ".//label[text() = 'Email']")
    private SelenideElement emailLabel;
    //Локатор поля Пароль
    @FindBy(how = How.CSS, using = "input[name='Пароль']")
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
        emailLabel.parent().find("input").setValue(email);
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
    public RegistrationPageStellarBurgers clickSighInButton() {
        signInButton.click();
        return page(RegistrationPageStellarBurgers.class);
    }

    //метод клика на кнопку Восстановить пароль
    @Step("Click restore password button")
    public void clickRestorePasswordButton() {
        restorePasswordButton.click();
    }

    //метод ожидания загрузки страницы
    @Step("Wait for log in page loading")
    public void waitForLogInPageLoading() {
        logInButton.shouldBe(visible);
    }

    //метод проверки наличия кнопки Войти
    @Step("Check log in button is displayed")
    public boolean isLogInButtonDisplayed() {
        return logInButton.shouldBe(visible).isDisplayed();
    }

    //метод входа пользователя
    @Step("Log in user")
    public ConstructorPageStellarBurgers logIn(User user) {
        fillInEmailField(user.getEmail());
        fillInPasswordField(user.getPassword());
        clickLogInButton();
        return page(ConstructorPageStellarBurgers.class);
    }
}
