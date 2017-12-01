/**
 *
 */
package com.zoho.projects.test;

import java.util.List;

import org.apache.log4j.Logger;

import com.zoho.projects.api.BugsAPI;
import com.zoho.projects.model.BugAttachment;
import com.zoho.projects.model.BugComment;
import com.zoho.projects.model.BugResolution;
import com.zoho.projects.model.Defaultfield;
import com.zoho.projects.service.ZohoProjects;

/****************************************************************************
 * <b>Title</b>: BugTest.java
 * <b>Project</b>: zoho-projects-java-wrappers
 * <b>Description: </b> TODO
 * <b>Copyright:</b> Copyright (c) 2016
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author raptor
 * @version 1.0
 * @since Nov 28, 2016
 ****************************************************************************/
public class BugTest {

	public static void main(String args[]) throws Exception {

		Logger log = Logger.getLogger(BugTest.class);

		ZohoProjects zohoProjects = new ZohoProjects();
		zohoProjects.initialize("7b6b751ee78199771ac2c6f7d8110286", "633310723");

		String projectId = "967168000000017137";
		BugsAPI bugsAPI = zohoProjects.getBugsAPI();

		Defaultfield defaultField = bugsAPI.getDefaultFields(projectId);
		log.debug(defaultField.getPriorityDetails());
		String bugId = "967168000000120103";

		List<BugComment> comments = bugsAPI.getComments(projectId, bugId, null);
		log.debug(comments.size());

		List<BugAttachment> attachments = bugsAPI.getAttachments(projectId, bugId, null);
		log.debug(attachments.size());

		List<BugResolution> resolutions = bugsAPI.getResolutions(projectId, bugId, null);
		log.debug(resolutions.size());
	}
}
