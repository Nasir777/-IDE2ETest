package com.identity.e2e;

import com.identity.e2e.exceptions.DirectoryScannerException;
import com.identity.e2e.utils.FileFilter;
import com.identity.e2e.utils.FileMetaInfo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ScanDirectoryTest {

	DirectoryScanner scanDirectory;
	private URI sourceFileURI;
	private URI invalidSourceFileURI;
	
	@Before
	public void setUp() throws URISyntaxException
	{
		scanDirectory = new DirectoryScanner();
		sourceFileURI = this.getClass().getClassLoader().getResource("registration/valid").toURI();
		invalidSourceFileURI = this.getClass().getClassLoader().getResource("registration/invalid").toURI();
	}
	
	@Test(expected=DirectoryScannerException.class)
	public void testInvalidDirectoryPath() throws DirectoryScannerException
	{
		List<FileMetaInfo> data = scanDirectory.scanDirectory(Paths.get(invalidSourceFileURI));
		Assert.assertNotNull(data);
	}
	
	@Test
	public void testScanDirectory() throws Exception
	{
		List<FileMetaInfo> data = scanDirectory.scanDirectory(Paths.get(sourceFileURI));
	
		Assert.assertNotNull(data);
		Assert.assertFalse(data.isEmpty());
	}

	@Test
	public void testExportFile() throws Exception
	{
		ExportRegistration registration = new ExportRegistration();
		registration.createRegistrationFile(Paths.get(sourceFileURI), "c:\\temp\\registration.csv", FileFilter.CSV);
	}
	
	
	public void generateTestFiles() throws IOException
	{
		String basePath = "C:\\code\\git\\rd\\identitye2e\\e2e\\src\\test\\resources\\registration";
		
		for (int i=1; i<=5; i++)
		{
			String fileName = "test_excel"+i+".xlsx";
			
			Path path = Paths.get(basePath + "\\"+ fileName);
			Files.createFile(path);
		}
		
	}
	

}
