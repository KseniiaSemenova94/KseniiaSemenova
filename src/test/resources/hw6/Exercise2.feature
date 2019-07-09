@UserTablePage
Feature: User Table Page

  Scenario: User Table Page test
    Given I am on Home Page
    And I login as user 'PITER CHAILOVSKII'
#    When I click on Service button in Header
#    And I click on User Table button in Service dropdown
#    Then "User Table" page is opened
#    And '6' 'NUMBER_TYPE_DROPDOWN' are displayed on Users Table on User Table Page
#    And '6' 'USER_NAME' are displayed on Users Table on User Table Page
#    And '6' 'DESCRIPTION_IMAGE' are displayed on Users Table on User Table Page
#    And '6' 'DESCRIPTION_TEXT' under images are displayed on Users Table on User Table Page
#    And '6' 'CHECKBOX' are displayed on Users Table on User Table Page
#    And User table contains following values:
#      | Number | User             | Description                      |
#      | 1      | Roman            | Wolverine                        |
#      | 2      | Sergey Ivan      | Spider Man                       |
#      | 3      | Vladzimir        | Punisher                         |
#      | 4      | Helen Bennett    | Captain America some description |
#      | 5      | Yoshi Tannamuri  | Cyclope some description         |
#      | 6      | Giovanni Rovelli | Hulk some description            |
#    When I select vip checkbox for 'Sergey Ivan'
#    Then 1 log row has "Vip: condition changed to true" text in log section
#    When I click on dropdown in column Type for user Roman
#    Then droplist contains values
#      | Admin   |
#      | User    |
#      | Manager |
