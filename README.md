Introduction

This document provides a comprehensive overview of a Spring Boot application designed to handle dynamic string manipulation within a predefined JSON model. The objective of this assignment is to develop a REST API that accepts input parameters, performs string manipulation on a JSON structure, and saves the modified JSON model to a database. This documentation will guide you through the setup, design, implementation, and testing of the application.

Project Setup

Steps to Set Up the Spring Boot Application
1. Initialize the Project:

- Create a new Spring Boot project using Spring Initializr or your preferred IDE.
- Choose dependencies such as Spring Web, Spring Data JPA, and H2 Database.

2. Configure Dependencies:

- Ensure that spring-boot-starter-web, spring-boot-starter-data-jpa, and h2 dependencies are included in your pom.xml.

3. Set Up the Project Structure:

- Create the following packages: controller, service, repository, entity, and model.

4. Implement the Core Components:

- Create entity classes, repositories, services, controllers, and application configuration as detailed below.

List of Dependencies Used

- Spring Boot Starter Web: Provides essential web functionalities including REST API support.
- Spring Boot Starter Data JPA: Facilitates JPA-based data access using Hibernate.
- H2 Database: An in-memory database used for development and testing.
- Jackson Databind: For JSON processing and manipulation

REST API Design

- Endpoint URL: /api/manipulate
- Method: POST
- Description: Accepts a string of inputs that specify how to replace values in a predefined JSON model. Returns the modified JSON model.

Input and Output Format
- Input: A query parameter inputs that is a comma-separated string of key-value pairs. Each pair is separated by ::: (e.g., "New:::NewDocument,Open:::OpenDocument").
- Output: A JSON object with the manipulated values based on the input parameters.

Sample API Call
URL: http://localhost:8080/api/manipulate
Method: POST
Params: inputs: "New:::NewDocument,Open:::OpenDocument"
Response:
![Screenshot (26)](https://github.com/user-attachments/assets/348db8d8-6bd9-45f4-9f88-292a1a166fac)

String Manipulation Logic

Parsing Input:
- Split the input string by commas to get individual key-value pairs.
- Split each key-value pair by ::: to separate keys and values.

String Replacement:
- Traverse the JSON model.
- For each key in the key-value pairs, replace occurrences of the key in the JSON model with the corresponding value.

How the JSON Model is Traversed and Modified
Traversal:
- Recursively navigate through the JSON structure.
- Identify and replace matching values in the menuitem array.

Modification:
- Update the values of the JSON model based on the parsed input.

Database Integration

Description of the Database Schema
- Table Name: menu_entity
- Columns:
      - id: Primary key, auto-generated.
      - json_model: Stores the JSON data as a string.

Steps to Set Up the Database
Configure Database:
      - Use H2 in-memory database for simplicity.
      - Configure database properties in application.properties.

Create Entity Class:
- Define MenuEntity class with id and jsonModel fields.

Save to Database:
- Use the MenuRepository to save the updated JSON model after manipulation.
- Implement save logic in the MenuService class.

Testing
Testing Strategy

Unit Testing:
- Test individual components such as services and controllers.
- Use @Mock annotations to mock dependencies.

Integration Testing:
- Test the complete workflow including API endpoints and database interactions.
- Use @SpringBootTest for comprehensive integration tests.

Test Cases
Test Case 1: Validate JSON Manipulation
- Input: "New:::NewDocument,Open:::OpenDocument"
- Expected Output: Modified JSON model with New replaced by CreateDoc and Open by OpenDoc.

Test Case 2: Validate Database Saving
- Action: POST modified JSON model.
- Expected Outcome: JSON model should be saved correctly in the database.

Tools Used for Testing
Postman: For manual API testing.

Testing in Postman steps:

1. Open Postman.
2. Create a New Request with:
        Method: POST
        URL: http://localhost:8080/api/manipulate
3. Add Query Parameters:
        Key: inputs
        Value: "New:::NewDocument,Open:::OpenDocument"
4. Send the Request.
5. Check the Response.

Conclusion
This application successfully demonstrates dynamic string manipulation within a JSON model via a REST API. The setup involves creating a Spring Boot application with endpoints to process and save JSON data. Challenges included handling JSON traversal and ensuring correct database integration, both of which were addressed with careful design and testing.
