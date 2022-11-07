Feature:   Wikipedia Search something and Functionality Title Verification

@mywip
  Scenario: My Wikipedia Search Functionality Title Verification

    Given my User is on Wikipedia home page
    When my User types Steve Jobs in the wiki search box
    And my  User clicks wiki search button
    Then my  User sees Steve Jobs is in the wiki title
