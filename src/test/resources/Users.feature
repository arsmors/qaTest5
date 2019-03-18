# new feature
# Tags: optional

Feature: Webservice automation

  Scenario: GET
    When I get to "https://reqres.in/api/users?page=2"
    Then the status code 200
    And response includes following
      | page     | 2 |
      | per_page | 3 |
    And response includes the following in any order
      | data[0].first_name | Eve  |
      | data[0].last_name  | Holt |
    And response headers includes
      | Server            | cloudflare |
      | Transfer-Encoding | chunked    |


  Scenario: POST
    Given request body
      | name    | arsens |
      | surname | moris |
    When I send POST to "https://reqres.in/api/users"
    Then the status is 201
    And response includes following body
      | name    | arsens |
      | surname | moris |
    And response headers includes
      | Server       | cloudflare |
      | X-Powered-By | Express    |

