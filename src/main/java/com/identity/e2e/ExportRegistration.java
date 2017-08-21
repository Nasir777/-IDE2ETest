package com.identity.e2e;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import com.identity.e2e.exceptions.DirectoryScannerException;
import com.identity.e2e.exceptions.FileReaderException;
import com.identity.e2e.reader.BaseFileReader;
import com.identity.e2e.reader.CSVFileReader;
import com.identity.e2e.reader.ExcelFileReader;
import com.identity.e2e.utils.FileFilter;
import com.identity.e2e.utils.FileFilterPredicate;
import com.identity.e2e.utils.FileMetaInfo;

/**
 *	This class is used for exporting registration file 
 *
 */
public class ExportRegistration 
{

	/**
	 * This method accepts source directory path and target path and filters
	 * 
	 * @param directoryPath
	 * @param registrationFilePath
	 * @param fileFilters
	 */
	public void createRegistrationFile(Path directoryPath, String registrationFilePath, FileFilter... fileFilters)
	{
		DirectoryScanner scanner = new DirectoryScanner();
		
		try 
		{
			List<FileMetaInfo> fileMetaList = scanner.scanDirectory(directoryPath);

			FileFilterPredicate predicate = new FileFilterPredicate(FileFilter.CSV); //, FileFilter.XLS, FileFilter.XLSX);
			
			CollectionUtils.filter(fileMetaList, predicate);
			
			for (FileMetaInfo info : fileMetaList)
			{
				BaseFileReader reader  = getReader(info.getExtension());
				reader.readFile(Paths.get(info.getFilePath()).toFile(), registrationFilePath);
			}
			
		} 
		catch (DirectoryScannerException e) 
		{
			e.printStackTrace();
		} catch (FileReaderException e) {
			e.printStackTrace();
		}		
	}
	
	public void createRegistrationFile(String directoryPath, String registrationFilePath, FileFilter... fileFilters)
	{
		createRegistrationFile(Paths.get(directoryPath), registrationFilePath, fileFilters);
	}

	private BaseFileReader getReader(String extension)
	{
		BaseFileReader reader = null;
		
		switch (extension) {
		case "CSV":
			reader = new CSVFileReader();
			break;
		case "XLS":
			reader = new ExcelFileReader();
			break;
		}
		
		return reader;
	}
}
