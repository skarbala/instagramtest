Feature: New Post

  Scenario: Add new Post with Filter
    Given user is logged in

    When  user starts new post
    And   user takes photo

    When  user selects filter Reyes
    Then  user gets to Share page
    And   user adds text

    When  user shares the post
    Then  post appears in feed

