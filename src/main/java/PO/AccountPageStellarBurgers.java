package PO;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AccountPageStellarBurgers extends BasePageStellarBurgers {

    //Локатор кнопки Выход
    @FindBy(how = How.XPATH, using = ".//button[text() = 'Выход']")
    private SelenideElement logOutButton;

    //метод клика на кнопку Выход
    public void logOutButtonClick() {
        logOutButton.click();
    }
}
