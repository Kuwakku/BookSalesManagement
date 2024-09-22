package main;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class Function {
	private static ArrayList<Book> listBook = new ArrayList<Book>();
	static Scanner sc = new Scanner(System.in);

	public void loadFile() {
		DataIO.root = "D:/";
		listBook = DataIO.LoadFile("book_data_en.txt");
	}

	public static void saveFile() {
		DataIO.root = "D:/";
		DataIO.SaveFile(listBook, "D:/new_data.txt");
	}

	public static void addBook() {
		System.out.println("-----Nhap thong tin sach can them------");
		System.out.println("Nhap title: ");
		String title = sc.nextLine();
		System.out.println("Nhap author: ");
		String author = sc.nextLine();
		System.out.println("Nhap category: ");
		String category = sc.nextLine();
		System.out.println("Nhap year: ");
		String year = sc.nextLine();
		Book sach = new Book(title, author, category, year);
		listBook.add(sach);
		System.out.println("Sach moi da duoc them vao thu vien");
	}

	public static void deleteBook() {
		int truoc = listBook.size();
		System.out.println("Nhap vi tri can xoa: ");
		String index = sc.nextLine();
		listBook.removeIf(book -> book.getCode().equals(index));
		int sau = listBook.size();
		if (truoc < sau) {
			System.out.println("Xoa thanh cong o vi tri " + index);
		} else {
			System.out.println("Xoa that bai !");
		}
	}

	public static void fixBook() {
		System.out.println("Nhap vi tri can sua");
		String index = sc.nextLine();
		boolean fixSach = false;
		for (Book book : listBook) {
			if (book.getCode().equals(index)) {
				System.out.println("New title: ");
				String title = sc.nextLine();
				System.out.println("New author: ");
				String author = sc.nextLine();
				System.out.println("New category: ");
				String category = sc.nextLine();
				System.out.println("New year: ");
				String year = sc.nextLine();
				book.setAuthor(author);
				book.setCategory(category);
				book.setTitle(title);
				book.setYear(year);
				fixSach = true;
				break;
			}
		}
		System.out.println("Sach da sua");
		if (!fixSach) {
			System.out.println("Khong tim thay sach can sua");
		}
	}

	public static void printBook_Code() {
		listBook.sort((o1, o2) -> {
			int t1 = Integer.parseInt(o1.getCode());
			int t2 = Integer.parseInt(o2.getCode());
			return Integer.compare(t1, t2);
		});
		System.out.println("Sap xep theo ma sach");
		printBook();
	}

	public static void printBook_Title() {
		listBook.sort((o1, o2) -> {
			String t1 = o1.getTitle();
			String t2 = o2.getTitle();
			return t1.compareTo(t2);
		});
		System.out.println("Sap xep theo ten sach");
		printBook();
	}

	public static void printBook_Author() {
		listBook.sort((o1, o2) -> {
			String t1 = o1.getAuthor();
			String t2 = o2.getAuthor();
			return t1.compareTo(t2);
		});
		System.out.println("Sap xep theo tac gia");
		printBook();
	}

	public static void printBook_Category() {
		listBook.sort((o1, o2) -> {
			String t1 = o1.getCategory();
			String t2 = o2.getCategory();
			return t1.compareTo(t2);
		});
		System.out.println("Sap xep theo the loai");
		printBook();
	}

	public static void printBook_Year() {
		listBook.sort((o1, o2) -> {
			int t1 = Integer.parseInt(o1.getYear());
			int t2 = Integer.parseInt(o2.getYear());
			return Integer.compare(t2, t1);
		});
		System.out.println("Sap xep theo nam");
		printBook();
	}

	public static void printBook() {
		for (Book book : listBook) {
			System.out.println("------------------Danh sach----------------");
			System.out.println(book);
		}
	}

	public static void searchTitle() {
		System.out.println("Nhap tua sach can tim kiem: ");
		String titleBook = sc.nextLine();
		boolean check = false;
		for (Book book : listBook) {
			if (book.getTitle().equals(titleBook)) {
				System.out.println("Sach co title " + titleBook + " : ");
				System.out.println("---> " + book);
				check = true;
			}
		}
		if (!check) {
			System.out.println("Khong co sach thoa man");
		}

	}

	public static void searhAuthor() {
		System.out.println("Nhap ten tac gia can tim kiem: ");
		String authorBook = sc.nextLine();
		boolean check = false;
		for (Book book : listBook) {
			if (book.getAuthor().equals(authorBook)) {
				System.out.println("Sach co author " + authorBook + " : ");
				System.out.println("---> " + book);
				check = true;
			}
		}
		if (!check) {
			System.out.println("Khong co sach thoa man");
		}
	}

	public static void searchCode() {
		System.out.println("Nhap ma sach can tim kiem: ");
		String codeBook = sc.nextLine();
		boolean check = false;
		for (Book book : listBook) {
			if (book.getCode().equals(codeBook)) {
				System.out.println("Sach co code " + codeBook + " : ");
				System.out.println("---> " + book);
				check = true;
			}
		}
		if (!check) {
			System.out.println("Khong co sach thoa man");
		}
	}
}
