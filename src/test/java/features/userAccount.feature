Feature: User Account API Testing

  Scenario Outline: User Created  Successfully
    Given I set the API endpoint and create payload for creating a user with  details "<title>" "<firstName>" "<lastName>" "<dateOfBirth>" "<email>" "<password>" <rating>
    When I send a POST request using "CreateUserAPI" with "POST" http request
    Then I should receive a status code of 200
    And "status" in response body is "<mainStatusValue>"
    And "data.status" in response body is "<subStatusValue>"
    And "error" in response body is "<errorFieldValue>"


    Examples:
      | title | firstName     | lastName     | dateOfBirth | email          | password | rating | mainStatusValue | subStatusValue | errorFieldValue |
      | Mr    | testFirstName | testLastName | 1987-06-06  | test@email.com | rrrrr    | 10     | Success         | active         | null            |
      |       | testFirstName | testLastName | 1987-06-06  | test@email.com | rrrrr    | 10     | Success         | active         | null            |
      | Mr    | testFirstName | testLastName | 1987-06-06  | test@email.com | rrrrr    | 5      | Success         | active         | null            |
      | Mr    | testFirstName | testLastName | 1987-06-06  | test@email.com | rrrrr    | 1      | Success         | new            | null            |
      | Mr    | testFirstName | testLastName | 1987-06-06  | test@email.com | rrrrr    | 0      | Success         | rejected       | null            |

  Scenario Outline: User Creation  Failure scenario
    Given I set the API endpoint and create payload for creating a user with  details "<title>" "<firstName>" "<lastName>" "<dateOfBirth>" "<email>" "<password>" <rating>
    When I send a POST request using "CreateUserAPI" with "POST" http request
    Then I should receive a status code of <statusCode>
    And "errorType" in response body is "BadRequest"
    And "errorMessage" in response body is "<erroMessage>"
    And "error" in response body is "null"


    Examples:
      | title  | firstName     | lastName     | dateOfBirth | email          | password | rating | statusCode | erroMessage                                                       |
      | Mr     |               | testLastName | 1987-06-06  | test@email.com | rrrrr    | 10     | 400        | Validation error - last name must be between 2 and 255 characters |
      | Mr     | testFirstName |              | 1987-06-06  | test@email.com | rrrrr    | 10     | 400        | Validation error - last name must be between 2 and 255 characters |
      | Mr     | testFirstName | testLastName |             | test@email.com | rrrrr    | 10     | 400        | Validation error - date of birth must be in YYYY-MM-DD format     |
      | Mr     | testFirstName | testLastName | 1987-06-06  |                | rrrrr    | 10     | 400        | Validation error - must provide valid e-mail add                  |
      | Mr     | testFirstName | testLastName | 1987-06-06  | test@email.com |          | 10     | 400        | Validation error - must provide valid passsword                   |
      | Mr     | testFirstName | testLastName | 1987-06-06  | test@email.com | rrrrr    | 0      | 400        | Validation error - rating is required                             |
      | Mrrrrr | testFirstName | testLastName | 1987-06-06  | test@email.com | rrrrr    | 10     | 400        | Validation error - unknown title                                  |

