package com.rameskum.dogfacts.controller.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FactResponse {

	private List<String> facts = new ArrayList<>();
	private int count;
}
