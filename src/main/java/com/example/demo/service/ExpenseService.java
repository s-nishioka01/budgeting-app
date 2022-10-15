package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Expense;
import com.example.demo.mapper.ExpenseMapper;

public class ExpenseService {

	private final ExpenseMapper expenseMapper;

	@Autowired
	public ExpenseService(ExpenseMapper expenseMapper) {
		this.expenseMapper = expenseMapper;
	}

	public List<Expense> getExpenseList() {
		return expenseMapper.findAll();
	}

	public Expense findOne(int id) throws Exception {
		return expenseMapper.findOne(id).orElseThrow(() -> new Exception("データが登録されていません"));
	}

	public int getTotalPrice() {
		return expenseMapper.getTotalPrice();
	}

}
