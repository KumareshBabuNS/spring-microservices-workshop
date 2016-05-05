# spring-microservices-workshop
Workshop-Labs für Microservices mit Spring-Boot und Spring-Cloud

Der komplette Code für den Workshop ist auf [on Github](http://github.com/andifalk/spring-microservices-workshop) zu finden.

## Systemvoraussetzungen  

* [JDK 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html), [Maven](https://maven.apache.org/index.html), und eine IDE (Eclipse, [Spring Toolsuite 3.7.0 oder neuer](https://spring.io/tools/sts/all), [IntelliJ 15 oder neuer](https://www.jetbrains.com/idea/download/)) müssen installiert sein.
* Um ein neues Übungsprojekt zu starten den [Spring Initializr](http://start.spring.io) im Browser aufrufen und dort die neueste Version von Spring Boot auswählen. Anschliessend je nach Übung die dort angegebenen Spring-Module auswählen. Zum Erzeugen des Projektes dann auf 'Generate' drücken.
* Alternativ kann dies bei Benutzung einer aktuellen Spring Toolsuite IDE oder in IntelliJ (ab Version 15) auch direkt durch den jeweils integrierten Spring-Initialzr Wizard erledigt werden.
* Bei Verwendung von Eclipse bzw. STS sollte noch der Annotation-Processing Maven-Connector installiert werden. Dies wird über den [Eclipse-Marketplace](http://marketplace.eclipse.org/content/m2e-apt) erledigt 

## 1. Spring Cloud Configuration Server
### Lernziele
Ziel dieses Labs ist es, die Konfiguration einer Anwendung mittels Spring Cloud Configuration in ein git-Repository auszulagern.

## 2. Spring Cloud Eureka Server
### Lernziele 
Ziel dieses Labs ist es einen Service-Discovery Server mit Eureka zu implementieren.

## 3. Spring Cloud NetFlix Hystrix Dashboard
### Lernziele
Bei diesem Lab geht es darum ein Dashboard mit Informationen zum Circuit-Breaker Hystrix zu erstellen.

## 4. Spring Microservice 'Person-Server'
### Lernziele
In diesem Lab wird ein serverseitiger Microservice zur Verwaltung und Abfrage von Personen per REST-Service erstellt. Dieser registriert sich beim Eureka-Server um ein Discovery durch den Client zu ermöglichen.

## 5. Spring Microservice 'Person-Client'
### Lernziele
In diesem Lab der zugehörige clientseitige Microservice zur Abfrage der Personen vom Server per REST-Call implementiert. Der Aufruf wird durch einen clientseitigen LoadBalancer und den Discovery-Service unterstützt.

## URL und Portkonfigurationen der Anwendungen

* Configuration Server = 8888
* Eureka Discovery Server = 8761
*