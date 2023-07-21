@subscribe
Feature: subscription of stc tv
  Scenario Outline: validate on subscription packages of stc tv and its (type, price, currency)
    Given User open stc tv subscription page
    And User select "<language>"
    And The available packages to the "<country>" are displayed in "<language>"
    When User select the "<country>"
    Then The price is displayed according to the selected "<country>"
    And The currency is displayed according to the selected "<country>" in "<language>"
    Examples:
    | country | language |
    | SA      | en       |
    | Kuwait  | en       |
    | Bahrain | en       |
    | SA      | ar       |
    | Kuwait  | ar       |
    | Bahrain | ar       |