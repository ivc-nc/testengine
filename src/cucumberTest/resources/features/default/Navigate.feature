Feature: Navigate to a webpage

@frontend @ignore
Scenario: Navigate to google.com

  Given I open a browser
  And navigate to www.google.com


  When I log in with user helloworld