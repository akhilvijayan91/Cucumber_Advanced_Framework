Feature: Login Validation to Orange HRM

  Scenario: Login Verification
    Given user is on the Orange HRM Login Page
    When  the user login to Orange HRM  application with "Admin" and "admin123"
    Then  the user should login sucessfully to Orange HRM application