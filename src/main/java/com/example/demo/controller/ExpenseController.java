package com.example.demo.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.ExpenseForm;
import com.example.demo.service.ExpenseService;

@Controller
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

	@GetMapping("/new")
	public String newExpense(Model model) {
		LocalDateTime today = LocalDateTime.now();
		model.addAttribute("today", today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		return "new";
	}

	@GetMapping("/update/{id}")
	public String updateExpense(@PathVariable int id, Model model) {
		try {
			model.addAttribute("expense", expenseService.findOne(id));
			return "update";

		} catch (Exception e) {
			model.addAttribute("expenseList", expenseService.getExpenseList());
			model.addAttribute("totalPrice", expenseService.getTotalPrice());
			model.addAttribute("error", "データが登録されていません");
			return "index";
		}
	}

	@GetMapping("/delete/{id}")
	public String deleteExpense(@PathVariable int id, Model model) {
		try {
			model.addAttribute("expense", expenseService.findOne(id));
			return "delete";

		} catch (Exception e) {
			model.addAttribute("expenseList", expenseService.getExpenseList());
			model.addAttribute("totalPrice", expenseService.getTotalPrice());
			model.addAttribute("error", "データが登録されていません");
			return "index";
		}
	}

	@PostMapping("/new")
	public String create(@Validated @ModelAttribute ExpenseForm expenseForm, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			return "new";
		}
		expenseService.saveExpenseList(expenseForm);
		return "redirect:/index";
	}

	@PostMapping("/update/{id}")
	public String update(@PathVariable int id, @Validated @ModelAttribute ExpenseForm expenseForm, BindingResult result,
			Model model) throws Exception {
		if (result.hasErrors()) {
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("expense", expenseService.findOne(id));
			model.addAttribute("validationError", errorList);
			return "update";
		}
		expenseForm.setId(id);
		expenseService.updateExpenseList(expenseForm);
		return "redirect:/index";
	}

	@PostMapping("/delete/{id}")
	public String destroy(@PathVariable int id) {
		expenseService.deleteExpenseList(id);
		return "redirect:/index";
	}

}
