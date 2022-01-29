package PO;

import com.codeborne.selenide.SelenideElement;
import com.model.User;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class RegistrationPageStellarBurgers extends BasePageStellarBurgers {

    //Локатор поля Имя
    @FindBy(how = How.XPATH, using = ".//label[text() = 'Имя']")
    private SelenideElement nameLabel;
    //Локатор поля Email
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
    public void fillInNameField(String name) {
        nameLabel.parent().find("input").setValue(name);
    }

    //метод заполнения поля Email
    public void fillInEmailField(String email) {
        emailLabel.parent().find("input").setValue(email);
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

    //метод регистрации пользователя с рандомными данными
    public RegistrationPageStellarBurgers registerUser(User user) {
        fillInEmailField(user.getEmail());
        fillInPasswordField(user.getPassword());
        fillInNameField(user.getName());
        clickSighInButton();
        return this;
    }

    public LogInPageStellarBurgers navigateToLogInPage() {
        LogInPageStellarBurgers logInPageStellarBurgers = page(LogInPageStellarBurgers.class);
        logInPageStellarBurgers.waitForLogInPageLoading();
        return logInPageStellarBurgers;
    }

    public boolean isIncorrectPasswordErrorDisplayed() {
        boolean isErrorBorderDisplayed = passwordFieldErrorBorder.shouldBe(visible).isDisplayed();
        boolean isErrorMessageIsDisplayed = incorrectPasswordErrorMessage.shouldBe(visible).isDisplayed();
        return isErrorBorderDisplayed && isErrorMessageIsDisplayed;
    }


}
