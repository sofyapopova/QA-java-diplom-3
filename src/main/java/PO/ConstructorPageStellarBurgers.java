package PO;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class ConstructorPageStellarBurgers extends BasePageStellarBurgers {

    public static final String URL = "https://stellarburgers.nomoreparties.site";

    //Локатор кнопки Войти в аккаунт
    @FindBy(how = How.XPATH, using = ".//button[text() = 'Войти в аккаунт']")
    private SelenideElement logInButton;
    //Локатор кнопки перехода в раздел Булки
    @FindBy(how = How.XPATH, using = ".//span[text() = 'Булки']")
    private SelenideElement bunsTab;
    //Локатор кнопки перехода в раздел Соусы
    @FindBy(how = How.XPATH, using = ".//span[text() = 'Соусы']")
    private SelenideElement saucesTab;
    //Локатор кнопки перехода в раздел Начинки
    @FindBy(how = How.XPATH, using = ".//span[text() = 'Начинки']")
    private SelenideElement fillingsTab;
    //Локатор кнопки Оформить заказ
    @FindBy(how = How.XPATH, using = ".//button[text() = 'Оформить заказ']")
    private SelenideElement createOrderButton;

    //метод клика на кнопку Войти в аккаунт
    @Step("Click log in button")
    public LogInPageStellarBurgers logInButtonClick() {
        logInButton.click();
        return page(LogInPageStellarBurgers.class);
    }

    //метод клика на кнопку перехода в раздел Булки
    @Step("Click on buns tab")
    public void bunsTabClick() {
        bunsTab.click();
    }

    //метод клика на кнопку перехода в раздел Соусы
    @Step("Click on sauces tab")
    public void saucesTabClick() {
        bunsTab.click();
    }

    //метод клика на кнопку перехода в раздел Начинки
    @Step("Click on fillings tab")
    public void fillingsTabClick() {
        bunsTab.click();
    }

    //метод определяет, появилась ли кнопка Оформить заказ
    @Step("Display create order button")
    public boolean isCreateOrderButtonDisplayed() {
        return createOrderButton.shouldBe(visible).isDisplayed();
    }
}
