package com.rameskum.dogfacts.controller;

import com.rameskum.dogfacts.service.FactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@RequiredArgsConstructor
@RequestMapping("/facts")
@Controller
public class FactsSVGController {

	private final FactService factService;
	private final TemplateEngine engine;

	@GetMapping(value = "dog", consumes = MediaType.ALL_VALUE, produces = {"image/svg+xml;charset=UTF-8"})
	public ResponseEntity<String> facts() {
		Context ctx = new Context();
		ctx.setVariable("fact", this.factService.getRandomFact());
		return ResponseEntity.ok(this.engine.process("facts", ctx));
	}
}
