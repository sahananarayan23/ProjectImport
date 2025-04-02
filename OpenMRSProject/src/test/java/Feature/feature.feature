Feature: OpenMRS Application Testing

  Scenario: Validate Login with valid credentials
    Given User is on OpenMRS Login page
    When User enters valid username "admin" and password "Admin123"
    And User clicks Login button
    Then User should be logged in successfully

  Scenario: Register a new patient
    Given User is logged into OpenMRS
    When User navigates to Register a Patient page
    And User enters mandatory patient details:
      | GivenName  | FamilyName | Gender | Birthdate | Address           | PhoneNumber | Relationship | RelativeName |
      | Sana      | Narayan    | Female | 12/06/2000 | Street ABC, City XYZ, State PQR, Country LMN, 123456 | 112 | Sibling | John Doe |
    And User submits the patient form
    Then Patient should be registered successfully

  Scenario: Update an existing patient record
    Given User is logged into OpenMRS
    When User searches for a patient using name "Sana Narayan"
    And User clicks Edit Patient Details
    And User updates the patient's address to "New Street, New City, New State, 456789"
    And User saves the updated patient details
    Then Patient details should be updated successfully
