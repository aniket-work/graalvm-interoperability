# GraalVM Interoperability 🚀

Welcome to the tech fusion party where Java and Python are the unexpected but brilliant duo on the guest list. 🎉 In a world where digital harmony is the name of the game, we're about to witness how GraalVM plays the ultimate host, ensuring these two coding superheroes mingle and collaborate effortlessly. It's like watching your favorite odd couple, where Java’s robust infrastructure and Python's data prowess come together, not for an evening of cocktails, but to revolutionize software innovation. 💻🐍

This isn't your typical tech party; it's a dynamic convergence where Spring Boot takes the stage, Python becomes the financial whiz, and GraalVM orchestrates the show. and Docker provide the party venue. 🚀 Picture a scenario where the conversation isn't just lines of code but investment advice and optimizing supply chains.

In this article, we're diving into the heart of this tech party to reveal the magic of GraalVM as it facilitates a harmonious gathering, demonstrating how the unlikeliest tech companions can collaborate seamlessly. So, grab your party hat 🎩, and let's join this engaging celebration of technology's finest. 🥳

https://www.linkedin.com/posts/aniket-hingane-mlops_java-graalvm-jvm-activity-7129476412641574912-7DZT?utm_source=share&utm_medium=member_desktop


This repository is all about showcasing the marvelous interplay of GraalVM with Docker, Java, and more. Below, you'll find essential commands and instructions to master this project.

## Building the Docker Image 💼

To craft the Docker image for this project, employ the following command:

```bash
docker build -t myapp:latest .
```

Testing the Application 🧪
Once your Docker image is ready, it's time to put your application to the test. Use the following commands to examine its functionality:

```bash
curl -s http://localhost:8080/portfolios | jq .
```

Managing the Project (via cmd) 🛠️
For a hassle-free project management experience, these commands are your go-to tools when using a command prompt (cmd).

Stopping a Container ⏹️
To halt a running container associated with this project:

```bash
FOR /f "tokens=*" %i IN ('docker ps -q -f "name=graalvm-interoperoperability"') DO docker stop %i
```
Removing a Container 🗑️
Bid farewell to any stopped containers:

```bash
FOR /f "tokens=*" %i IN ('docker ps -aq -f "name=graalvm-interoperability"') DO docker rm %i
```
Eliminating Docker Images 🧹
If necessary, purge previous Docker images linked to this project:

```bash
docker rmi -f graalvm-interoperability-app:latest
docker rmi graalvm-interoperability:latest
```
Crafting a Fresh Docker Image 🏗️
For building a spanking new Docker image, use this command:

```bash
docker build -t graalvm-interoperability:latest .
```
Starting the Container 🚢
Hoist the sails and launch the Docker container for this project:

```bash
docker-compose up -d
```
Running Tests (with Git Bash) 🧪
To execute tests in Git Bash, fire up this command:

```bash
"C:\Program Files\Git\bin\bash.exe" -c "curl -s http://localhost:8080/portfolios | jq . && /c/samadhi/workspace/java/graalvm-interoperability/query.sh" || pause

```

