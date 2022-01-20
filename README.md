# weather-service


Setup:

Start mysql container:

`docker pull mysql`

`docker run --name mysql-standalone -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=test -e MYSQL_USER=sa -e MYSQL_PASSWORD=password -d mysql:latest`

Start weather-service container:

`docker build . -t weather-service`

`docker run -p 8090:8090 --name weather-service --link mysql-standalone:mysql -d weather-service`

The API can be accessed through the Swagger UI located at localhost:8090/swagger-ui.html
