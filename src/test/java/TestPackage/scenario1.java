package TestPackage;
import BasePage.TestBase;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class scenario1 extends TestBase {

    HomePage homePageObj;
    @Test
    public void AddToCart() {
        homePageObj = new HomePage(driver);
        homePageObj.SwitchToEnglishLang();
        homePageObj.SearchForAKeyWord("car accessories");
        homePageObj.SelectFirstItem();
        homePageObj.AddItemToCart();
        Assert.assertTrue(homePageObj.succfullyAddedToCart.isDisplayed());
        homePageObj.openCartPage();
        homePageObj.cartIsNotEmpty();
        Assert.assertTrue(homePageObj.matchedProduct);
    }

}
