# EngageHub CRM

Welcome to the EngageHub CRM project! EngageHub CRM is a versatile customer relationship management platform designed for various industries such as gyms, salons, restaurants, clinics, and more. This project uses a microservices architecture with Spring Boot, Netflix DGS for GraphQL, PostgreSQL for the database, Redis for caching, and Elasticsearch for search functionalities.
!
## Table of Contents

- [Features](#features)
- [Technology Stack](#technology-stack)
- [Architecture](#architecture)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [Running the Application](#running-the-application)
- [Contributing](#contributing)
- [License](#license)

## Features

- **Appointment and Booking Management**: Online booking, calendar management, and automated reminders.
- **Customer Profiles and Management**: Advanced customer search, detailed profiles, and loyalty programs.
- **Review and Feedback System**: Integrated reviews, moderation tools, and analytics.
- **Payment Processing**: Secure payments, multiple payment methods, and invoice generation.
- **QR Code Integration**: Easy access, promotions, and mobile integration.
- **Marketing and Communication**: Campaign management, customer segmentation, and push notifications.
- **Customer Support and Engagement**: Real-time chat support, ticketing system, and FAQ knowledge base.
- **Analytics and Reporting**: Sales and bookings reports, performance metrics, and predictive analytics.

## Technology Stack

- **Frontend**: React.js, Apollo Client, Redux
- **Backend**: Spring Boot, Netflix DGS (GraphQL)
- **Database**: PostgreSQL, Redis, Elasticsearch
- **Infrastructure**: Docker, Kubernetes, Jenkins/GitHub Actions

## Architecture

EngageHub CRM follows a microservices architecture to ensure scalability, performance, and maintainability. The high-level architecture includes the following components:

1. **Client Layer**: React.js with Apollo Client for frontend, utilizing Redux for state management.
2. **Backend Layer**: Spring Boot with Netflix DGS for GraphQL API, modular microservices architecture.
3. **Database Layer**: PostgreSQL for primary structured data, Redis for caching, Elasticsearch for search functionalities.
4. **Infrastructure Layer**: Docker for containerization, Kubernetes for orchestration, Jenkins/GitHub Actions for CI/CD.

## Project Structure

```plaintext
engagehub
├── README.md
├── settings.gradle
├── build.gradle
├── common
│   ├── build.gradle
│   └── src
│       └── main
│           └── java
│               └── com
│                   └── engagehub
│                       └── crm
│                           ├── config
│                           │   └── GraphQLConfig.java
│                           └── util
│                               └── DateUtils.java
├── service-discovery
│   ├── build.gradle
│   └── src
│       └── main
│           └── java
│               └── com
│                   └── engagehub
│                       └── crm
│                           └── discovery
│                               └── DiscoveryApplication.java
├── api-gateway
│   ├── build.gradle
│   └── src
│       └── main
│           └── java
│               └── com
│                   └── engagehub
│                       └── crm
│                           └── gateway
│                               └── ApiGatewayApplication.java
├── appointment-service
│   ├── build.gradle
│   └── src
│       └── main
│           └── java
│               └── com
│                   └── engagehub
│                       └── crm
│                           └── appointment
│                               ├── AppointmentServiceApplication.java
│                               ├── model
│                               │   └── Appointment.java
│                               ├── repository
│                               │   └── AppointmentRepository.java
│                               ├── service
│                               │   └── AppointmentService.java
│                               └── dgs
│                                   └── AppointmentDataFetcher.java
├── customer-service
│   ├── build.gradle
│   └── src
│       └── main
│           └── java
│               └── com
│                   └── engagehub
│                       └── crm
│                           └── customer
│                               ├── CustomerServiceApplication.java
│                               ├── model
│                               │   └── Customer.java
│                               ├── repository
│                               │   └── CustomerRepository.java
│                               ├── service
│                               │   └── CustomerService.java
│                               └── dgs
│                                   └── CustomerDataFetcher.java
├── business-service
│   ├── build.gradle
│   └── src
│       └── main
│           └── java
│               └── com
│                   └── engagehub
│                       └── crm
│                           └── business
│                               ├── BusinessServiceApplication.java
│                               ├── model
│                               │   └── Business.java
│                               ├── repository
│                               │   └── BusinessRepository.java
│                               ├── service
│                               │   └── BusinessService.java
│                               └── dgs
│                                   └── BusinessDataFetcher.java
└── docker
    ├── Dockerfile
    └── docker-compose.yml
```

## Getting Started

### Prerequisites

- **Java 21** or higher
- **Gradle 8** or higher
- **Docker** and **Docker Compose**
- **PostgreSQL** database

### Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/engagehub-crm.git
   cd engagehub-crm
   ```

2. **Build the project:**
   ```bash
   ./gradlew build
   ```

3. **Run Docker Compose:**
   ```bash
   docker-compose up --build
   ```

4. **Access the application:**
    - GraphQL Playground: `http://localhost:8080/graphql`

## Running the Application

### Running Locally

1. **Start PostgreSQL:**
   Ensure PostgreSQL is running and create a database for the application.

2. **Configure application properties:**
   Update the database configurations in `application.properties` for each service.

3. **Run each service:**
   ```bash
   ./gradlew :service-name:bootRun
   ```

### Running with Docker

1. **Build Docker images:**
   ```bash
   docker-compose build
   ```

2. **Start containers:**
   ```bash
   docker-compose up
   ```

## Contributing

Contributions are welcome! Please fork the repository and create a pull request with your changes. Make sure to follow the coding guidelines and include relevant tests.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
