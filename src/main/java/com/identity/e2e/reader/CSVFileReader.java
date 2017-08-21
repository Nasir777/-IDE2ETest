package com.identity.e2e.reader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import com.identity.e2e.exceptions.FileReaderException;
import com.opencsv.CSVReader;

public class CSVFileReader extends BaseFileReader {

	@Override
	public void readFile(File f, String targetFile) throws FileReaderException 
	{
        try 
        {
        	StringBuilder builder = new StringBuilder();
        	
			CSVReader reader = new CSVReader(new FileReader(f), ',', '\"');
			
			String[] line;
            while((line = reader.readNext()) != null)
            {
            	// registration number, make, colour
            	builder.append(String.format("%s,%s,%s\n", line[0], line[1], line[2]));
            }
            
            reader.close();

            Files.write(Paths.get(targetFile), builder.toString().getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
		} 
        catch (IOException e) 
        {
        	throw new FileReaderException(e.getMessage());
		}
	}

}
