Feature: API Testing

@api
Scenario: Get user details
Given API is ready
When I get user with id 1
Then response status should be 200