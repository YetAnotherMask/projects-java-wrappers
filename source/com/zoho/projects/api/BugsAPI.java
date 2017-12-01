/* $Id$ */

package com.zoho.projects.api;

import java.util.HashMap;
import java.util.List;

import com.zoho.projects.model.Bug;
import com.zoho.projects.model.BugAttachment;
import com.zoho.projects.model.BugComment;
import com.zoho.projects.model.BugResolution;
import com.zoho.projects.model.Customfield;
import com.zoho.projects.model.Defaultfield;
import com.zoho.projects.parser.BugParser;
import com.zoho.projects.util.ZohoHTTPClient;


/**
 * BugsAPI is used to:
 *
 * 	Get list of bugs.
 *
 * 	Get the details of a bug.
 *
 * 	Creates a bug.
 *
 * 	Update the details of a bug.
 *
 * 	Delete an existing bug.
 * 
 *  List Comments for a bug.
 * 
 *  Add Comment to a bug.
 * 
 *  Delete Comment from a bug.
 * 
 *  List Attachments for a bug.
 * 
 *  List Resolutions for a bug.
 * 
 *  List Custom and Default fields for a bug.
 *
 * @author ramesh-2099
 */
public class BugsAPI extends API {

	//BugsParser is used to parse the JSON response into respective objects.
	private BugParser bugParser = new BugParser();

	/**
	 * Construct a BugsAPI using user's authToken and portalId.
	 * @param authToken user's authToken.
	 * @param portalId user's portalId.
	 */
	public BugsAPI(String authToken, String portalId) {
		super(authToken, portalId);
	}	

	/**
	 * Get list of bugs for the project. 
	 * @param projectId ID of the project.
	 * @param queryMap This queryMap contains the filters in the form of key-value pair.
	 * @return Returns list of Bug object.
	 * @throws Exception
	 */
	public List<Bug> getBugs(String projectId, HashMap<String, Object> queryMap) throws Exception {
		StringBuilder url = new StringBuilder(100);
		url.append(getBaseURL()).append("/projects/").append(projectId).append("/bugs/"); //No I18N

		String response = ZohoHTTPClient.get(url.toString(), getQueryMap(queryMap));

		return bugParser.getBugs(response);
	}

	/**
	 * Get the details of a bug. 
	 * @param projectId ID of the project.
	 * @param bugId ID of the bug.
	 * @return Returns the Bug object.
	 * @throws Exception
	 */
	public Bug get(String projectId, String bugId)throws Exception {
		StringBuilder url = new StringBuilder(100);
		url.append(getBaseURL()).append("/projects/").append(projectId).append("/bugs/"); //No I18N
		url.append(bugId).append("/");

		String response = ZohoHTTPClient.get(url.toString(), getQueryMap());

		return bugParser.getBug(response);
	}

	/**
	 * Create a Bug for the project. 
	 * @param projectId ID of the project.
	 * @param bug Bug object.
	 * @return Returns the Bug object.
	 * @throws Exception
	 */
	public Bug create(String projectId, Bug bug) throws Exception {
		StringBuilder url = new StringBuilder(100);
		url.append(getBaseURL()).append("/projects/").append(projectId).append("/bugs/"); //No I18N

		String response = ZohoHTTPClient.post(url.toString(), getQueryMap(bug.toParamMAP()));

		return bugParser.getBug(response);
	}

	/**
	 * Update the details of a bug. 
	 * @param projectId ID of the project.
	 * @param bug Bug object.
	 * @return Returns the Bug object.
	 * @throws Exception
	 */
	public Bug update(String projectId, Bug bug) throws Exception {
		StringBuilder url = new StringBuilder(100);
		url.append(getBaseURL()).append("/projects/").append(projectId).append("/bugs/"); //No I18N
		url.append(bug.getId()).append("/");

		String response = ZohoHTTPClient.post(url.toString(), getQueryMap(bug.toParamMAP()));

		return bugParser.getBug(response);
	}

	/**
	 * Delete an existing bug for the project. 
	 * @param projectId ID of the project.
	 * @param bugId ID of the bug.
	 * @return Returns the String object.
	 * @throws Exception
	 */
	public String delete(String projectId, String bugId)throws Exception {
		StringBuilder url = new StringBuilder(100);
		url.append(getBaseURL()).append("/projects/").append(projectId).append("/bugs/"); //No I18N
		url.append(bugId).append("/");

		String response = ZohoHTTPClient.delete(url.toString(), getQueryMap());

		return bugParser.getResult(response);
	}

