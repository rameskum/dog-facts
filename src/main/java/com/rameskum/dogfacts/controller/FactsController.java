package com.rameskum.dogfacts.controller;

import com.rameskum.dogfacts.controller.model.FactResponse;
import com.rameskum.dogfacts.service.FactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/facts")
@RestController
public class FactsController {

	private final FactService factService;

	@GetMapping(value = "dog", produces = "application/json")
	public ResponseEntity<FactResponse> facts(@RequestParam(value = "count", defaultValue = "1") int count) {
		return ResponseEntity.ok(factService.getFacts(count));
	}
}
