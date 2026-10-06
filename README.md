# Students_and_courses
The concept:
An information system for managing the learning process that links students and courses into a single database. The system allows you to keep records of students, catalog courses, enroll students in courses, track academic performance and generate reports.

Layer Technology
TypeScript language
Backend Node.js + NestJS (or Express)
Database PostgreSQL 16
ORM Prisma / TypeORM
Frontend React + Vite + Tailwind CSS
Tests Jest, Supertest
Containerization Docker + docker-compose


Структура папок проекта
Students_and_courses
.github/workflows/ci.yml
 docs/
 src/
 main/
 java/com/example/studentscourses/
 StudentsCoursesApplication.java
 config/            # Security, Swagger
 controller/        # REST-контроллеры
 service/           # бизнес-логика
 repository/        # Spring Data JPA
 entity/            # сущности БД
 dto/               # DTO
 exception/         # обработка ошибок
 resources/
 application.yml
 db/migration/      # Flyway
 templates/
 test/java/...              # тесты
 .env.example
 .gitignore
 docker-compose.yml
 Dockerfile
 LICENSE
 README.md
 pom.xml
 target/                        # (в .gitignore)
