@tag
Feature: Login Functionality


@tag1
  Scenario: Login with invalid credentials
    Given User is on OpenMRS Login page
    When User enters invalid username "invalidUser" and password "wrongPass"
    And User clicks Login button
    Then Error message should be displayed

  Scenario: Login with blank credentials
    Given User is on OpenMRS Login page
    When User clicks Login button
    Then Error message should be displayed

  Scenario: Login with valid credentials
    Given User is on OpenMRS Login page
    When User enters valid username "admin" and password "Admin123"
    And User clicks Login button
    Then User should be logged in successfully

  Scenario: Register a patient with all mandatory fields
    Given User is on OpenMRS Login page
    When User enters valid username "admin" and password "Admin123"
    And User clicks Login button
    And User navigates to Register a Patient page
    And User enters mandatory patient details
    And User submits the patient form
    Then Patient should be registered successfully
    
     Scenario: User updates patient information
    Given User is on OpenMRS Login page
    When User searches for patient "Sana Narayan"
    And User updates patient details
    Then Updated patient details should be saved successfully
    