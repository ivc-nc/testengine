Feature: Get REST service data

@rest @call
Scenario: evaluate data in rest service-call response

Given I call: https://jsonplaceholder.typicode.com/posts
Then the response data contains: a

@rest @call @configuration
Scenario: evaluate data-response from configured rest service
Given I call the service: posts
Then the response data contains: a


@xml @file @dataload
Scenario: get and print testdata from xml file
When I get the xml testdata from: plant_catalog
When I print testdata to the log

