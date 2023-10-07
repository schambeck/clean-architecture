# Maven

dist:
	./mvnw clean package

run:
	java -jar target/clean-architecture-1.0.0.jar

# Docker

compose-up:
	docker-compose up -d

compose-down:
	docker-compose down
