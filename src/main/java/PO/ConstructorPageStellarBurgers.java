package PO;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.sleep;

public class ConstructorPageStellarBurgers extends BasePageStellarBurgers {

    public static final String URL = "https://stellarburgers.nomoreparties.site";
    private String currentTabClassName = "tab_tab_type_current__2BEPc";

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
    public LogInPageStellarBurgers clickLogInButton() {
        logInButton.click();
        return page(LogInPageStellarBurgers.class);
    }

    //метод клика на кнопку перехода в раздел Булки
    @Step("Click on buns tab")
    public ConstructorPageStellarBurgers clickBunsTab() {
        bunsTab.parent().click();
        sleep(1000);
        return this;
    }

    //метод клика на кнопку перехода в раздел Соусы
    @Step("Click on sauces tab")
    public ConstructorPageStellarBurgers clickSaucesTab() {
        saucesTab.parent().click();
        sleep(1000);
        return this;
    }

    //метод клика на кнопку перехода в раздел Начинки
    @Step("Click on fillings tab")
    public ConstructorPageStellarBurgers clickFillingsTab() {
        fillingsTab.parent().click();
        sleep(1000);
        return this;
    }

    //метод определяет, появилась ли кнопка Оформить заказ
    @Step("Display create order button")
    public boolean isCreateOrderButtonDisplayed() {
        return createOrderButton.shouldBe(visible).isDisplayed();
    }

    //метод возвращает классы вкладки Булки
    @Step("Get buns tab class names")
    public String getBunsTabClassNames() {
        return bunsTab.parent().attr("class");
    }

    //метод возвращает классы вкладки Соусы
    @Step("Get sauces tab class names")
    public String getSaucesTabClassNames() {
        return saucesTab.parent().attr("class");
    }

    //метод возвращает классы вкладки Начинки
    @Step("Get fillings tab class names")
    public String getFillingsTabClassNames() {
        return fillingsTab.parent().attr("class");
    }

    //метод проверяет, содержится ли класс выбранной вкладки в списке классов
    @Step("Check selected tab contains current tab class name")
    public boolean isCurrentTabSelected(String tabClassName) {
        return tabClassName.contains(currentTabClassName);
    }

}
