# TMDB Fetcher
A Java application that fetches data from an external API, processes it, and stores it in a PostgreSQL database. The project uses TMDB API to fetch data about Danish movies and stores it in a local database. the url is easy to change in the code.


## How It's Made:

**Tech used:** Java, Jackson, PostgreSQL, Maven, JUnit, Lombok

A small 4 day project to practice using Java to build a backend service that fetches data from an external API, processes it, and stores it in a database. The project uses Jackson for JSON parsing, PostgreSQL for the database, and JUnit for testing.

## Optimizations

The project was intended for group work, that means that the codebase was long from finished. Here are some optimizations that I would make if I had more time: implement cast of actors and directors which are bound to the danish movies. add Junit tests for the DAO layer and maybe some service methods. Multithreading to speed up the fetching of data from the external API.

## Lessons Learned:

Most of the project was easy to set up and implement, but the many-to-many relations in the database was tricky and the majority of the time was spent on joining genres and movies together. Cast and crew was not implemented properly, but would be a good exercise in many-to-many relations as well. Credit_DTO_Database_Population branch has a work in progress implementation of cast and crew.


## How to run it:
1. Clone the repo
2. Make sure you have Java and Maven installed
3. Set up a PostgresSQL database and update the config.properties file with your database credentials, the file is located in src/main/resources
4. If you are using IntelliJ or another IDE that can store your environment variables, set the following environment variable "API_KEY" with your API key from https://www.themoviedb.org/settings/api

