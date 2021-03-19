
@tag
Feature: OpenWeatherApi

  @tag1
  Scenario: Fetch the details without api key
    Given base uri is http://api.openweathermap.org/data/
    When I get user detail
    Then Unauthorized status code is displayed

  @tag2
  Scenario: register first station
    Given base uri is http://api.openweathermap.org/data/
    When I register the details of first station
    Then created status code message is displayed
    
  @tag3
  Scenario: register second station
    Given base uri is http://api.openweathermap.org/data/
    When I register the details of second station
    Then created status code is displayed
    
  @tag4
  Scenario: Fetch the details with api key
    Given base uri is http://api.openweathermap.org/data/
    When I get user details
    Then success status code is displayed
    
  @tag5
  Scenario: delete the registered stations
    Given base uri is http://api.openweathermap.org/data/
    When delete the stations
    Then Noc content status code is displayed
    
