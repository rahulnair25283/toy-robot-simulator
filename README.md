# toy-robot-simulator
The application is a simulation of a toy robot moving on a square tabletop

## Pre-requisites
- Java 8
- Maven

## Steps to run
1. Clone repo
2. Open command line and navigate the repo directory
3. Run the command `mvn clean compile assembly:single`
4. Run the command `java -jar target/toy-robot-simulator-1.0.0.jar`
---
5. To run unit tests, run the command `mvn test`

## Approach
The idea is to make the code as composable as possible, thus enabling better testing of the individual pieces. I have cut some corners with exception handling though. I started with understanding all the actors in play. I then coded the skeletons for the individual actors and wrote tests for them. Then added code and refactored until the tests passed. Once I was confident, all the pieces would play well together, I piped them together using the Main class.

## Challenges
I tried TDD, it was challenging. :|

## Thoughts
Overall, I loved the challenge. It mostly allowed me to write the code I have always wanted to write. I may have been a bit time stretched at the end, which may show in the code i.e. corners cut with exception handling and some method return types, but felt good overall.
