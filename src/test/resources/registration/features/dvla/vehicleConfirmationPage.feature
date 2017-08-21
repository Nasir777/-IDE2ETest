Feature: Is this the vehicle you are looking for? page opens and vehicle detail is displayed
  Scenario: Check and confirm that the vehicle serached is correct.

    Given that  Is this the vehicle you are looking for? page is open
    Then on Is this the vehicle you are looking for? page - check vehicle registration number is displayed
    And on Is this the vehicle you are looking for? page - check 'make of vehicle' is displayed
    And on Is this the vehicle you are looking for? page - check 'colour of vehicle' is displayed
    And on Is this the vehicle you are looking for? page - check 'Yes radio button'is displayed
    And on Is this the vehicle you are looking for? page - check 'No radio button'is displayed
    And on Is this the vehicle you are looking for? page - check 'Continue button' is displayed
    Then on Is this the vehicle you are looking for? page - I select 'Yes radio button'
    Then on Is this the vehicle you are looking for? page - click on 'Continue button

