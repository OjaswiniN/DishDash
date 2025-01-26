# DishDash

DishDash is a Spring Boot food ordering app that allows users to browse and order their favorite dishes from nearby restaurants.

## 📌 Clone the Repository
```sh
git clone git@github.com:OjaswiniN/DishDash.git
cd DishDash
```

## 🚀 Tech Stack
- Java
- Spring Boot
- PostgreSQL
- Redis
- Docker
- Gradle

## 📋 Requirements
- Java 17 or greater
- Redis
- Docker
- PostgreSQL

## 🛠 Setup
If you already have PostgreSQL and Redis running locally, you can skip the Docker setup.

### Start PostgreSQL and Redis using Docker:
```sh
docker-compose up postgres -d
docker-compose up redis -d
```

## 🔧 Build and Run
### Build the Application
```sh
./gradlew clean build
```

### Execute the Built JAR
```sh
java -jar build/libs/backend-0.0.1-SNAPSHOT.jar
```

## 📡 Run API
Test the API with:
```sh
curl --location 'http://localhost:8080/dishdash/api/v1/restaurants?latitude=11.929275&longitude=79.829584'
```

### 📄 Sample API Response
```json
{
  "restaurants": [
    {
      "restaurantId": "3700050",
      "name": "Baker Street",
      "city": null,
      "imageUrl": "https://b.zmtcdn.com/data/pictures/0/3700050/1c47128f7b7ad012a7375f9c426d1f71_featured_v2.jpg",
      "latitude": 11.929275,
      "longitude": 79.829584,
      "opensAt": "08:30",
      "closesAt": "22:00",
      "attributes": ["Bakery", "French"]
    }
  ]
}
```

> **Note:** API response depends on restaurant location and operating hours.

