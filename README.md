# Omnicuris Technical Assignment E-commerce Application

[![Build Status](https://travis-ci.org/codecentric/springboot-sample-app.svg?branch=master)](https://travis-ci.org/codecentric/springboot-sample-app)
[![Coverage Status](https://coveralls.io/repos/github/codecentric/springboot-sample-app/badge.svg?branch=master)](https://coveralls.io/github/codecentric/springboot-sample-app?branch=master)
[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

Minimal [Spring Boot](http://projects.spring.io/spring-boot/) sample app.

## Requirements

For building and running the application you need:

- [JDK 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Maven 3](https://maven.apache.org)

## Built With
  * [Maven](https://maven.apache.org/) - Dependency Management
  * [JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) - Java™ Platform, Standard Edition Development Kit
  * [Spring Boot](https://spring.io/projects/spring-boot) - Framework to ease the bootstrapping and development of new Spring Applications
  * [MySQL](https://www.mysql.com/) - Open-Source Relational Database Management System
  * [git](https://git-scm.com/) - Free and Open-Source distributed version control system
  * [Lombok](https://projectlombok.org/) - Never write another getter or equals method again, with one annotation your class has a fully featured builder, Automate your logging variables, and much more.
  * [Swagger](https://swagger.io/) - Open-Source software framework backed by a large ecosystem of tools that helps developers design, build, document, and consume RESTful Web services.

## External Tools Used

* [Postman](https://www.getpostman.com/) - API Development Environment (Testing Docmentation)

## To-Do
- [x] RESTful Web Service (CRUD)
- [x] MySQL (Connect to Single Schemas)

# Runnig this project 
  1. Clone this project https://github.com/sushildangi/omnicuris-technical-assignment-e-commerce.git
  2. create databases schema in mysql - **assignment-ecommerce**
  3. edit/change **username** and **password** in **applicaton.properties** file
  4. Run this Query in mysql
  
  ```sql 
    CREATE TABLE `items` (
      `id` bigint(20) NOT NULL AUTO_INCREMENT,
      `active` bit(1) DEFAULT NULL,
      `date_created` datetime(6) NOT NULL,
      `last_updated` datetime(6) DEFAULT NULL,
      `description` varchar(255) DEFAULT NULL,
      `image_url` varchar(255) DEFAULT NULL,
      `name` varchar(255) DEFAULT NULL,
      `sku` varchar(255) DEFAULT NULL,
      `unit_price` decimal(19,2) DEFAULT NULL,
      `units_in_stock` int(11) DEFAULT NULL,
      PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

  ```

   ```sql 
    CREATE TABLE `orders` (
      `id` bigint(20) NOT NULL AUTO_INCREMENT,
      `active` bit(1) DEFAULT NULL,
      `date_created` datetime(6) NOT NULL,
      `last_updated` datetime(6) DEFAULT NULL,
      `email_id` varchar(255) NOT NULL,
      `item_id` bigint(20) NOT NULL,
      `number_of_items` int(11) NOT NULL,
      PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

  ```
  5. Insert Sample data in items table
  
  ```sql 
      INSERT INTO items (SKU, NAME, DESCRIPTION, IMAGE_URL, ACTIVE, UNITS_IN_STOCK, UNIT_PRICE,DATE_CREATED) VALUES ('BOOK-TECH-1001', 'Become a Guru in JavaScript', 'Learn JavaScript at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!', 'assets/images/itemss/books/book-luv2code-1001.png', 1, 100, 20.99, NOW());
      INSERT INTO items (SKU, NAME, DESCRIPTION, IMAGE_URL, ACTIVE, UNITS_IN_STOCK, UNIT_PRICE,DATE_CREATED) VALUES ('BOOK-TECH-1002', 'Exploring Vue.js', 'Learn Vue.js at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!', 'assets/images/itemss/books/book-luv2code-1002.png', 1, 100, 14.99, NOW());
      INSERT INTO items (SKU, NAME, DESCRIPTION, IMAGE_URL, ACTIVE, UNITS_IN_STOCK, UNIT_PRICE,DATE_CREATED) VALUES ('BOOK-TECH-1003', 'Advanced Techniques in Big Data', 'Learn Big Data at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!', 'assets/images/itemss/books/book-luv2code-1003.png', 1, 100, 13.99, NOW());
      INSERT INTO items (SKU, NAME, DESCRIPTION, IMAGE_URL, ACTIVE, UNITS_IN_STOCK, UNIT_PRICE,DATE_CREATED) VALUES ('BOOK-TECH-1004', 'Crash Course in Big Data', 'Learn Big Data at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!', 'assets/images/itemss/books/book-luv2code-1004.png', 1, 100, 18.99, NOW());
      INSERT INTO items (SKU, NAME, DESCRIPTION, IMAGE_URL, ACTIVE, UNITS_IN_STOCK, UNIT_PRICE,DATE_CREATED) VALUES ('BOOK-TECH-1005', 'JavaScript Cookbook', 'Learn JavaScript at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!', 'assets/images/itemss/books/book-luv2code-1005.png', 1, 100, 23.99, NOW());
      INSERT INTO items (SKU, NAME, DESCRIPTION, IMAGE_URL, ACTIVE, UNITS_IN_STOCK, UNIT_PRICE,DATE_CREATED) VALUES ('BOOK-TECH-1006', 'Beginners Guide to SQL', 'Learn SQL at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!', 'assets/images/itemss/books/book-luv2code-1006.png', 1, 100, 14.99, NOW());
      INSERT INTO items (SKU, NAME, DESCRIPTION, IMAGE_URL, ACTIVE, UNITS_IN_STOCK, UNIT_PRICE,DATE_CREATED) VALUES ('BOOK-TECH-1007', 'Advanced Techniques in JavaScript', 'Learn JavaScript at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!', 'assets/images/itemss/books/book-luv2code-1007.png', 1, 100, 16.99, NOW());
      INSERT INTO items (SKU, NAME, DESCRIPTION, IMAGE_URL, ACTIVE, UNITS_IN_STOCK, UNIT_PRICE,DATE_CREATED) VALUES ('BOOK-TECH-1008', 'Introduction to Spring Boot', 'Learn Spring Boot at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!', 'assets/images/itemss/books/book-luv2code-1008.png', 1, 100, 25.99, NOW());
      INSERT INTO items (SKU, NAME, DESCRIPTION, IMAGE_URL, ACTIVE, UNITS_IN_STOCK, UNIT_PRICE,DATE_CREATED) VALUES ('BOOK-TECH-1009', 'Become a Guru in React.js', 'Learn React.js at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!', 'assets/images/itemss/books/book-luv2code-1009.png', 1, 100, 23.99, NOW());
      INSERT INTO items (SKU, NAME, DESCRIPTION, IMAGE_URL, ACTIVE, UNITS_IN_STOCK, UNIT_PRICE,DATE_CREATED) VALUES ('BOOK-TECH-1010', 'Beginners Guide to Data Science', 'Learn Data Science at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!', 'assets/images/itemss/books/book-luv2code-1010.png', 1, 100, 24.99, NOW());
      INSERT INTO items (SKU, NAME, DESCRIPTION, IMAGE_URL, ACTIVE, UNITS_IN_STOCK, UNIT_PRICE,DATE_CREATED) VALUES ('BOOK-TECH-1011', 'Advanced Techniques in Java', 'Learn Java at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!', 'assets/images/itemss/books/book-luv2code-1011.png', 1, 100, 19.99, NOW());
      INSERT INTO items (SKU, NAME, DESCRIPTION, IMAGE_URL, ACTIVE, UNITS_IN_STOCK, UNIT_PRICE,DATE_CREATED) VALUES ('BOOK-TECH-1012', 'Exploring DevOps', 'Learn DevOps at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!', 'assets/images/itemss/books/book-luv2code-1012.png', 1, 100, 24.99, NOW());
      INSERT INTO items (SKU, NAME, DESCRIPTION, IMAGE_URL, ACTIVE, UNITS_IN_STOCK, UNIT_PRICE,DATE_CREATED) VALUES ('BOOK-TECH-1013', 'The Expert Guide to SQL', 'Learn SQL at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!', 'assets/images/itemss/books/book-luv2code-1013.png', 1, 100, 19.99, NOW());
      INSERT INTO items (SKU, NAME, DESCRIPTION, IMAGE_URL, ACTIVE, UNITS_IN_STOCK, UNIT_PRICE,DATE_CREATED) VALUES ('BOOK-TECH-1014', 'Introduction to SQL', 'Learn SQL at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!', 'assets/images/itemss/books/book-luv2code-1014.png', 1, 100, 22.99, NOW());
      INSERT INTO items (SKU, NAME, DESCRIPTION, IMAGE_URL, ACTIVE, UNITS_IN_STOCK, UNIT_PRICE,DATE_CREATED) VALUES ('BOOK-TECH-1015', 'The Expert Guide to JavaScript', 'Learn JavaScript at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!', 'assets/images/itemss/books/book-luv2code-1015.png', 1, 100, 22.99, NOW());
      INSERT INTO items (SKU, NAME, DESCRIPTION, IMAGE_URL, ACTIVE, UNITS_IN_STOCK, UNIT_PRICE,DATE_CREATED) VALUES ('BOOK-TECH-1016', 'Exploring React.js', 'Learn React.js at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!', 'assets/images/itemss/books/book-luv2code-1016.png', 1, 100, 27.99, NOW());
      INSERT INTO items (SKU, NAME, DESCRIPTION, IMAGE_URL, ACTIVE, UNITS_IN_STOCK, UNIT_PRICE,DATE_CREATED) VALUES ('BOOK-TECH-1017', 'Advanced Techniques in React.js', 'Learn React.js at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!', 'assets/images/itemss/books/book-luv2code-1017.png', 1, 100, 13.99, NOW());
      INSERT INTO items (SKU, NAME, DESCRIPTION, IMAGE_URL, ACTIVE, UNITS_IN_STOCK, UNIT_PRICE,DATE_CREATED) VALUES ('BOOK-TECH-1018', 'Introduction to C#', 'Learn C# at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!', 'assets/images/itemss/books/book-luv2code-1018.png', 1, 100, 26.99, NOW());
      INSERT INTO items (SKU, NAME, DESCRIPTION, IMAGE_URL, ACTIVE, UNITS_IN_STOCK, UNIT_PRICE,DATE_CREATED) VALUES ('BOOK-TECH-1019', 'Crash Course in JavaScript', 'Learn JavaScript at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!', 'assets/images/itemss/books/book-luv2code-1019.png', 1, 100, 13.99, NOW());
      INSERT INTO items (SKU, NAME, DESCRIPTION, IMAGE_URL, ACTIVE, UNITS_IN_STOCK, UNIT_PRICE,DATE_CREATED) VALUES ('BOOK-TECH-1020', 'Introduction to Machine Learning', 'Learn Machine Learning at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!', 'assets/images/itemss/books/book-luv2code-1020.png', 1, 100, 19.99, NOW());
      INSERT INTO items (SKU, NAME, DESCRIPTION, IMAGE_URL, ACTIVE, UNITS_IN_STOCK, UNIT_PRICE,DATE_CREATED) VALUES ('BOOK-TECH-1021', 'Become a Guru in Java', 'Learn Java at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!', 'assets/images/itemss/books/book-luv2code-1021.png', 1, 100, 18.99, NOW());
      INSERT INTO items (SKU, NAME, DESCRIPTION, IMAGE_URL, ACTIVE, UNITS_IN_STOCK, UNIT_PRICE,DATE_CREATED) VALUES ('BOOK-TECH-1022', 'Introduction to Python', 'Learn Python at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!', 'assets/images/itemss/books/book-luv2code-1022.png', 1, 100, 26.99, NOW());
      INSERT INTO items (SKU, NAME, DESCRIPTION, IMAGE_URL, ACTIVE, UNITS_IN_STOCK, UNIT_PRICE,DATE_CREATED) VALUES ('BOOK-TECH-1023', 'Advanced Techniques in C#', 'Learn C# at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!', 'assets/images/itemss/books/book-luv2code-1023.png', 1, 100, 22.99, NOW());
      INSERT INTO items (SKU, NAME, DESCRIPTION, IMAGE_URL, ACTIVE, UNITS_IN_STOCK, UNIT_PRICE,DATE_CREATED) VALUES ('BOOK-TECH-1024', 'The Expert Guide to Machine Learning', 'Learn Machine Learning at your own pace. The author explains how the technology works in easy-to-understand language. This book includes working examples that you can apply to your own projects. Purchase the book and get started today!', 'assets/images/itemss/books/book-luv2code-1024.png', 1, 100, 16.99, NOW());

  ```
  
  6. Run Project One time using Spring boot command - **mvn spring-boot:run** or using eclipse IDE run as Java Application
  
  ### Items URLs

|  URL |  Method | Remarks |
|----------|--------------|--------------|
|`http://localhost:8080/api/items`                               | GET    | List of all items|
|`http://localhost:8080/api/items/1`                             | GET    | Get Single Item|
|`http://localhost:8080//api/items`                              | POST   | Create new Item|
|`http://localhost:8080/api/items`                               | PUT    | Update existing Item|
|`http://localhost:8080/api/items/1`                             | DELETE | Delete existing Item|
  


