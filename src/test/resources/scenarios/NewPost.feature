Feature: New Post

  Scenario: Add new Post with Filter
    Given user is logged in
    When  user starts new post
    And   user gets to Filter page
    And   user selects filter Ludwig
    And   user gets to Share page
    And   user adds text 'toto je velmi dolezity #post #veryinteresting'
    And   user shares the post

    Then  post is displayed in user's gallery
    And   post contains text 'toto je velmi dolezity #post #veryinteresting'

