package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.pagefactory.ByAll;

public class TVSubscription {
    WebDriver driver;
    private final String STCTVSubsription_url="https://subscribe.stctv.com/sa-en";

    private By language_btn= By.id("translation-btn");
    private By countries_btn = By.id("country-btn");
    private By kuwait_country = By.id("kw");
    private By bahrain_country = By.id("bh");
    private By sa_country = By.id("sa");

    private By lite_title= By.xpath("//strong[@id='name-lite' or @id='name-لايت']");//By.id("name-lite");
    private By classic_title= By.xpath("//strong[@id='name-classic' or @id='name-الأساسية']");//By.id("name-classic");name-الأساسية
    private By premium_title= By.xpath("//strong[@id='name-premium' or @id='name-بريميوم']");//By.id("name-premium");name-بريميوم

    private By lite_price= By.xpath("//div[@id='currency-lite' or @id='currency-لايت']/b");//By.cssSelector("#currency-lite.price>b");//div[@id='currency-لايت']/b
    private By classic_price= By.xpath("//div[@id='currency-classic' or @id='currency-الأساسية']/b");//By.cssSelector("#currency-classic.price>b");
    private By premium_price= By.xpath("//div[@id='currency-premium' or @id='currency-بريميوم']/b");//By.cssSelector("#currency-premium.price>b");

    private By lite_currency= By.xpath("//div[@id='currency-lite' or @id='currency-لايت']/i");//By.cssSelector("#currency-lite.price>i");
    private By classic_currency= By.xpath("//div[@id='currency-classic' or @id='currency-الأساسية']/i");//By.cssSelector("#currency-classic.price>i");
    private By premium_currency= By.xpath("//div[@id='currency-premium' or @id='currency-بريميوم']/i");//By.cssSelector("#currency-premium.price>i");

    public TVSubscription(WebDriver driver){
        this.driver=driver;
    }

    public void openPage(){
        driver.get(STCTVSubsription_url);
    }

    public void selectCountry(String country){
        driver.findElement(countries_btn).click();
        switch (country){
            case "SA":
                driver.findElement(sa_country).click();
            break;
            case "Kuwait":
                driver.findElement(kuwait_country).click();
            break;
            case "Bahrain":
                driver.findElement(bahrain_country).click();
            break;
            default: System.out.println("invalid input");
        }
    }

    public void changeLanguage(){
        driver.findElement(language_btn).click();
    }

    public String getLanguageButtonText(){
        return driver.findElement(language_btn).getText().trim();
    }

    public String getLitePackageTitle(){
        return driver.findElement(lite_title).getText();
    }

    public String getClassicPackageTitle(){
        return driver.findElement(classic_title).getText();
    }

    public String getPremiumPackageTitle(){
        return driver.findElement(premium_title).getText();
    }

    public String getLitePackagePrice(){
        return driver.findElement(lite_price).getText();

    }

    public String getClassicPackagePrice(){
        return driver.findElement(classic_price).getText();

    }

    public String getPremiumPackagePrice(){
       return driver.findElement(premium_price).getText();

    }

    public String getLitePackageCurrency(){
        return driver.findElement(lite_currency).getText().split("/")[0];

    }

    public String getClassicPackageCurrency(){
        return driver.findElement(classic_currency).getText().split("/")[0];

    }

    public String getPremiumPackageCurrency(){
        return driver.findElement(premium_currency).getText().split("/")[0];

    }

    public Boolean arePackagesDisplayed(){
        if(!(driver.findElement(lite_title).isDisplayed())){
            return false;
        }
        if(!(driver.findElement(classic_title).isDisplayed())){
            return false;
        }
        if(!(driver.findElement(premium_title).isDisplayed())){
            return false;
        }
        return true;
    }


}
