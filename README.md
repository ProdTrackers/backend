# API Endpoints Guide

## User Management

### List all users
- **GET** `/api/v1/user/all`

### Register a new user
- **POST** `/api/v1/user/register`
- **Body:**
  ```json
  {
    "firstName": "string (min 2, max 50, required)",
    "lastName": "string (min 2, max 50, required)",
    "email": "string (email, required)",
    "password": "string (min 6, required)"
  }

### Login
- **POST** `/api/v1/user/login`
  - **Body:**
  ```json
    {
      "email": "string (email, required)",
      "password": "string (min 6, required)"
    }

### Get user by ID
- **GET** `/api/v1/user/{id}`

## Store Management

### Register new store
- **POST** `/api/v1/stores/register`
- **Body:**
    ```json
    {
      "name": "string (min 2, max 100, required)"
    }
    ```
  
### Get store by ID
- **GET** `/api/v1/stores/{id}`

### List all stores
- **GET** `/api/v1/stores/all`

## Inventory Management

### Register new item
- **POST** `/api/v1/inventory`
- **Body:**
    ```json
    {
      "name": "string (min 2, max 100, required)",
      "color": "string (optional)",
      "size": "string (optional)",
      "imageUrl": "string (optional)",
      "price": "number (optional)",
      "storeId": "number (required)"
    }
    ```

### Get item by ID
- **GET** `/api/v1/inventory/{id}`

### List all inventory
- **GET** `/api/v1/inventory`

## Reservation Management

### Create new reservation
- **POST** `/api/v1/reservations`
- **Body:**
    ```json
    {
      "userId": "number (required)",
      "inventoryId": "number (required)"
    }
    ```

### Get reservation by ID
- **GET** `/api/v1/reservations/{id}`

### List all reservations
- **GET** `/api/v1/reservations`


## IoT Device Management

### Register new IoT device
- **POST** `/api/v1/iot-devices`
- **Body:**
    ```json
    {
      "deviceIdentifier": "string (required)",
      "latitude": "number (optional)",
      "longitude": "number (optional)",
      "inventoryId": "number (required)"
    }
    ```
### Get IoT device by ID
- **GET** `/api/v1/iot-devices/{id}`

### List all IoT devices
- **GET** `/api/v1/iot-devices`