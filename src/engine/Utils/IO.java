package engine.Utils;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class IO {
	public static String loadFile(String path) throws IOException {
		File file = new File(path);
		StringBuilder fileContents = new StringBuilder((int)file.length());
		Scanner scanner = new Scanner(file);
		String lineSeparator = System.getProperty("line.separator");

		try {
			while(scanner.hasNextLine()) {
				fileContents.append(scanner.nextLine() + lineSeparator);
			}
			return fileContents.toString();
		} finally {
			scanner.close();
		}
	} 
}