package PO;

import com.codeborne.selenide.SelenideElement;
import com.model.User;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class RegistrationPageStellarBurgers extends BasePageStellarBurgers {

    public static final String URL = ConstructorPageStellarBurgers.URL + "/register";

    //Локатор плейсхолдера Имя
    @FindBy(how = How.XPATH, using = ".//label[text() = 'Имя']")
    private SelenideElement nameLabel;
    //Локатор плейсхолдера Email
    @FindBy(how = How.XPATH, using = ".//label[text() = 'Email']")
    private SelenideElement emailLabel;
    //Локатор поля Пароль
    @FindBy(how = How.CSS, using = "input[name='Пароль']")
    private SelenideElement passwordField;
    //Локатор кнопки Зарегистрироваться
    @FindBy(how = How.XPATH, using = ".//button[text() = 'Зарегистрироваться']")
    private SelenideElement signInButton;
    //Локатор кнопки Войти
    @FindBy(how = How.XPATH, using = ".//a[text() = 'Войти']")
    private SelenideElement logInButton;
    //Локатор рамки валидации поля Пароль
    @FindBy(how = How.CLASS_NAME, using = "input_status_error")
    private SelenideElement passwordFieldErrorBorder;
    //Локатор сообщения об ошибке Некорректный пароль
    @FindBy(how = How.XPATH, using = ".//p[text() = 'Некорректный пароль']")
    private SelenideElement incorrectPasswordErrorMessage;

    //метод заполнения поля Имя
    @Step("Fill in name field")
    public void fillInNameField(String name) {
        nameLabel.parent().find("input").setValue(name);
    }

    //метод заполнения поля Email
    @Step("Fill in email field")
    public void fillInEmailField(String email) {
        emailLabel.parent().find("input").setValue(email);
    }

    //метод заполнения поля Пароль
    @Step("Fill in password field")
    public void fillInPasswordField(String password) {
        passwordField.setValue(password);
    }

    //метод клика на кнопку Зарегистрироваться
    @Step("Click sign in button")
    public void clickSighInButton() {
        signInButton.click();
    }

    //метод клика на кнопку Войти
    @Step("Click log in button")
    public void clickLogInButton() {
        logInButton.click();
    }

    //метод регистрации пользователя
    @Step("Register user")
    public RegistrationPageStellarBurgers registerUser(User user) {
        fillInEmailField(user.getEmail());
        fillInPasswordField(user.getPassword());
        fillInNameField(user.getName());
        clickSighInButton();
        return this;
    }

    //метод перехода на страницу входа
    @Step("Navigate to log in page")
    public LogInPageStellarBurgers navigateToLogInPage() {
        LogInPageStellarBurgers logInPageStellarBurgers = page(LogInPageStellarBurgers.class);
        logInPageStellarBurgers.waitForLogInPageLoading();
        return logInPageStellarBurgers;
    }

    //метод определяет появилась ли ошибка некорректного пароля
    @Step("Display incorrect password error")
    public boolean isIncorrectPasswordErrorDisplayed() {
        boolean isErrorBorderDisplayed = passwordFieldErrorBorder.shouldBe(visible).isDisplayed();
        boolean isErrorMessageIsDisplayed = incorrectPasswordErrorMessage.shouldBe(visible).isDisplayed();
        return isErrorBorderDisplayed && isErrorMessageIsDisplayed;
    }
}
