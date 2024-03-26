# MotusAPI

<div align="center">
    <img src="https://img.shields.io/github/contributors/naofel-eal/MotusAPI.svg?style=for-the-badge" alt="Contributors">
    <img src="https://img.shields.io/github/forks/naofel-eal/MotusAPI.svg?style=for-the-badge" alt="Forks">
    <img src="https://img.shields.io/github/stars/naofel-eal/MotusAPI.svg?style=for-the-badge" alt="Stars">
    <img src="https://img.shields.io/github/issues/naofel-eal/MotusAPI.svg?style=for-the-badge" alt="Issues">
</div>

## Overview

MotusAPI is a RESTful service designed to support the game of Motus by providing functionalities to fetch words based on language ISO codes and to validate words for given languages. This document outlines the available endpoints, their parameters, and possible responses.  
You can find the frontend repository here: [MotusIHM](https://github.com/Naofel-eal/MotusIHM)

## Implementation

This API is implemented following the Clean Architecture principles to ensure that the system is maintainable, testable, and scalable. This architecture separates concerns into independent layers, allowing for flexibility and the easy addition of new features in the future. Additionally, the development of this API employed Test-Driven Development (TDD) practices to ensure high-quality code and facilitate future maintenance and scalability. By prioritizing tests before writing the actual code, we were able to create a more reliable and robust system from the outset.

## API Endpoints

### Fetch Words

Retrieves a list of words based on the specified language ISO code and the number of words.

#### Request

`GET /fetch`

| Parameter     | Type   | Description                              |
|---------------|--------|------------------------------------------|
| `isocode`     | String | ISO code of the language (e.g., "EN").   |
| `numberOfWords` | Short  | The number of words to retrieve.        |

#### Response

| Status Code | Description                            |
|-------------|----------------------------------------|
| 200         | Successful retrieval of words.         |
| 400         | Bad Request (invalid parameters).      |
| 404         | Not Found (language not supported).    |

### Validate Word

Validates whether a given word exists for the specified language.

#### Request

`GET /validate`

| Parameter | Type   | Description                              |
|-----------|--------|------------------------------------------|
| `isocode` | String | ISO code of the language (e.g., "EN").   |
| `word`    | String | The word to be validated.                |

#### Response

| Status Code | Description                      |
|-------------|----------------------------------|
| 200         | Word is valid for the language.  |
| 400         | Bad Request (invalid parameters).|
| 404         | Not Found (word not valid).      |

### Get Languages

Retrieves a list of available languages for the game.

#### Request

`GET /languages`

No parameters.  

#### Response

| Status Code | Description                            |
|-------------|----------------------------------------|
| 200         | Successful retrieval of words.         |

## Getting Started

To use MotusAPI, you will need to have an environment capable of running Spring Boot applications. Ensure you have Java and Maven installed, then follow these steps to run the application:

1. Clone the repository: `git clone https://github.com/Naofel-eal/MotusAPI.git`  
2. Navigate to the project directory: `cd MotusAPI`
3. Build the project: `mvn clean install`
4. Run the application: `mvn spring-boot:run`


The API will be accessible at `http://localhost:8080`.

## Contributing

Contributions to MotusAPI are welcome. Please feel free to fork the repository, make your changes, and submit a pull request.
