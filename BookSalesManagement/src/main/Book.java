package main;

import java.io.Serializable;

public class Book implements Serializable {
	static int currCode = 0;

	String code, title, author, category, year;

	public Book(String input) {
		String[] parts = input.split(";");
		this.code = parts[0];
		this.title = parts[1];
		this.author = parts[2];
		this.category = parts[3];
		this.year = parts[4];
		updateCode(code);
	}

	public Book(int code1, String title, String author, String category, String year) {
		super();
		this.title = title;
		this.author = author;
		this.category = category;
		this.year = year;
	}

	public Book(String title, String author, String category, String year) {
		super();
		this.title = title;
		this.author = author;
		this.category = category;
		this.year = year;
		this.code = (currCode + 1) + ""; // biến về String
		currCode++;
	}

	public static int updateCode(String code) {
		int _code = Integer.parseInt(code);
		if (_code > currCode)
			currCode = _code;
		return currCode;
	}

	@Override
	public String toString() {
		return "Book [code= " + code + "][title= " + title + "][author= " + author + "][category= " + category
				+ "][year= " + year + "]";
	}

	public String getLine() {
		return code + ";" + title + ";" + author + ";" + category + ";" + year;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}
