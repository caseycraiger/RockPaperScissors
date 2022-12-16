package data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import data.model.WinTrackerRecord;

public class WinTracker {
	public static void updateWinRecord(String name) throws FileNotFoundException {
		// point to database file and create scanner to read it
		String filePath = "src/data/windatabase.txt";
		Scanner fileScanner = new Scanner(new File(filePath));
		ArrayList<WinTrackerRecord> trackerRecords = new ArrayList<WinTrackerRecord>();
		
		//read each line of the file, create a WinTrackerRecord object and add to list
		while (fileScanner.hasNextLine()){

		    String record = fileScanner.nextLine();
		    String[] recordParts = record.split(" ");
		    String recordName = recordParts[0];
		    int recordWinCount = Integer.parseInt(recordParts[1]);
		    trackerRecords.add(new WinTrackerRecord(recordName, recordWinCount));
		}
		fileScanner.close();
		
		// loop through trackerRecords, find record for input name, increment win count
		for (WinTrackerRecord record : trackerRecords) {
			if (record.getName().equals(name)) {
				int updatedCount = record.getWinCount() + 1;
				record.setWinCount(updatedCount);
			}
		}
		
		// write updated trackerRecords back to file
		try (PrintWriter out = new PrintWriter(
				new BufferedWriter(
						new FileWriter(
								new File(filePath))))) {
			
			for (WinTrackerRecord record : trackerRecords) {
				out.println(record.toString());
			}
			out.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
}

