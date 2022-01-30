package PO;

import com.codeborne.selenide.SelenideElement;
import com.model.Tokens;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public abstract class BasePageStellarBurgers {

    //Локатор логотипа Stellar burgers в хедере
    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement stellarBurgersHeaderLogo;
    //Локатор кнопки Личный кабинет в хедере
    @FindBy(how = How.CSS, using = "a[href='/account']")
    private SelenideElement accountHeaderButton;
    //Локатор кнопки Конструктор в хедере
    @FindBy(how = How.XPATH, using = ".//p[text() = 'Конструктор']")
    private SelenideElement constructorHeaderButton;

    //метод клика на логотип Stellar burgers в хедере
    @Step("Click on Stellar burgers logo")
    public void stellarBurgersLogoClick() {
        stellarBurgersHeaderLogo.click();
    }

    //метод клика на кнопку Личный кабинет в хедере
    @Step("Click account header button")
    public void accountHeaderButtonClick() {
        accountHeaderButton.click();
    }

    //метод клика на кнопку Конструктор в хедере
    @Step("Click constructor header button")
    public void constructorHeaderButtonClick() {
        constructorHeaderButton.click();
    }

    //метод устанавливает токены в local storage
    @Step("Set tokens in local storage")
    public BasePageStellarBurgers setTokensInLocalStorage() {
        Tokens.setTokensInLocalStorage();
        return this;
    }
}
