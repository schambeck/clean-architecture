package com.schambeck.cleanarch.dataprovider;

import com.schambeck.cleanarch.entrypoint.rest.CleanArchPostgresqlContainer;
import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.testcontainers.containers.PostgreSQLContainer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
class JpaNotificationRepositoryIT {
    
    @Autowired
    private JpaNotificationRepository repository;
    
    @ClassRule
    public static PostgreSQLContainer<CleanArchPostgresqlContainer> postgreSQLContainer = CleanArchPostgresqlContainer.getInstance();

    @Test
    void countByReadIsFalse() {
        long count = repository.countByReadIsFalse();
        assertEquals(1, count);
    }
    
//    @Test
//    void updateRead() {
//    }
}
