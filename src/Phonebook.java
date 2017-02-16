
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class Phonebook {
	


		public static void main(String[] args) throws IOException {
			String inputFile = "phonebook.txt";
			String outputFile = "sortedPhonebook.txt";

			FileReader fileReader = new FileReader(inputFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String inputLine;
			List<String> lineList = new ArrayList<String>();
			while ((inputLine = bufferedReader.readLine()) != null) {
				if(inputLine.matches("[a-zA-Z ]*((\\+|00)359|0)(\\-|\\s)?8[7-9][2-9](\\-|\\s)?\\d{3}(\\s|\\-)?\\d{3}$"))
				{
				lineList.add(inputLine);
				System.out.println (inputLine.replaceAll("^([^\\s\\+]*\\s?)?((\\+|00)?359|0)[-\\s]?(8[7-9][2-9])[-\\s]?(\\d{3})[-\\s]?(\\d{3})$", "$1 - $2$4$5$6").replaceAll("00359","+359").replaceAll("- 0","+359"));
				}
				}
			fileReader.close();

			Collections.sort(lineList);

			FileWriter fileWriter = new FileWriter(outputFile);
			PrintWriter out = new PrintWriter(fileWriter);
			for (String outputLine : lineList) {
				out.println(outputLine);
			}
			out.flush();
			out.close();
			fileWriter.close();
		}
		

		
	}

