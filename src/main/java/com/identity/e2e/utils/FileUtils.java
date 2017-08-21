package com.identity.e2e.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.identity.e2e.exceptions.DirectoryScannerException;

public class FileUtils 
{
	public static FileMetaInfo getFileMetaInfo(Path path) throws IOException
	{
		String mimeType = Files.probeContentType(path);
		return mimeType != null ? new FileMetaInfo(getFileBaseName(path), getFileExtension(path), mimeType, getFileSize(path),path.toFile().getPath()) : null;
	}
	
	public static String getFileBaseName(Path path)
	{
		return path.toFile().getName().substring(0,path.toFile().getName().lastIndexOf("."));
	}
	
	public static String getFileExtension(Path path)
	{
		return path.toFile().getName().substring(path.toFile().getName().lastIndexOf(".")+1).toUpperCase();
	}
	
	public static String getFileMimeType(Path path) throws IOException
	{
		return Files.probeContentType(path);
	}
	
	public static String getFileSize(Path path) throws IOException
	{
		return Long.toString(Files.size(path));
	}
	
	public static boolean isValid(String path) throws DirectoryScannerException
	{
		boolean valid = true;
		
		if (path == null)
		{
			throw new DirectoryScannerException("Please provide directory path to scan");
		}

		File directoryFile = new File(path);
		
		if (!directoryFile.isDirectory())
		{
			throw new DirectoryScannerException("Please provide a valid path to directory");
		}

		if (!directoryFile.canRead())
		{
			throw new DirectoryScannerException("Cannot Read directory");
		}
		
		if (directoryFile.listFiles().length < 10)
		{
			throw new DirectoryScannerException("directory should have minimum of 10 files to proceed for scanning");
		}
		
		return valid;
	}
	
	public static boolean isValid(Path path) throws DirectoryScannerException
	{
		boolean valid = true;
		
		if (path == null)
		{
			throw new DirectoryScannerException("Please provide directory path to scan");
		}
		
		if (!path.toFile().isDirectory())
		{
			throw new DirectoryScannerException("Please provide a valid path to directory");
		}

		if (!Files.isReadable(path))
		{
			throw new DirectoryScannerException("Cannot Read directory");
		}
	
		if (path.toFile().listFiles().length < 10)
		{
			throw new DirectoryScannerException("directory should have minimum of 10 files to proceed for scanning");
		}
		
		return valid;
	}
	
	public static boolean isValidFile(String file)
	{
		return file != null && Paths.get(file).toFile().isFile() && Paths.get(file).toFile().exists() && Paths.get(file).toFile().canWrite();
	}

}
