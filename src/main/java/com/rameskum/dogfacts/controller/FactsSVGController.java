package com.rameskum.dogfacts.controller;

import com.rameskum.dogfacts.controller.model.FactResponse;
import com.rameskum.dogfacts.service.FactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@RequestMapping("/facts")
@Controller
public class FactsSVGController {

	private final FactService factService;

	@GetMapping(value = "dog", produces = "image/svg+xml")
	public ModelAndView facts() {
		FactResponse randomFact = this.factService.getRandomFact();
		ModelAndView modelAndView = new ModelAndView("facts");
		modelAndView.addObject("fact", randomFact.getFacts().get(0));
		return modelAndView;
	}
}
