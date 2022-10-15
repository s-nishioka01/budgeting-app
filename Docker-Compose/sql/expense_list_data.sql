USE expense_list;
DROP TABLE IF EXISTS expenses;

CREATE TABLE expenses
(
	id INT unsigned AUTO_INCREMENT,
	itemName VARCHAR(100) NOT NULL,
	price INT(10) NOT NULL,
	dateOfPayment DATE NOT NULL,
	PRIMARY KEY (id)
);

INSERT INTO purchases (id, itemName, price, dateOfPayment) VALUE (1, "Book", 700, "2022-9-1");
INSERT INTO purchases (id, itemName, price, dateOfPayment) VALUE (2, "Apple", 300, "2022-9-4");
INSERT INTO purchases (id, itemName, price, dateOfPayment) VALUE (3, "PC", 120000, "2022-9-9");



