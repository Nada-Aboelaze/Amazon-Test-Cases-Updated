package TestPackage;
import BasePage.TestBase;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Scenario1NeagtiveTC extends TestBase {

    HomePage homePageObj;
    @Test
    public void SearchWithInvalidData() {
        homePageObj = new HomePage(driver);
        homePageObj.SwitchToEnglishLang();
        homePageObj.SearchForAKeyWord("xxxzzcc");
        homePageObj.SearchWithInvalidData();
        Assert.assertTrue(homePageObj.noResFound.isDisplayed());


    }
}
