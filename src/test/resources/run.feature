Feature: My feature description

  Scenario: Verify page is opened and Language set to Automation
    Given I have website "http://magento.mainacad.com/index.php/english/"
    When I choose language "automation"
    And  I click Account - Login
    Then Login or create account page is opened