# 🧠 Quiz App - Microservices Architecture

![Java](https://img.shields.io/badge/Java-17+-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Spring Cloud](https://img.shields.io/badge/Spring_Cloud-2022.x-6DB33F?style=for-the-badge&logo=spring-cloud&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-4.0.0-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![Postman](https://img.shields.io/badge/Postman-API_Testing-FF6C37?style=for-the-badge&logo=postman&logoColor=white)

---

This project is a **Microservices-based Quiz Application** built using **Spring Boot**. It demonstrates a distributed system where services communicate with each other using a **Eureka Service Discovery** server and **Feign Clients** for RESTful API calls.

The system is divided into four distinct microservices, each with clearly defined responsibilities. There is **no frontend** in this project; all services and endpoints are designed to be tested using an API client like **Postman**.

---

## 🛠️ Tech Stack & Tools

- **Java**: The core programming language for building the application.
- **Spring Boot**: Framework for creating stand-alone, production-grade Spring-based Applications.
- **Spring Cloud Netflix Eureka**: Service discovery server for locating services in the distributed system.
- **Spring Cloud Gateway**: Provides a simple, yet effective way to route to APIs.
- **Feign Client**: A declarative web service client that makes writing web service clients easier.
- **Maven**: Dependency management and project build tool.
- **Postman**: Used for testing all API endpoints.
- **IntelliJ IDEA**: The integrated development environment (IDE) used for development.

---

## 🧩 Microservices Breakdown

The application is composed of the following microservices:

| Service | Description | Port |
| :--- | :--- | :--- |
|  **API Gateway** | Routes all incoming client requests to the appropriate service. | `8765` |
| **Service Registry** | Eureka Server that allows all microservices to register and discover each other. | `8761` |
| **Question Service** | Manages all Create, Read, Update, and Delete (CRUD) operations for questions. | `8081` |
| **Quiz Service** | Handles quiz creation, fetches questions via a Feign Client, and calculates scores. | `8082` |

---

## 🚀 How to Run

1.  **Clone the repository:**
    ```
    git clone <your-repo-url>
    ```

2.  **Start the Services:**
    Launch the services in the following order. Wait for each service to start up completely before starting the next one.
    - **Service Registry** (Port: `8761`)
    - **Question Service** (Port: `8081`)
    - **Quiz Service** (Port: `8082`)
    - **API Gateway** (Port: `8765`)

3.  **Verify Eureka Dashboard:**
    Open your browser and navigate to `http://localhost:8761`. You should see `QUESTION-SERVICE`, `QUIZ-SERVICE`, and `GATEWAY-SERVICE` registered.

4.  **Test with Postman:**
    Use Postman to send requests to the API Gateway at `http://localhost:8765`.

    **Example Endpoints:**
    - `POST /question/add` (to add a new question)
    - `GET /question/allQuestions` (to retrieve all questions)
    - `POST /quiz/create?category=Java&numQ=5&title=JQuiz` (to create a new quiz)

