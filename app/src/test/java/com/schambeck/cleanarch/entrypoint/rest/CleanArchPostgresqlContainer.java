package com.schambeck.cleanarch.entrypoint.rest;

import org.testcontainers.containers.PostgreSQLContainer;

public class CleanArchPostgresqlContainer extends PostgreSQLContainer<CleanArchPostgresqlContainer> {
    private static final String IMAGE_VERSION = "postgres:15.1";
    private static CleanArchPostgresqlContainer container;

    private CleanArchPostgresqlContainer() {
        super(IMAGE_VERSION);
    }

    public static CleanArchPostgresqlContainer getInstance() {
        if (container == null) {
            container = new CleanArchPostgresqlContainer();
        }
        return container;
    }

    @Override
    public void start() {
        super.start();
        System.setProperty("DB_URL", container.getJdbcUrl());
        System.setProperty("DB_USERNAME", container.getUsername());
        System.setProperty("DB_PASSWORD", container.getPassword());
    }

    @Override
    public void stop() {
        //do nothing, JVM handles shut down
    }

}
