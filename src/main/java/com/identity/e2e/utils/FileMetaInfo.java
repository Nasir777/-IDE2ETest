package com.identity.e2e.utils;

public class FileMetaInfo 
{
	private String fileName;
	private String mimeTye;
	private String fileSize;
	private String extension;
	private String filePath;
	
	public FileMetaInfo() {
	}
	
	// Constructor to create object with fields
	public FileMetaInfo(String fileName, String extension, String mimeTye, String fileSize,String filePath) {
		super();
		this.fileName = fileName;
		this.mimeTye = mimeTye;
		this.fileSize = fileSize;
		this.extension = extension;
		this.filePath = filePath;
	}



	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * @return the mimeTye
	 */
	public String getMimeTye() {
		return mimeTye;
	}
	/**
	 * @param mimeTye the mimeTye to set
	 */
	public void setMimeTye(String mimeTye) {
		this.mimeTye = mimeTye;
	}
	/**
	 * @return the fileSize
	 */
	public String getFileSize() {
		return fileSize;
	}
	/**
	 * @param fileSize the fileSize to set
	 */
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	/**
	 * @return the extension
	 */
	public String getExtension() {
		return extension;
	}
	/**
	 * @param extension the extension to set
	 */
	public void setExtension(String extension) {
		this.extension = extension;
	}
	
	/**
	 * @return the filePath
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * @param filePath the filePath to set
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((extension == null) ? 0 : extension.hashCode());
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + ((filePath == null) ? 0 : filePath.hashCode());
		result = prime * result + ((fileSize == null) ? 0 : fileSize.hashCode());
		result = prime * result + ((mimeTye == null) ? 0 : mimeTye.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FileMetaInfo other = (FileMetaInfo) obj;
		if (extension == null) {
			if (other.extension != null)
				return false;
		} else if (!extension.equals(other.extension))
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (filePath == null) {
			if (other.filePath != null)
				return false;
		} else if (!filePath.equals(other.filePath))
			return false;
		if (fileSize == null) {
			if (other.fileSize != null)
				return false;
		} else if (!fileSize.equals(other.fileSize))
			return false;
		if (mimeTye == null) {
			if (other.mimeTye != null)
				return false;
		} else if (!mimeTye.equals(other.mimeTye))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FileMetaInfo [fileName=" + fileName + ", mimeTye=" + mimeTye + ", fileSize=" + fileSize + ", extension="
				+ extension + ", filePath=" + filePath + "]";
	}
	
	
}
