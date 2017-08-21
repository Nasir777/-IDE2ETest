package com.identity.e2e.reader;

import java.io.File;

import com.identity.e2e.exceptions.FileReaderException;

public abstract class BaseFileReader 
{
	public abstract void readFile(File f, String targetFile) throws FileReaderException;
}
