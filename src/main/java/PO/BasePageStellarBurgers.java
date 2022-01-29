package PO;

import com.codeborne.selenide.SelenideElement;
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
    public void stellarBurgersLogoClick() {
        stellarBurgersHeaderLogo.click();
    }

    //метод клика на кнопку Личный кабинет в хедере
    public void accountHeaderButtonClick() {
        accountHeaderButton.click();
    }

    //метод клика на кнопку Конструктор в хедере
    public void constructorHeaderButtonClick() {
        constructorHeaderButton.click();
    }


}
