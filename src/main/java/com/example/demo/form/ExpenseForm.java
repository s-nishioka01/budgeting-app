package com.example.demo.form;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

public class ExpenseForm {

	private int id;

	@Length(max = 30, message = "30文字以内で入力してください")
	@NotNull(message = "商品名が未入力です")
	private String itemName;

	@Range(min = 0, max = 100000000, message = "0~100000000の範囲で入力してください")
	@NotNull(message = "価格が未入力です")
	private int price;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate expenseDate;

	public ExpenseForm(int id, String itemName, int price, LocalDate expenseDate) {
		this.id = id;
		this.itemName = itemName;
		this.price = price;
		this.expenseDate = expenseDate;
	}

	public ExpenseForm() {

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
