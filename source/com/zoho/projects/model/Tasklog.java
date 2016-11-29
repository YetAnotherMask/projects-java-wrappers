/* $Id$ */

package com.zoho.projects.model;

import java.io.Serializable;

/**
 * This class is used to make an object for task log.
 * 
 * @author ramesh-2099
 */

public class Tasklog extends Log implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 4669176304537804429L;
	private long taskId;
	private String taskName;


	/**
	 * Set the task id.
	 * 
	 * @param taskId
	 *            ID of the task.
	 */

	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}


	/**
	 * Get the task id.
	 * 
	 * @return ID of the task.
	 */

	public long getTaskId() {
		return taskId;
	}


	/**
	 * Set the task name.
	 * 
	 * @param taskName
	 *            Name of the task.
	 */

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}


	/**
	 * Get the task name.
	 * 
	 * @return Returns the task name.
	 */

	public String getTaskName() {
		return taskName;
	}

}
