# API Tasks

## Overview

This repository contains the source code for the API Tasks project. The API Tasks is a simple RESTful API for managing tasks, allowing users to perform basic CRUD operations on tasks.

## Table of Contents

- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Configuration](#configuration)
- [Usage](#usage)
  - [Endpoints](#endpoints)
- [Testing](#testing)

## Getting Started

### Prerequisites

- [Java](https://www.oracle.com/java/technologies/javase-downloads.html) (version 8 or higher)
- [Maven](https://maven.apache.org/download.cgi)
- [MySQL](https://dev.mysql.com/downloads/) (or another relational database)

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/honeybadger2788/api-tasks.git
    ```

2. Build the project:
    ```bash
    cd api-tasks
    mvn clean install
    ```
3. Run the application:
   ```bash
    mvn spring-boot:run
    ```
## Configuration

- Configure the database connection in `application.properties` or `application.yml`.
- Customize other application settings as needed.

## Usage

### Endpoints

- **POST /tasks/add**: Create a new task.
- **GET /tasks**: Retrieve a list of all tasks.
- **PUT /tasks/update**: Update an existing task.
- **DELETE /tasks/delete/{id}**: Delete a task by ID.

## Testing

To run tests, use the following command:

```bash
mvn test
```
