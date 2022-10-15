package com.example.demo.mapper;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Expense;

public interface ExpenseMapper {

	List<Expense> findAll();

	Optional<Expense> findOne(int id);

	int getTotalPrice();

}
