Feature: Enter the vehicle registration number to search vehicle details

  Scenario: Enter the vehicle registration number to search vehicle details

    Given that 'Enter the registration number of the vehicle page' is open
    Then on Enter the registration number of the vehicle page - check 'Number Input box' is displayed
    And on Enter the registration number of the vehicle page  - check 'Continue Button' is displayed
    Then on Enter the registration number of the vehicle page - the vehicle registration number is pre-populated taken from the Excel file
    Then on Enter the registration number of the vehicle page - click on the 'Continue Button'