

import java.io.*;

public class ReadFile {
	private String path;

	public ReadFile(String location) {
		path = location;
	}

	public String[] openFile() throws IOException {
		try {
			FileReader fr = new FileReader(path);
			BufferedReader text = new BufferedReader(fr);
			
			int numberOfLines = readLines();
			String[] textData = new String[numberOfLines];

			for (int i = 0; i < numberOfLines; i++) {
				textData[i] = text.readLine();

			}
			text.close();
			return textData;
		} catch (FileNotFoundException e) {
			throw new IOException();
		}
		

	}

	private int readLines() throws IOException {
		FileReader fr = new FileReader(path);
		BufferedReader text = new BufferedReader(fr);

		int nblines = 0;
		while (( text.readLine()) != null) {
			nblines++;
		}
		text.close();
		return nblines;
	}

}
