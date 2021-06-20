package stepDefinition;

import validation.LoginPageAssertion;
import validation.PartAndSuppliesValidation;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import commonPage.LoginPage.LoginPage;
import commonPage.partsAndSuppliesPage.PartAndSuppliesPage;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CompressorTest extends AbstractTest {

    @Given("Login to lennoxPros page")
    public void loginToLennoxProsPage() {
        super.setUp();
        loginPage = new LoginPage(driver);
        loginPage.startAssertions(LoginPageAssertion.class)
                .assertIfUserAtLennoxHomepage()
                .endAssertion()
                .clickOnLoginLinkBtn()
                .inputUserID(lennoxConfiguration.getUserName())
                .inputPassword(lennoxConfiguration.getPassword())
                .clickOnSingInBtn();
    }

    @Then("User able to view home page for lennoxPros")
    public void userAbleToViewHomePageForLennoxPros() {
        loginPage.startAssertions(LoginPageAssertion.class)
                .assertIfUserAtLennoxHomepage()
                .endAssertion();
    }

    @When("Navigate via Menu to Parts And Supplies to Compressors page")
    public void navigateViaMenuToPartsAndSuppliesToCompressorsPage() throws IOException {
        partAndSuppliesPage = new PartAndSuppliesPage(driver);
        partAndSuppliesPage.clickOnNavigationMenuContainer()
                .SelectPrimaryCatalog(excel.readExcel("PrimaryCatalog", 3, 0))
                .SelectSubCatalog(excel.readExcel("PartAndSuppliesCatalog", 1, 0));
    }

    @Then("Validate user is at the compressor page")
    public void validateUserIsAtTheCompressorPage() throws IOException {
        List<String> subCatalogDescription = Arrays.asList(excel.readExcel("PartAndSuppliesCatalog", 3, 3), excel.readExcel("PartAndSuppliesCatalog", 4, 3));
        partAndSuppliesPage.startAssertions(PartAndSuppliesValidation.class)
                .assertAtCompressorPage(subCatalogDescription)
                .endAssertion();
    }

    @When("Select Air Compressors from that page")
    public void selectAirCompressorsFromThatPage() throws IOException {
        partAndSuppliesPage.clickOnAirCompressors(excel.readExcel("PartAndSuppliesCatalog", 1, 0), 3);
    }

    @Then("Validate the landing page description")
    public void validate_the_landing_page_description() throws IOException {
        List<String> subCatalogDescription = Arrays.asList(excel.readExcel("PartAndSuppliesCatalog", 3, 3), excel.readExcel("PartAndSuppliesCatalog", 5, 3));
        partAndSuppliesPage.startAssertions(PartAndSuppliesValidation.class)
                .assertAtCompressorPage(subCatalogDescription)
                .endAssertion();
    }

    @When("Locate for the product 10T46 on the page, if not found navigate to the subsequent pages until the product is found. If the product is not listed in any of the pages then provide the details in the report.")
    public void locate_for_the_product_10T46_on_the_page_if_not_found_navigate_to_the_subsequent_pages_until_the_product_is_found_If_the_product_is_not_listed_in_any_of_the_pages_then_provide_the_details_in_the_report() throws IOException {
        partAndSuppliesPage.getCatalogNumber(excel.readExcel("CompressorsCatalogNo", 1, 0));
    }

    @Then("Collect all the listed details pertaining to the product and store")
    public void collect_all_the_listed_details_pertaining_to_the_product_and_store() throws IOException {
        partAndSuppliesPage.getProductDetails(excel.readExcel("ProductListItem", 1, 0));
    }

    @When("Click on the Product and it will lead to Product detail page.")
    public void click_on_the_Product_and_it_will_lead_to_Product_detail_page() throws IOException {
        partAndSuppliesPage.clickOnCompressor(excel.readExcel("ProductListItem", 1, 0));
    }

    @Then("Collect all the product details which are highlighted and compare it with the details from the previous page.")
    public void collect_all_the_product_details_which_are_highlighted_and_compare_it_with_the_details_from_the_previous_page() throws IOException {
        List<String> productDetails = Arrays.asList(excel.readExcel("Product detail", 1, 0), excel.readExcel("Product detail", 1, 1), excel.readExcel("Product detail", 1, 2)
                , excel.readExcel("Product detail", 1, 3), excel.readExcel("Product detail", 1, 4), excel.readExcel("Product detail", 1, 5), excel.readExcel("Product detail", 1, 6), excel.readExcel("Product detail", 1, 7));
        partAndSuppliesPage.startAssertions(PartAndSuppliesValidation.class)
                .assertIfProductDetailsShowsCorrectly(productDetails)
                .endAssertion();
        super.close();
    }
}