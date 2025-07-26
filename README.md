# 🧠 Quiz App - Microservices Architecture

This project is a **Microservices-based Quiz Application** built using **Spring Boot**, focusing on inter-service communication using **Eureka Service Discovery** and **Feign Clients**. The system is divided into four distinct microservices with clearly defined responsibilities.

There is **no frontend** in this project. All services and endpoints are tested using **Postman**.

---

## 🛠️ Tech Stack & Tools

- **Java**
- **Spring Boot**
- **Spring Cloud Netflix Eureka**
- **Spring Cloud Gateway**
- **Feign Client**
- **Maven**
- **Postman** (for API testing)
- **IntelliJ IDEA**

---

## 🧩 Microservices Breakdown

| Service           | Description                         | Port  |
|------------------|-------------------------------------|-------|
| **Quiz Service**      | Handles quizzes and fetches questions via Feign | `8082` |
| **Question Service**  | Manages question CRUD operations        | `8081` |
| **Service Registry**  | Eureka Server for service discovery     | `8761` |
| **API Gateway**       | Gateway to route client requests        | `8765` |

---


