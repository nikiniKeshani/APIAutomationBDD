Feature: End to End BookStore API test
  I want perform end to end testing on bookstore swagger API to understand the defects and work 

  Scenario: Get All books
    Given I am on swagger page
    When I enter URL for getting books
    Then Book List is displayed

  Scenario: Add a book
    Given I am on swagger page
    When I enter URL for addinging books
    Then Book is Added    
    

  
