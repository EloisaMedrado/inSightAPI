# inSightAPI
Java API that consumes and formats NASA's InSight API data.

### Prerequisites

```
Java
Maven
Docker

```

### Deploy

Clone this project. Access the project folder and run the command:

```
docker-compose up -d

```

Provide details in the application.properties file

```
spring.cache.type=redis
spring.redis.host=localhost
spring.redis.port=6379
spring.cache.redis.time-to-live=600000

```

Make sure that the parameters needed to access the NASA API url are correct.

```
api.key=4guzfV3ceojrQKMiY09CZi1omgTHSs4irI7dyzKP
api.version=1.0
api.feedtype=json

```

Check the security levels with which you want to deploy the application.

```
kodde.insight.allowedOrigin=http://localhost:3000
kodde.insight.allowedHeaders=*
kodde.insight.maxAge=3600

```

You can now run the application through your IDE or using the command line.

```
mvn spring-boot:run

```

### API

After each request in the NASA Api the data are formatted and save in cache to optimization. In the next 10 minutes every request made to this API return the cached data. Therefore, the NASA API is only consumed every 10 minutes. 
The cache time can be changed in the application.properties.
How to use the API. In these examples I will use Postman to test the API. In the 'Body' (return) tab, make sure that next to 'Preview' is selected JSON.

```
1) Select the 'GET' option
2) Enter the URL: http://localhost:8080/insight/weather
3) Click on the 'Send' button
4) In the 'Body' tab, make sure that next to 'Preview' is selected JSON.
5) In the 'Pretty' tab you should receive something like:
	{
	   "availableSols":[
	      {
	         "sol":634,
	         "average":-61.082
	      },
	      {
	         "sol":635,
	         "average":-62.311
	      },
	      {
	         "sol":636,
	         "average":-61.522
	      },
	      {
	         "sol":638,
	         "average":-61.625
	      },
	      {
	         "sol":639,
	         "average":-59.05
	      }
	   ],
	   "lastUpdate":"2020-09-14T05:30:35.291+00:00"
	}

Sols objects are returned inside the "availableSols" key. In each object you have:
	1) "sol" : sol key;
	4) "average": average temperature.

Inside the "lastUpdate" key, the date and time of the last request made in the NASA API are returned.

```

```
1) Select the 'GET' option
2) Enter the URL: http://localhost:8080/insight/weather/{solKey}
3) Click on the 'Send' button
4) In the 'Body' tab, make sure that next to 'Preview' is selected JSON.
5) In the 'Pretty' tab you should receive something like:
	{
	   "sol":635,
	   "average":-62.311,
	   "low":-95.169,
	   "high":-16.453
	}

Sol objects are returned with the keys:
	1) "sol" : sol key;
	2) "low": minimum temperature;
	3) "high": maximum temperature;
	4) "average": average temperature.

```

### Unit Tests

To execute the tests you run the following command

```
mvn clean test

```

### TODO

* Docker
* Swagger

### Build with

* [Java](https://www.java.com/pt_BR/)
* [Maven](https://maven.apache.org/)
* [Docker](https://www.docker.com/)

### Author

* **Eloisa Medrado** -  [EloisaMedrado](https://github.com/EloisaMedrado)	