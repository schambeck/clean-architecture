package com.schambeck.cleanarch.usecase.generator.impl;

import com.schambeck.cleanarch.usecase.generator.IdGenerator;

import javax.inject.Named;
import java.util.UUID;

@Named
public class UuidGenerator implements IdGenerator {

	@Override
	public UUID generate() {
		return UUID.randomUUID();
	}

}
