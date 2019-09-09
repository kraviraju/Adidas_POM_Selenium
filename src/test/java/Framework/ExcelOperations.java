package Framework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVPrinter;

public class ExcelOperations {
	
	
	public static String ReadCSV(String CSV_FILE) throws IOException {
		 BufferedReader reader = Files.newBufferedReader(Paths.get(CSV_FILE));
		 CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader("Product Identifier").withIgnoreHeaderCase().withTrim());
		 String ProductIdentifier="";
		 for (CSVRecord csvRecord: csvParser) {
			 ProductIdentifier = csvRecord.get("Product Identifier");
			 
		 }
		 System.out.println("ProductIdentifier Reading from CSV File : " + ProductIdentifier);
		 return ProductIdentifier;
	}
	
	
	
	public static void WriteCSV(String CSV_FILE, String ProductIdentifier) throws IOException {
		 try {	
				// create the CSVPrinter class object 
					Writer writer = Files.newBufferedWriter(Paths.get(CSV_FILE));
					CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("Product Identifier"));
					csvPrinter.printRecord(ProductIdentifier);
					csvPrinter.flush();
		        
		 } catch (IOException e) {
	            e.printStackTrace();
	        }
		 
	}
	
	

}
