package steps;

import com.jayway.jsonpath.JsonPath;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.TestBase;
import readers.JsonTestDataReader;
import utilities.Paths;

public class TVSubscription_step extends TestBase{
    pages.TVSubscription tvSubscription = new pages.TVSubscription(driver);
    String packages =  JsonTestDataReader.parseJson(Paths.packages).toString();

    @Given("User open stc tv subscription page")
    public void userOpenStcTvSubscriptionPage() {
        tvSubscription.openPage();
    }

    @When("User select the {string}")
    public void userSelectThe(String country) {
        tvSubscription.selectCountry(country);
    }


    @And("The available packages to the {string} are displayed in {string}")
    public void theAvailablePackagesToTheAreDisplayed(String country, String language) {
        Assert.assertEquals(tvSubscription.getLitePackageTitle(),JsonPath.read(packages,"country."+country+".lite."+language+"_name"));
        Assert.assertEquals(tvSubscription.getClassicPackageTitle(),JsonPath.read(packages,"country."+country+".classic."+language+"_name"));
        Assert.assertEquals(tvSubscription.getPremiumPackageTitle(),JsonPath.read(packages,"country."+country+".premium."+language+"_name"));
    }

    @Then("The price is displayed according to the selected {string}")
    public void thePriceIsDisplayedAccordingToTheSelected(String country) {
        Assert.assertEquals(tvSubscription.getLitePackagePrice(), JsonPath.read(packages,"country."+country+".lite.price"));
        Assert.assertEquals(tvSubscription.getClassicPackagePrice(),JsonPath.read(packages,"country."+country+".classic.price"));
        Assert.assertEquals(tvSubscription.getPremiumPackagePrice(),JsonPath.read(packages,"country."+country+".premium.price"));
    }

    @And("The currency is displayed according to the selected {string} in {string}")
    public void theCurrencyIsDisplayedAccordingToTheSelected(String country, String language) {
        String currency = JsonPath.read(packages,"country."+country+"."+language+"_currency");
        Assert.assertEquals(tvSubscription.getLitePackageCurrency(),currency);
        Assert.assertEquals(tvSubscription.getClassicPackageCurrency(),currency);
        Assert.assertEquals(tvSubscription.getPremiumPackageCurrency(),currency);
    }

    @And("User select {string}")
    public void userSelect(String language) {
        if((language.equals("ar") && tvSubscription.getLanguageButtonText().equals("العربية"))
        || (language.equals("en") && tvSubscription.getLanguageButtonText().equals("English"))){
            tvSubscription.changeLanguage();
        }
    }
}
