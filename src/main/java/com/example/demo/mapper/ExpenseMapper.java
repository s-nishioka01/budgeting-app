package com.example.demo.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Expense;
import com.example.demo.form.ExpenseForm;

@Mapper
public interface ExpenseMapper {

	List<Expense> findAll();

	Optional<Expense> findOne(int id);

	int getTotalPrice();

	void save(ExpenseForm expenseForm);

	void update(ExpenseForm expenseForm);

	void delete(int id);

}
