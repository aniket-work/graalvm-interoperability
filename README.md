# graalvm-interoperability

* Docker build image
  docker build -t myapp:latest .
* 

curl -s http://localhost:8080/portfolios | jq .

in cmd
---
stop container
remove container
remove image
build new img
start container
lanuch git bash and run test command
-----------

cd C:/samadhi/workspace/java/graalvm-interoperability/
FOR /f "tokens=*" %i IN ('docker ps -q -f "name=graalvm-interoperability"') DO docker stop %i
FOR /f "tokens=*" %i IN ('docker ps -aq -f "name=graalvm-interoperability"') DO docker rm %i
docker rmi -f graalvm-interoperability-app:latest
docker rmi graalvm-interoperability:latest
docker build -t graalvm-interoperability:latest .
docker-compose up -d

"C:\Program Files\Git\bin\bash.exe" -c "curl -s http://localhost:8080/portfolios | jq . && /c/samadhi/workspace/java/graalvm-interoperability/query.sh" || pause


