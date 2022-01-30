import PO.ConstructorPageStellarBurgers;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class ConstructorMenuTest {

    private ConstructorPageStellarBurgers constructorPageStellarBurgers;

    @Before
    public void setUp() {
        constructorPageStellarBurgers = open(ConstructorPageStellarBurgers.URL, ConstructorPageStellarBurgers.class);
    }

    @Test
    public void checkNavigateToSaucesTab() {

        String saucesTabClassNames = constructorPageStellarBurgers.clickSaucesTab().getSaucesTabClassNames();
        assertTrue("Sauces tab is not selected", constructorPageStellarBurgers.isCurrentTabSelected(saucesTabClassNames));
    }

    @Test
    public void checkNavigateToFillingsTab() {

        String fillingsTabClassNames = constructorPageStellarBurgers.clickFillingsTab().getFillingsTabClassNames();
        assertTrue("Fillings tab is not selected", constructorPageStellarBurgers.isCurrentTabSelected(fillingsTabClassNames));
    }

    @Test
    public void checkNavigateToBunsTab() {

        String bunsTabClassNames = constructorPageStellarBurgers
                .clickFillingsTab()
                .clickBunsTab()
                .getBunsTabClassNames();
        assertTrue("Buns tab is not selected", constructorPageStellarBurgers.isCurrentTabSelected(bunsTabClassNames));
    }
}
