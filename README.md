### Aplication
This application is for testing UI and API layers in a web application

### Technologies
- Java 11
- Selenium (Aquality-selenium)
- Api (Rest assured)
- Json (jackson-databind)
- TestNg

### REST API
| URI                             | Method     | Description                            |
| ---------------------           | ----       | ------------------------               |
| *token/get*                     | **POST**   | Get a personal token for user identification          |
| *test/get/json*        | **POST**       | Get a list of tests in json format                    |
| *test/put*             | **POST**       | Add test                                              |
| *test/put/log*         | **POST**       | Add a log to the added test                           |
| *test/put/attachment*  | **POST**       | Add attachment to added test                          |

### Steps of the Executed Script

1. Obtaining a token for option number 2
2. Adding a token to cookies and passing basic authorization
3. From the received projects, select NEXAGE
4. We send an api request to the web application to get a list of tests in the NEXAGE project in json format, compare with UI
5. Creating a new project with adding a log and a screenshot of the page using the UI and API
