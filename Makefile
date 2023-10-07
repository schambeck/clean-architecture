# Gradle

dist:
	./gradlew clean build

run:
	java -jar app/build/libs/app-1.0.0.jar

# Docker

compose-up:
	docker-compose up -d

compose-down:
	docker-compose down
