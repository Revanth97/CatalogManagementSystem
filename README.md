# CatalogManagementSystem

Steps to run the Spring Boot Application

1) Clone the repository.
2) Import the project as maven project into the your IDE workspace.
3) Run the application as spring boot app. You can change the embedded server port in application.properties. It's currently configured to 8080
4) The application uses H2 (an in memory database). Once you start the server, you can go to localhost:(port)/h2-console to open the web UI of the database.
5) The default jdbc url for the h2 database is already configured in application.properties. If the jdbc url is different in the UI than the one configured in property file, copy paste jdbc url from property file in the web UI.

The app has all the CRUD operations which can be tested using cURL or Postman. 

The search functionality is case insensitive and the search is on description and title fields on the SKU model.
