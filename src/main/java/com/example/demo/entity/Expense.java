package com.example.demo.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class Expense {

	private int id;

	private String itemName;

	private int price;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate expenseDate;

	public Expense(int id, String itemName, int price, LocalDate expenseDate) {
		this.id = id;
		this.itemName = itemName;
		this.price = price;
		this.expenseDate = expenseDate;
	}

	public Expense() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public LocalDate getExpenseDate() {
		return expenseDate;
	}

	public void setExpenseDate(LocalDate expenseDate) {
		this.expenseDate = expenseDate;
	}

}
