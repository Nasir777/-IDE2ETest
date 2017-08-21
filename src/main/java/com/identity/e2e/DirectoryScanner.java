package com.identity.e2e;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.identity.e2e.exceptions.DirectoryScannerException;
import com.identity.e2e.utils.FileMetaInfo;
import com.identity.e2e.utils.FileUtils;

/**
 *	This file scans directory and outputs meta information 
 *
 */
public class DirectoryScanner 
{
	
	public List<FileMetaInfo> scanDirectory(String directoryPath) throws DirectoryScannerException
	{
		return scanDirectory(Paths.get(directoryPath));
	}
	
	/**
	 * 
	 * @param directoryPath
	 * @return
	 * @throws DirectoryScannerException
	 */
	public List<FileMetaInfo> scanDirectory(Path directoryPath) throws DirectoryScannerException
	{
		List<FileMetaInfo> fileMetaInfoList = new ArrayList<FileMetaInfo>();
		
		if (FileUtils.isValid(directoryPath))
		{
			try (DirectoryStream<Path> directory = Files.newDirectoryStream(directoryPath))
			{
				for (Path path : directory)
				{
					FileMetaInfo fileMeta = FileUtils.getFileMetaInfo(path); 
					
					if (fileMeta != null)
					{
						fileMetaInfoList.add(fileMeta);
					}
				}
			}
			catch (IOException e) 
			{
				throw new DirectoryScannerException(e.getMessage());
			}
		}
		
		return fileMetaInfoList;
	}
}
