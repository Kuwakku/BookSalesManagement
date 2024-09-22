package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.attribute.AclEntry;
import java.util.ArrayList;
import java.util.List;

public class DataIO {
	public static String root = "";

	public static ArrayList<Book> LoadFile(String fileName) {
		char[] s = { File.separatorChar };
		String sp = new String(s);
		File file = new File(root + sp + fileName);

		// Đọc File
		FileReader fread = null;
		BufferedReader buffR = null;
		ArrayList<Book> list = new ArrayList<Book>();

		try {
			fread = new FileReader(file);
			buffR = new BufferedReader(fread);

			String line;
			while ((line = buffR.readLine()) != null) {
				Book b = new Book(line);
				list.add(b);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (buffR != null) {
					buffR.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}

	// Ghi File
	public static void SaveFile(ArrayList<Book> list, String fileName) {
		BufferedWriter buffW = null;
		FileWriter fwrite = null;
		try {
			fwrite = new FileWriter(fileName);
			buffW = new BufferedWriter(fwrite);
			for (Book book : list) {
				String b = book.toString();
				buffW.write(b);
				buffW.newLine();
			}
			System.out.println("save data done");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (buffW != null) {
					buffW.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
