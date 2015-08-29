# SearchAggregator
This project aggregates the first page of search results from Google, Bing, and DuckDuckGo. 
It is built using spring boot. Maven is used for dependency and build management.  Java 8 is also used.  
It utilizes JSoup to parse the page.

The endpoint can be reached at `http://localhost:8080/?query=`
The query is a required parameter

## How to Run
The best way to run is to import this project into eclipse as a maven project.  

You will need to have Java 8 installed.

Once all the dependencies are download, navigate to `com.bran.application.Application` and run that as a java application.

Alternatively, navigate to the root directory of the project and can run the project via maven with the command : <br/>`mvn spring-boot:run`

