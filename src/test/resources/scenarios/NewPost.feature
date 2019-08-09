Feature: New Post

  Scenario: Add new Post with Filter
    Given user is logged in

    When  user starts new post
    Then  user gets to Filter page

    When  user selects filter Ludwig
    Then  user gets to Share page
    And   user adds text

    When  user shares the post
    Then  post is displayed in user's gallery
    And   post contains correct text

