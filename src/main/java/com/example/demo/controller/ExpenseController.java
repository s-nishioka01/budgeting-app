package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.ExpenseService;

public class ExpenseController {

	private final ExpenseService expenseService;

	@Autowired
	public ExpenseController(ExpenseService expenseService) {
		this.expenseService = expenseService;
	}

	@GetMapping("/top")
	public String top(Model model) {
		model.addAttribute("expenseList", expenseService.getExpenseList());
		model.addAttribute("totalPrice", expenseService.getTotalPrice());
		model.addAttribute("error", "");
		return "top";
	}

}
