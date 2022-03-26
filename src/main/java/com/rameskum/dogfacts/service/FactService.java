package com.rameskum.dogfacts.service;

import com.rameskum.dogfacts.controller.model.FactResponse;
import com.rameskum.dogfacts.provoider.Facts;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class FactService {

	private static final Random RANDOM = new Random();
	private final Facts facts;

	public FactResponse getFacts(int count) {
		final Set<Integer> generated = new LinkedHashSet<>();
		count = Math.min(count, facts.getDog().size());
		while (generated.size() < count) {
			int randomNumber = RANDOM.nextInt(facts.getDog().size());
			generated.add(randomNumber);
		}

		final FactResponse response = new FactResponse();
		response.setCount(count);

		for (int i : generated) {
			response.getFacts().add(facts.getDog().get(i));
		}

		return response;
	}
}
