package com.rameskum.dogfacts.service;

import com.rameskum.dogfacts.controller.model.FactResponse;
import com.rameskum.dogfacts.provoider.Facts;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

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

		return FactResponse.builder()
				.count(count)
				.facts(generated.stream().map(i -> facts.getDog().get(i)).collect(Collectors.toList()))
				.build();
	}
	public String getRandomFact() {
		int factId = RANDOM.nextInt(facts.getDog().size());
		return facts.getDog().get(factId);
	}
}
