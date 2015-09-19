# SeleniumWebTestExample
An example test suite to test a web page with selenium

To demonstrate website testing with Selenium some preparations need to be done:
- Go to the the website <code>https://simscale.com</code> and create a user account for yourself. (The main testing target is <code>https://platform.simscale.com</code>)
- The first 3 tutorial projects have to be created and be named: "Tutorial-01: Connecting rod stress analysis" "Tutorial-02: Pipe junction flow" "Tutorial-03: Differential casing thermal analysis" "Tutorial-02" project has to have a geometry named "CAD-pipe-junction_v1" (Otherwise parameters have to be changed in CommonParameters.java)
- Clone the repository: <code>git clone https://github.com/TCoffeemug/SeleniumWebTestExample</code>
- Change the login credentials (and other parameters if needed) in /util/CommonParameters.java
- If not done yet, <a href=https://maven.apache.org/install.html>install maven</a>
- I like to work on my code in the <a href=https://eclipse.org/downloads/>Eclipse IDE</a>, which also has a maven plugin
- Do a <code>maven build</code> on the project
- You can either run the tests individually (run as JUNIT tests) or as a test suite using the TestRunner (run as JAVA Application)


You'll find different automation scripts, that test the following

(1) Successful logging in
- Requirement: The login panel must disappear and the list of project must be populated with a few projects.
- Test Case: LoginSuccess.java

(2) Failed logging attempt, e.g., invalid password
- Requirement: The login panel must remain shown and the corresponding error message must be displayed to the user.
- Test Case: to be uploaded

(3) Rename a project
- Requirement: Starting from (1), right-click on a project in the left panel and choose rename. The project must be displayed in the list of projects in the same position, with the new name.
- Test Case: to be uploaded

(4) Visualizing a geometry
- Requirement: Starting from (1), click on "Mesh Creator" -> "Geometries" -> and the first geometry. The panel on the right must display the geometry, according to the screenshot that you will create yourself.  While it is possible to compare to images, I don't think the effort is not feasible in this scope.
- Test Case: to be uploaded

(5) Mesh Geometry
- Requirement: Starting from (4), click on "Mesh Geometry". In the Mesh Operation Panel press "Start". In the confirmation dialog , press "yes".  The "Job Status" panel in the lower left corner should display that a new operation started. After maximum 5 minutes, it should display "Finished".
- Test Case: to be uploaded


Have fun playing around with it,
Thomas Eisbrenner
