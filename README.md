This is the exercise from Renju Mohan


**Implementation**
API Automation with Rest Assured, Extent Reports, and Cucumber

**BasePage**: src/test/java/cadmon/driver/BasePage.java Chromedriver is instantiated here

**Runner**: src/test/java/cadmon/runner/Runner.java this is to run the scenarios, step definition path is mentioned in glue.

**Steps**: src/test/java/cadmon/steps/AutomationTestSteps.java All the cucumber steps are defined in this file.

**Cucumber Reports**: src/target/cucumber-reports

**Extend Reports**: test-output/Html/ExtentHtml.html

**How to Run:**
Using IDE - Right Click on the Runner file and select Run.


##################################################################

> **Task description enhancement.**
The task description is mostly ready for development but would benefit from the below enhancements to ensure clarity and completeness, as below

•	Highlight properly that the key value should be 'Authorization'

•	There should be explicit constraints on the password field regarding its length and complexity requirements.

•	Explicitly list the expected HTTP status codes for all possible outcomes.

•	Detail standard error types and messages for common error scenarios.

#############################################################################

**Bugs Found**
1.	Optional Title Field:
o	Issue: When the title is not provided (since it is optional), the response should have a status code of 200. However, it currently returns a status code of 400.
o	**Expected**: HTTP 200
o	**Actual**: HTTP 400
2.	User Status Based on Rating:
o	Issue: When the rating is 5, the user status should be 'active'. However, it is currently set to 'new'.
o	**Expected**: Status 'active'
o	**Actual**: Status 'new'
3.	Rating Validation:
o	Issue: When the rating is 0, the response should have a status code of 200 and the user status should be 'rejected'. However, it currently returns a status code of 400 with the error message:
{
  "**errorType**": "BadRequest",
  "**errorMessage**": "Validation error - rating is required"
}
o	**Expected**: HTTP 200, Status 'rejected'
o	**Actual**: HTTP 400, Error Message: "Validation error - rating is required"
**Error Scenarios:**
1.	First Name Validation:
o	Issue: When the 'first name' is blank, the validation error should be: "Validation error - first name must be between 2 and 255 characters". However, it currently returns the error code 'ERR_FNAME_INVALID'.
o	**Expected**: "Validation error - first name must be between 2 and 255 characters"
o	**Actual**: 'ERR_FNAME_INVALID'
2.	Empty Password:
o	Issue: When the password field is empty, the response should have a status code of 400 with the correct validation error message. However, it currently returns a status code of 200 with no validation error message.
o	**Expected**: HTTP 400 with appropriate validation error message
o	**Actual**: HTTP 200, No validation error message

