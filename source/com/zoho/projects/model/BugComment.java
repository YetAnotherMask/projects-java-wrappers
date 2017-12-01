/**
 *
 */
package com.zoho.projects.model;

import java.io.Serializable;
import java.util.Date;

/****************************************************************************
 * <b>Title</b>: BugComment.java <b>Project</b>: zoho-projects-java-wrappers
 * <b>Description: </b> This class is used to make an object for Bug Comment.
 * <b>Copyright:</b> Copyright (c) 2016 <b>Company:</b> Silicon Mountain
 * Technologies
 * 
 * @author raptor
 * @version 1.0
 * @since Nov 28, 2016
 ****************************************************************************/
public class BugComment implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -6073339067669345713L;
	private String id;
	private long createdTimeLong;
	private long addedBy;
	private String addedPerson;
	private Date createdTime;
	private String comment;


	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}


	/**
	 * @return the createdTimeLong
	 */
	public long getCreatedTimeLong() {
		return createdTimeLong;
	}


	/**
	 * @return the addedBy
	 */
	public long getAddedBy() {
		return addedBy;
	}


	/**
	 * @return the addedPerson
	 */
	public String getAddedPerson() {
		return addedPerson;
	}


	/**
	 * @return the createdTime
	 */
	public Date getCreatedTime() {
		return createdTime;
	}


	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}


	/**
	 * @param id
	 *            the id to set.
	 */
	public void setId(String id) {
		this.id = id;
	}


	/**
	 * @param createdTimeLong
	 *            the createdTimeLong to set.
	 */
	public void setCreatedTimeLong(long createdTimeLong) {
		this.createdTimeLong = createdTimeLong;
	}


	/**
	 * @param addedBy
	 *            the addedBy to set.
	 */
	public void setAddedBy(long addedBy) {
		this.addedBy = addedBy;
	}


	/**
	 * @param addedPerson
	 *            the addedPerson to set.
	 */
	public void setAddedPerson(String addedPerson) {
		this.addedPerson = addedPerson;
	}


	/**
	 * @param createdTime
	 *            the createdTime to set.
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}


	/**
	 * @param comment
	 *            the comment to set.
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

}
