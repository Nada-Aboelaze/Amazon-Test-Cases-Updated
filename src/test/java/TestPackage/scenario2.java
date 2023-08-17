package TestPackage;
import BasePage.TestBase;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class scenario2 extends TestBase {
    HomePage homePageObj;
    @Test
    public void OpenTodayDeals() {
        homePageObj = new HomePage(driver);
        homePageObj.SwitchToEnglishLang();
        homePageObj.openTodayDealsPage();
        homePageObj.SelectFilters();
        homePageObj.SelectTenPercentDiscount();
        homePageObj.SelectAProductFromTheResultsPage();
        homePageObj.AddItemToCart();
        Assert.assertTrue(homePageObj.succfullyAddedToCart.isDisplayed());
        homePageObj.openCartPage();
        homePageObj.cartIsNotEmpty();
        Assert.assertTrue(homePageObj.matchedProduct);
    }
}
