package validation;

import commonPage.partsAndSuppliesPage.PartAndSuppliesPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PartAndSuppliesValidation extends AbstractAssertion<PartAndSuppliesPage> {

    public PartAndSuppliesValidation assertAtCompressorPage(List<String> description) {
        assertThat(basePage.getDescription()).as("Verify that user at compressor Page ").isEqualTo(description);
        return this;
    }

    public PartAndSuppliesValidation assertIfProductDetailsShowsCorrectly(List<String> expectedDetails) {
        assertThat(basePage.getProductDetailsPageValues()).as("Verify that Collect all the product details which are highlighted and compare it with the details  ").isEqualTo(expectedDetails);
        return this;
    }
}