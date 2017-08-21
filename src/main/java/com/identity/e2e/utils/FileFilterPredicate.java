package com.identity.e2e.utils;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.lang3.StringUtils;

public class FileFilterPredicate implements Predicate<FileMetaInfo>
{
	List<FileFilter> filterList;

	public FileFilterPredicate(FileFilter...fileFilters) 
	{
		filterList = Arrays.asList(fileFilters);
	}
	
	@Override
	public boolean evaluate(FileMetaInfo fileMeta) 
	{
		for (FileFilter filter : filterList)
		{
			if (StringUtils.equalsIgnoreCase(fileMeta.getExtension(), filter.toString()))
			{
				return true;
			}
		}
		
		return false;
	}


}
