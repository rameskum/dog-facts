package com.rameskum.dogfacts.controller.model;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class FactResponse {

	private List<String> facts;
	private int count;

	public FactResponse(List<String> facts, int count) {
		this.facts = facts;
		this.count = count;
	}
}
