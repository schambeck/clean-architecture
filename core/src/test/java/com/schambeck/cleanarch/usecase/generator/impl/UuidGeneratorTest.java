package com.schambeck.cleanarch.usecase.generator.impl;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UuidGeneratorTest {
    final UuidGenerator generator = new UuidGenerator();
    
    @Test
    void generate() {
        UUID generated = generator.generate();
        assertNotNull(generated);
    }
}
