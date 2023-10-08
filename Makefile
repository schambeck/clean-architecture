# Gradle

dist:
	./gradlew clean build

check:
	./gradlew clean test integrationTest

run:
	java -jar app/build/libs/app-1.0.0.jar

# Docker

compose-up:
	docker-compose up -d

compose-down:
	docker-compose down
