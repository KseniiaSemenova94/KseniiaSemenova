@UserTablePage
Feature: User Table Page

  Scenario: User Table Page test
    Given I am on Home Page
    And I login as user 'PITER CHAILOVSKII'
    When I click on 'SERVICE' button in Header
    And I click on 'USER_TABLE' button in Service dropdown
    Then 'USER_TABLE' page is opened
    And '6' 'TYPE_DROPDOWN' are displayed on Users Table on User Table Page
    And '6' 'USER_NAME' are displayed on Users Table on User Table Page
    And '6' 'DESCRIPTION_IMAGE' are displayed on Users Table on User Table Page
    And '6' 'DESCRIPTION_TEXT' are displayed on Users Table on User Table Page
    And '6' 'CHECKBOX' are displayed on Users Table on User Table Page
    And User table contains following values:
      | Number | User             | Description                      |
      | 1      | Roman            | Wolverine                        |
      | 2      | Sergey Ivan      | Spider Man                       |
      | 3      | Vladzimir        | Punisher                         |
      | 4      | Helen Bennett    | Captain America some description |
      | 5      | Yoshi Tannamuri  | Cyclope some description         |
      | 6      | Giovanni Rovelli | Hulk some description            |
    When I select vip checkbox for 'SERGEY_IVAN'
    Then log row has 'Vip: condition changed to true' text in log section
    When I click on dropdown in column Type for user 'ROMAN'
    Then droplist for 'ROMAN' contains values
      | Admin   |
      | User    |
      | Manager |