	/**
	 * Get all the default fields in the given project. 
	 * @param projectId ID of the project.
	 * @return Returns the Defaultfield Object.
	 * @throws Exception
	 */
	public Defaultfield getDefaultFields(String projectId) throws Exception {
		StringBuilder url = new StringBuilder(100);
		url.append(getBaseURL()).append("/projects/").append(projectId).append("/bugs/defaultfields/"); //No I18N

		String response = ZohoHTTPClient.get(url.toString(), getQueryMap());

		return bugParser.getDefaultfields(response);
	}

	/**
	 * Get all the custom fields in the given project.
	 * @param projectId ID of the project.
	 * @return Returns List of CustomField Object.
	 * @throws Exception
	 */
	public List<Customfield> getCustomFields(String projectId) throws Exception {
		StringBuilder url = new StringBuilder(100);
		url.append(getBaseURL()).append("/projects/").append(projectId).append("/bugs/customfields/"); //No I18N

		String response = ZohoHTTPClient.get(url.toString(), getQueryMap());

		return bugParser.getCustomfields(response);
	}

	/**
	 * Get all the bug comments.
	 * @param projectId ID of the project.
	 * @param bugId ID of the bug.
	 * @param queryMap This queryMap contains the filters in the form of key-value pair.
	 * @return Returns List of Comment object.
	 * @throws Exception
	 */
	public List<BugComment> getComments(String projectId, String bugId, HashMap<String, Object> queryMap) throws Exception {
		StringBuilder url = new StringBuilder(100);
		url.append(getBaseURL()).append("/projects/").append(projectId).append("/bugs/"); //No I18N
		url.append(bugId).append("/comments/");

		String response = ZohoHTTPClient.get(url.toString(), getQueryMap(queryMap));

		return bugParser.getComments(response);
	}

	/**
	 * Add the bug comment.
	 * @param projectId ID of the project.
	 * @param bugId ID of the bug.
	 * @param content  Comment for the bug.
	 * @return Returns the Comment object.
	 * @throws Exception
	 */
	public BugComment addComment(String projectId, String bugId, String content) throws Exception {
		StringBuilder url = new StringBuilder(100);
		url.append(getBaseURL()).append("/projects/").append(projectId).append("/bugs/"); //No I18N
		url.append(bugId).append("/comments/");

		HashMap<String, Object> requestBody = new HashMap<>();
		requestBody.put("content", content);

		String response = ZohoHTTPClient.post(url.toString(), getQueryMap(requestBody));

		return bugParser.getComment(response);
	}

	/**
	 * Delete an existing bug comment.
	 * @param projectId ID of the project.
	 * @param bugId ID of the bug.
	 * @param commentId ID of the comment.
	 * @return Returns the String object.
	 * @throws Exception
	 */
	public String deleteComment(String projectId, String bugId, String commentId) throws Exception {
		StringBuilder url = new StringBuilder(100);
		url.append(getBaseURL()).append("/projects/").append(projectId).append("/bugs/"); //No I18N
		url.append(bugId).append("/comments/").append(commentId).append("/");

		String response = ZohoHTTPClient.delete(url.toString(), getQueryMap());

		return bugParser.getResult(response);
	}

	/**
	 * Get all the bug attachments.
	 * @param projectId ID of the project.
	 * @param bugId ID of the bug.
	 * @param queryMap This queryMap contains the filters in the form of key-value pair.
	 * @return Returns List of Attachment object.
	 * @throws Exception
	 */
	public List<BugAttachment> getAttachments(String projectId, String bugId, HashMap<String, Object> queryMap) throws Exception {
		StringBuilder url = new StringBuilder(100);
		url.append(getBaseURL()).append("/projects/").append(projectId).append("/bugs/"); //No I18N
		url.append(bugId).append("/attachments/");

		String response = ZohoHTTPClient.get(url.toString(), getQueryMap(queryMap));

		return bugParser.getAttachments(response);
	}

	/**
	 * Get all the bug resolutions.
	 * @param projectId ID of the project.
	 * @param bugId ID of the bug.
	 * @param queryMap This queryMap contains the filters in the form of key-value pair.
	 * @return Returns List of Resolution object.
	 * @throws Exception
	 */
	public List<BugResolution> getResolutions(String projectId, String bugId, HashMap<String, Object> queryMap) throws Exception {
		StringBuilder url = new StringBuilder(100);
		url.append(getBaseURL()).append("/projects/").append(projectId).append("/bugs/"); //No I18N
		url.append(bugId).append("/resolution/");

		String response = ZohoHTTPClient.get(url.toString(), getQueryMap(queryMap));

		return bugParser.getResolutions(response);
	}
}