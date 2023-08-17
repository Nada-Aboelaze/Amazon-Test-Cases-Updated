package Pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver){
        super(driver);
    }
    WebElement searchInput;
    WebElement product;
    List<WebElement> lang;
    List<WebElement> englishLang;
    WebElement saveChangesBtn;
    By addToCart = By.id("add-to-cart-button");
    public WebElement succfullyAddedToCart;
    String productTitle;
    String  productTitleInCart;
    public WebElement noResFound;
    WebElement todayDeals;
    WebElement groceryCheckBox;
    WebElement electronicsCheckBox;
    WebElement tenPercentDiscount;
    WebElement productInTodayDeals;
    WebElement cart;
    By firstSearchRes = By.className("DealImage-module__imageObjectFit_1G4pEkUEzo9WEnA3Wl0XFv");
    By noThanksBtn = By.cssSelector("#attachSiNoCoverage > span > input");
    Duration duration = Duration.ofSeconds(10);
    public boolean matchedProduct;
    boolean isElementClicked;
    int maxAttempts;
    int attempts;

    public void SwitchToEnglishLang() {
        WebDriverWait wait = new WebDriverWait(driver,duration);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
        lang  = driver.findElements(By.className("nav-line-2"));
        lang.get(1).click();
        englishLang = driver.findElements(By.className("a-icon-radio"));
        englishLang.get(1).click();
        saveChangesBtn = driver.findElement(By.className("a-button-input"));
        saveChangesBtn.click();
        wait.until(ExpectedConditions.urlToBe("https://www.amazon.eg/?language=en_AE"));
    }
    public void SearchForAKeyWord(String keyword) {
        isElementClicked = false;
        maxAttempts = 3;
        attempts = 0;
        while (!isElementClicked && attempts < maxAttempts) {
            try {
                searchInput = driver.findElement(By.id("twotabsearchtextbox"));
                searchInput.sendKeys(keyword);
                searchInput.sendKeys(Keys.RETURN);
                isElementClicked = true;
            } catch (StaleElementReferenceException e) {
                attempts++;
            }
        }
    }
    public void SelectFirstItem(){
        product = driver.findElement(By.className("a-price-whole"));
        product.click();
    }
    public void AddItemToCart() {
        productTitle = driver.findElement(By.id("productTitle")).getText();
        driver.findElement(addToCart).click();
        driver.manage().timeouts().implicitlyWait(duration);
        if (driver.findElements(By.id("attach-warranty-pane")).size()!=0){
            driver.findElement(noThanksBtn).click();
        }
        succfullyAddedToCart = driver.findElement(By.id("NATC_SMART_WAGON_CONF_MSG_SUCCESS"));
    }
    public void SearchWithInvalidData(){
        noResFound = driver.findElement(By.id("search"));
    }
    public void openTodayDealsPage(){
        todayDeals = driver.findElement(By.linkText("Today's Deals"));
        todayDeals.click();
    }
    public void openCartPage(){
        cart = driver.findElement(By.id("nav-cart"));
        cart.click();
    }
    public void cartIsNotEmpty(){
        System.out.println("product text "+ productTitle);
        productTitleInCart = driver.findElements(By.className("a-truncate-cut")).get(0).getText();
        productTitleInCart  = productTitleInCart.replace("…","");
        System.out.println("product text in cart "+ productTitleInCart.replace("…",""));
        if(productTitle.contains(productTitleInCart)){
            matchedProduct = true;
        }
    }
    public void SelectFilters(){
        driver.manage().timeouts().implicitlyWait(duration);
        groceryCheckBox = driver.findElement(By.xpath("//*[@id=\"grid-main-container\"]/div[2]/span[3]/ul/li[12]/label"));
        groceryCheckBox.click();
        electronicsCheckBox = driver.findElement(By.xpath("//*[@id=\"grid-main-container\"]/div[2]/span[3]/ul/li[7]/label"));
        electronicsCheckBox.click();
    }
    public void SelectTenPercentDiscount(){
        tenPercentDiscount = driver.findElement(By.linkText("10% off or more"));
        tenPercentDiscount.click();
    }
    public void SelectAProductFromTheResultsPage() {
        attempts = 0;
        maxAttempts = 3;
        isElementClicked = false;
        WebDriverWait wait = new WebDriverWait(driver,duration);
        wait.until(ExpectedConditions.presenceOfElementLocated(firstSearchRes));
        while (!isElementClicked && attempts < maxAttempts) {
            try {
        driver.findElements(firstSearchRes).get(0).click();
                isElementClicked = true;
            } catch (StaleElementReferenceException e) {
                attempts++;
            }}
        productInTodayDeals = driver.findElement(By.xpath("//*[@id=\"octopus-dlp-asin-stream\"]/ul/li[1]/span/div/div[1]"));
        productInTodayDeals.click();
    }
}
