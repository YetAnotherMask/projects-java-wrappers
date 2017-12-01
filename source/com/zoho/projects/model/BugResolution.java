/**
 *
 */
package com.zoho.projects.model;

import java.io.Serializable;
import java.util.Date;

/****************************************************************************
 * <b>Title</b>: BugResolution.java <b>Project</b>: zoho-projects-java-wrappers
 * <b>Description: </b> TODO <b>Copyright:</b> Copyright (c) 2016
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author raptor
 * @version 1.0
 * @since Nov 29, 2016
 ****************************************************************************/
public class BugResolution implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 6336945324655262978L;
	private Date resolvedTime;
	private Date resolvedTimeFormat;
	private long issueId;
	private long resolvedTimeLong;
	private String resolver;
	private long resolverId;
	private String resolution;


	/**
	 * @return the resolvedTime
	 */
	public Date getResolvedTime() {
		return resolvedTime;
	}


	/**
	 * @return the resolvedTimeFormat
	 */
	public Date getResolvedTimeFormat() {
		return resolvedTimeFormat;
	}


	/**
	 * @return the issueId
	 */
	public long getIssueId() {
		return issueId;
	}


	/**
	 * @return the resolvedTimeLong
	 */
	public long getResolvedTimeLong() {
		return resolvedTimeLong;
	}


	/**
	 * @return the resolver
	 */
	public String getResolver() {
		return resolver;
	}


	/**
	 * @return the resolvedId
	 */
	public long getResolverId() {
		return resolverId;
	}


	/**
	 * @return the resolution
	 */
	public String getResolution() {
		return resolution;
	}


	/**
	 * @param resolvedTime
	 *            the resolvedTime to set.
	 */
	public void setResolvedTime(Date resolvedTime) {
		this.resolvedTime = resolvedTime;
	}


	/**
	 * @param resolvedTimeFormat
	 *            the resolvedTimeFormat to set.
	 */
	public void setResolvedTimeFormat(Date resolvedTimeFormat) {
		this.resolvedTimeFormat = resolvedTimeFormat;
	}


	/**
	 * @param issueId
	 *            the issueId to set.
	 */
	public void setIssueId(long issueId) {
		this.issueId = issueId;
	}


	/**
	 * @param resolvedTimeLong
	 *            the resolvedTimeLong to set.
	 */
	public void setResolvedTimeLong(long resolvedTimeLong) {
		this.resolvedTimeLong = resolvedTimeLong;
	}


	/**
	 * @param resolver
	 *            the resolver to set.
	 */
	public void setResolver(String resolver) {
		this.resolver = resolver;
	}


	/**
	 * @param resolvedId
	 *            the resolvedId to set.
	 */
	public void setResolverId(long resolverId) {
		this.resolverId = resolverId;
	}


	/**
	 * @param resolution
	 *            the resolution to set.
	 */
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
}