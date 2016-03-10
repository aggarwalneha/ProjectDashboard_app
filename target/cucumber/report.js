$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/login.feature");
formatter.feature({
  "line": 1,
  "name": "Launch Project Dashboard",
  "description": "As a User\r\nI need to login to project dashboard application",
  "id": "launch-project-dashboard",
  "keyword": "Feature"
});
formatter.before({
  "duration": 243112728,
  "status": "passed"
});
formatter.scenario({
  "line": 5,
  "name": "Launch Project Dashboard Home Page",
  "description": "",
  "id": "launch-project-dashboard;launch-project-dashboard-home-page",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "Launch Url",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "user enter email for User authentication",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "user enter Password for User authentication",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "user click on SignIn",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "user should be on Project Dashboard Page",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginSteps.launch_url()"
});
formatter.result({
  "duration": 9641915051,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.enter_email()"
});
formatter.result({
  "duration": 1544283766,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.enter_password()"
});
formatter.result({
  "duration": 684204634,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.click_SignIn()"
});
formatter.result({
  "duration": 813469012,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.Verify_homepage()"
});
formatter.result({
  "duration": 15034924000,
  "status": "passed"
});
});