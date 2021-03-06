@Test
Feature: Parts And Supplies

  Scenario: Compressors
    Given Login to lennoxPros page
    Then User able to view home page for lennoxPros
    When Navigate via Menu to Parts And Supplies to Compressors page
    Then Validate user is at the compressor page
    When Select Air Compressors from that page
    Then Validate the landing page description
    When Locate for the product 10T46 on the page, if not found navigate to the subsequent pages until the product is found. If the product is not listed in any of the pages then provide the details in the report.
    Then Collect all the listed details pertaining to the product and store
    When Click on the Product and it will lead to Product detail page.
    Then Collect all the product details which are highlighted and compare it with the details from the previous page.