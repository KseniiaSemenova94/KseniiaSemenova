@DifferentElementsPage
Feature:

  Scenario: User Table Page test
    Given I am on Home Page
    Then 'HOME_PAGE' page is opened
    When I login as user 'PITER CHAILOVSKII'
    Then User name in the right-top side of screen is displayed and equals to 'PITER CHAILOVSKII'
    And '4' 'PICTURE' are displayed on 'HOME_PAGE' Page
    And '4' 'TEXT_UNDER_PICTURE' are displayed on 'HOME_PAGE' Page
    And '1' 'HEADLINE_TEXT' are displayed on 'HOME_PAGE' Page
    And '1' 'DESCRIPTION_TEXT' are displayed on 'HOME_PAGE' Page
    When I click on 'SERVICE' button in Header
    Then 'HEADER' dropdown contains options:
      | SUPPORT          | DATES              | SEARCH      |
      | COMPLEX_TABLE    | SIMPLE_TABLE       | USER_TABLE  |
      | TABLE_WITH_PAGES | DIFFERENT_ELEMENTS | PERFORMANCE |
    When I click on 'SERVICE' button in the left section
    Then 'LEFT_SECTION' dropdown contains options:
      | SUPPORT          | DATES              | SEARCH      |
      | COMPLEX_TABLE    | SIMPLE_TABLE       | USER_TABLE  |
      | TABLE_WITH_PAGES | DIFFERENT_ELEMENTS | PERFORMANCE |
    When I click on 'SERVICE' button in Header
    And I click on 'DIFFERENT_ELEMENTS' button in Service dropdown
    Then 'DIFFERENT_ELEMENTS' page is opened
    And '4' 'CHECKBOX' are displayed on 'DIFFERENT_ELEMENTS' Page
    And '4' 'RADIO' are displayed on 'DIFFERENT_ELEMENTS' Page
    And '1' 'DROPDOWN' are displayed on 'DIFFERENT_ELEMENTS' Page
    And '2' 'BUTTON' are displayed on 'DIFFERENT_ELEMENTS' Page
    And Component 'RIGHT_SECTION' exists on Different Elements Page
    And Component 'LEFT_SECTION' exists on Different Elements Page
    When I select 'CHECKBOX':
      | Water | Wind |
    Then Log rows are displayed, 'CHECKBOX' name and its status/value is corresponding to:
      | Water | Wind |
    When I select 'RADIO':
      | Selen |
    Then Log rows are displayed, 'RADIO' name and its status/value is corresponding to:
      | Selen |
    When I select 'DROPDOWN':
      | Yellow |
    Then Log rows are displayed, 'DROPDOWN' name and its status/value is corresponding to:
      | Yellow |
    When I select 'CHECKBOX':
      | Water | Wind |
    Then Log rows are displayed, 'CHECKBOX' name and its status/value is corresponding to:
      | Water | Wind |


