package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static Function func = new Function();

	public static void main(String[] args) {
		// Load file
		func.loadFile();

		// Menu
		chooseMainMenu();

		// Save file
		func.saveFile();
	}

	private static void chooseMainMenu() {
		Scanner sc = new Scanner(System.in);
		int chon;
		do {
			printMainMenu();
			System.out.println("\nLua chon: ");
			chon = sc.nextInt();
			switch (chon) {
			case 1:
				printDisplayBook();
				break;
			case 2:
				timKiem();
				break;
			case 3:
				func.addBook();
				break;
			case 4:
				func.deleteBook();
				break;
			case 5:
				func.fixBook();
				break;
			case 0:
				break;
			default:
				System.out.println("Nhap sai");
			}

		} while (chon != 0);
	}

	private static void printDisplayBook() {
		int chon;
		do {
			printOutputBook();
			System.out.println("Nhap lua chon: ");
			chon = sc.nextInt();

			switch (chon) {
			case 1:
				func.printBook_Code();
				break;
			case 2:
				func.printBook_Title();
				break;
			case 3:
				func.printBook_Author();
				break;
			case 4:
				func.printBook_Category();
				break;
			case 5:
				func.printBook_Year();
				break;
			case 0:
				break;
			default:
				System.out.println("Nhap sai");
			}
		} while (chon != 0);
	}

	private static void printOutputBook() {
		System.out.println("1. Hien thi theo ma sach");
		System.out.println("2. Hien thi theo ten sach");
		System.out.println("3. Hien thi theo tac gia");
		System.out.println("4. Hien thi theo the loai");
		System.out.println("5. Hien thi theo nam xuat ban moi -> cu");
		System.out.println("0. Thoat");

	}

	private static void timKiem() {
		int chon;
		do {
			printSearchBook();
			System.out.println("Nhap lua chon: ");
			chon = sc.nextInt();

			switch (chon) {
			case 1:
				func.searchTitle();
				break;
			case 2:
				func.searhAuthor();
				break;
			case 3:
				func.searchCode();
				break;
			case 0:
				break;
			default:
				System.out.println("Nhap sai");
			}
		} while (chon > 0);
	}

	private static void printSearchBook() {
		System.out.println("1. Tim kiem sach theo tua sach");
		System.out.println("2. Tim kiem theo ten tac gia");
		System.out.println("3. Tim kiem theo ma sach");
		System.out.println("0. Thoat");
	}

	public static void printMainMenu() {
		System.out.println("1. Hien thi danh sach");
		System.out.println("2. Tim kiem");
		System.out.println("3. Them sach");
		System.out.println("4. Xoa sach");
		System.out.println("5. Sua thong tin");
		System.out.println("0. Thoat");
	}
}
