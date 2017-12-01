/**
 *
 */
package com.zoho.projects.model;

import java.io.Serializable;
import java.util.Date;

/****************************************************************************
 * <b>Title</b>: BugAttachment.java <b>Project</b>: zoho-projects-java-wrappers
 * <b>Description: </b> TODO <b>Copyright:</b> Copyright (c) 2016
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author raptor
 * @version 1.0
 * @since Nov 29, 2016
 ****************************************************************************/
public class BugAttachment implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -8314814664513596064L;
	private Date attachedDate;
	private long fileSize;
	private Date attachedDateTime;
	private String authorName;
	private long authorId;
	private String fileUri;
	private long attachedDateLong;
	private String fileName;
	private String fileType;


	/**
	 * @return the attachedDate
	 */
	public Date getAttachedDate() {
		return attachedDate;
	}


	/**
	 * @return the fileSize
	 */
	public long getFileSize() {
		return fileSize;
	}


	/**
	 * @return the attachedDateTime
	 */
	public Date getAttachedDateTime() {
		return attachedDateTime;
	}


	/**
	 * @return the authorName
	 */
	public String getAuthorName() {
		return authorName;
	}


	/**
	 * @return the authorId
	 */
	public long getAuthorId() {
		return authorId;
	}


	/**
	 * @return the fileUri
	 */
	public String getFileUri() {
		return fileUri;
	}


	/**
	 * @return the attachedDateLong
	 */
	public long getAttachedDateLong() {
		return attachedDateLong;
	}


	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}


	/**
	 * @return the fileType
	 */
	public String getFileType() {
		return fileType;
	}


	/**
	 * @param attachedDate
	 *            the attachedDate to set.
	 */
	public void setAttachedDate(Date attachedDate) {
		this.attachedDate = attachedDate;
	}


	/**
	 * @param fileSize
	 *            the fileSize to set.
	 */
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}


	/**
	 * @param attachedDateTime
	 *            the attachedDateTime to set.
	 */
	public void setAttachedDateTime(Date attachedDateTime) {
		this.attachedDateTime = attachedDateTime;
	}


	/**
	 * @param authorName
	 *            the authorName to set.
	 */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}


	/**
	 * @param authorId
	 *            the authorId to set.
	 */
	public void setAuthorId(long authorId) {
		this.authorId = authorId;
	}


	/**
	 * @param fileUri
	 *            the fileUri to set.
	 */
	public void setFileUri(String fileUri) {
		this.fileUri = fileUri;
	}


	/**
	 * @param attachedDateLong
	 *            the attachedDateLong to set.
	 */
	public void setAttachedDateLong(long attachedDateLong) {
		this.attachedDateLong = attachedDateLong;
	}


	/**
	 * @param fileName
	 *            the fileName to set.
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	/**
	 * @param fileType
	 *            the fileType to set.
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
}