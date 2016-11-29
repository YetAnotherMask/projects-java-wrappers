/* $Id$ */

package com.zoho.projects.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.siliconmtn.util.Convert;
import com.zoho.projects.model.Bug;
import com.zoho.projects.model.BugAttachment;
import com.zoho.projects.model.BugComment;
import com.zoho.projects.model.BugResolution;
import com.zoho.projects.model.Customfield;
import com.zoho.projects.model.Defaultfield;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;


/**
 * Parse the JSON response into respective objects.
 * 
 * @author ramesh-2099
 *
 */

public class BugParser 
{
	
	
	/**
	 * Parse the JSON response and make it into List of Bug object.
	 * 
	 * @param response This JSON response contains the details of bugs.
	 * 
	 * @return Returns List of Bug object.
	 * 
	 * @throws JSONException
	 */
	
	public List<Bug> getBugs(String response)throws JSONException
	{
		
		JSONObject jsonObject = JSONObject.fromObject(response.trim());
		
		JSONArray bugs = jsonObject.getJSONArray("bugs"); 	//No I18N
		
		List<Bug> bugList = new ArrayList<Bug>(bugs.size());
		
		for(int i = 0; i < bugs.size(); i++)
		{
			JSONObject bug = bugs.getJSONObject(i);
			
			bugList.add(this.jsonToBug(bug));
		}
		
		return bugList;
		
	}
	
	/**
	 * Parse the JSON response and make it into Bug object.
	 * 
	 * @param response This JSON response contains the details of a bug.
	 * 
	 * @return Returns the Bug object.
	 * 
	 * @throws JSONException
	 */
	
	public Bug getBug(String response)throws JSONException
	{
		
		JSONObject jsonObject = JSONObject.fromObject(response.trim());
		
		JSONArray bugs = jsonObject.getJSONArray("bugs");	//No I18N
		
		JSONObject bug = bugs.getJSONObject(0);
			
		return this.jsonToBug(bug);
		
	}
	
	
	/**
	 * Parse the JSONObject into Bug object.
	 * 
	 * @param jsonObject JSONObject contains the details of a bug.
	 * 
	 * @return Returns the Bug object.
	 * 
	 * @throws JSONException
	 */
	
	public Bug jsonToBug(JSONObject jsonObject)throws JSONException
	{
		
		Bug bug = new Bug();
		
		if(jsonObject.has("id"))
		{
			bug.setId(jsonObject.getLong("id"));	//No I18N
		}
		if(jsonObject.has("key"))
		{
			bug.setKey(jsonObject.getString("key"));
		}
		
		if(jsonObject.has("project"))
		{
			bug.setProjectId(jsonObject.getJSONObject("project").getLong("id"));	//No I18N
		}
		
		if(jsonObject.has("flag"))
		{
			bug.setFlag(jsonObject.getString("flag"));
		}
		if(jsonObject.has("title"))
		{
			bug.setTitle(jsonObject.getString("title"));
		}
		if(jsonObject.has("description"))
		{
			bug.setDescription(jsonObject.getString("description"));
		}
		if(jsonObject.has("reporter_id"))
		{
			bug.setReporterId(jsonObject.getString("reporter_id"));
		}
		if(jsonObject.has("reported_person"))
		{
			bug.setReportedPerson(jsonObject.getString("reported_person"));
		}
		if(jsonObject.has("created_time"))
		{
			bug.setCreatedTime(jsonObject.getString("created_time"));
		}
		if(jsonObject.has("created_time_format"))
		{
			bug.setCreatedTimeFormat(jsonObject.getString("created_time_format"));
		}
		if(jsonObject.has("created_time_long"))
		{
			bug.setCreatedTimeLong(jsonObject.getLong("created_time_long"));	//No I18N
		}
		if(jsonObject.has("assignee_id"))
		{
			bug.setAssigneeId(jsonObject.getString("assignee_id"));
		}
		if(jsonObject.has("assignee_name"))
		{
			bug.setAssigneeName(jsonObject.getString("assignee_name"));
		}
		if(jsonObject.has("closed"))
		{	
			bug.setClosed(jsonObject.getBoolean("closed"));	//No I18N
		}
		if(jsonObject.has("due_date"))
		{
			bug.setDueDate(jsonObject.getString("due_date"));
		}
		if(jsonObject.has("due_date_format"))
		{
			bug.setDueDateFormat(jsonObject.getString("due_date_format"));
		}
		if(jsonObject.has("due_date_long"))
		{
			bug.setDueDateLong(jsonObject.getLong("due_date_long"));	//No I18N
		}
		
		
		if(jsonObject.has("classification"))
		{
			JSONObject classification = jsonObject.getJSONObject("classification");	//No I18N
			
			if(classification.has("id"))
			{
				bug.setClassificationId(classification.getLong("id"));	//No I18N
			}
			if(classification.has("type"))
			{
				bug.setClassificationType(classification.getString("type"));
			}
		}
		
		if(jsonObject.has("severity"))
		{
			JSONObject severity = jsonObject.getJSONObject("severity");	//No I18N
			
			if(severity.has("id"))
			{
				bug.setSeverityId(severity.getLong("id"));	//No I18N
			}
			if(severity.has("type"))
			{
				bug.setSeverityType(severity.getString("type"));
			}
			
		}
		
		if(jsonObject.has("status"))
		{
			JSONObject status = jsonObject.getJSONObject("status");	//No I18N
			
			if(status.has("id"))
			{
				bug.setStatusId(status.getLong("id"));	//No I18N
			}
			if(status.has("type"))
			{
				bug.setStatusType(status.getString("type"));
			}
			
		}
		
		if(jsonObject.has("reproducible"))
		{
			JSONObject reproducible = jsonObject.getJSONObject("reproducible");	//No I18N
			
			if(reproducible.has("id"))
			{
				bug.setReproducibleId(reproducible.getLong("id"));	//No I18N
			}
			if(reproducible.has("type"))
			{
				bug.setReproducibleType(reproducible.getString("type"));
			}
		}
		
		if(jsonObject.has("module"))
		{
			JSONObject module = jsonObject.getJSONObject("module");	//No I18N
			
			if(module.has("id"))
			{
				bug.setModuleId(module.getLong("id"));	//No I18N
			}
			if(module.has("name"))
			{
				bug.setModuleName(module.getString("name"));
			}
			
		}
		
		if(jsonObject.has("link"))
		{
			JSONObject link = jsonObject.getJSONObject("link");	//No I18N
			
			if(link.has("self"))
			{
				bug.setURL(link.getJSONObject("self").getString("url"));
			}
			
			if(link.has("timesheet"))
			{
				bug.setTimesheetURL(link.getJSONObject("timesheet").getString("url"));
			}
		}
		
		return bug;
		
		
	}
	
	/**
	 * Parse the JSON response and get the success message.
	 * 
	 * @param response This JSON response contains the success message.
	 * 
	 * @return Returns the String object.
	 * 
	 * @throws JSONException
	 */
	
	public String getResult(String response)throws JSONException
	{
		JSONObject jsonObject = JSONObject.fromObject(response.trim());
		
		String result = jsonObject.getString("response");
		
		return result;
	}
	
	/**
	 * Parse the JSON response and make into List of Customfield Object.
	 * 
	 * @param response This JSON response contains the details of Custom fields.
	 * 
	 * @return Returns the List of Customfield Object.
	 * 
	 * @throws JSONException
	 */
	
	public List<Customfield> getCustomfields(String response)throws JSONException
	{
		JSONObject jsonObject = JSONObject.fromObject(response.trim());
		
		List<Customfield> customfieldList = new ArrayList<Customfield>();
		
		JSONArray customfields = jsonObject.getJSONArray("customfields");	//No I18N
		
		for(int i = 0; i < customfields.size(); i++)
		{
			customfieldList.add(this.jsonToCustomfield(customfields.getJSONObject(i)));
		}
		
		return customfieldList;
	}
	
	/**
	 * Parse the JSONObject into Customfield Object.
	 * 
	 * @param jsonObject JSONObject contains the details of a custom field.
	 * 
	 * @return Returns the Customfield Object.
	 * 
	 * @throws JSONException
	 */
	
	public Customfield jsonToCustomfield(JSONObject jsonObject)throws JSONException
	{
		
		Customfield customfield = new Customfield();
		
		if(jsonObject.has("label_name"))
		{
			customfield.setLabelName(jsonObject.getString("label_name"));
		}
		if(jsonObject.has("column_name"))
		{
			customfield.setColumnName(jsonObject.getString("column_name"));
		}
		if(jsonObject.has("default_Value"))
		{
			customfield.setDefaultValue(jsonObject.getString("default_Value"));
		}
		if(jsonObject.has("picklist_values"))
		{
			JSONArray picklist = jsonObject.getJSONArray("picklist_values");	//No I18N
			
			String[] picklistValues = new String[picklist.size()];
			
			for (int i = 0; i < picklist.size(); i++)
			{
				picklistValues[i] = picklist.getString(i);
			}
			
			customfield.setPicklistValues(picklistValues);
		}
		
		return customfield;
		
	}
	
	/**
	 * Parse the JSON response and make it into Defaultfield Object.
	 * 
	 * @param response This JSON response cotains the details of default fields.
	 * 
	 * @return Returns the Defaultfield Object.
	 * 
	 * @throws JSONException
	 */
	
	public Defaultfield getDefaultfields(String response)throws JSONException
	{
		
		Defaultfield defaultfield = new Defaultfield();
		
		JSONObject jsonObject = JSONObject.fromObject(response.trim());
		
		JSONObject defaultFields = jsonObject.getJSONObject("defaultfields"); 	//No I18N
		
		if(defaultFields.has("severity_details"))
		{
			JSONArray severityDetails = defaultFields.getJSONArray("severity_details");	//No I18N
			
			List<HashMap<String, Object>> severitydetails = new ArrayList<HashMap<String,Object>>();
			
			for(int i = 0; i < severityDetails.size(); i++)
			{
				JSONObject severitydetail = severityDetails.getJSONObject(i);
				
				severitydetails.add(this.jsonToHashMap(severitydetail));
			}
			
			defaultfield.setSeverityDetails(severitydetails);
		}
		
		if(defaultFields.has("status_details"))
		{
			JSONArray statusDeatils = defaultFields.getJSONArray("status_details");	//No I18N
			
			List<HashMap<String, Object>> statusdeatils = new ArrayList<HashMap<String,Object>>();
			
			for(int i = 0; i < statusDeatils.size(); i++)
			{
				JSONObject statusdeatil = statusDeatils.getJSONObject(i);
				
				statusdeatils.add(this.jsonToHashMap(statusdeatil));
			}
			
			defaultfield.setStatusDeatils(statusdeatils);
		}
		
		if(defaultFields.has("module_details"))
		{
			JSONArray moduleDetails = defaultFields.getJSONArray("module_details");	//No I18N
			
			List<HashMap<String, Object>> moduledetails = new ArrayList<HashMap<String,Object>>();
			
			for(int i = 0; i < moduleDetails.size(); i++)
			{
				JSONObject moduledetail = moduleDetails.getJSONObject(i);
				
				moduledetails.add(this.jsonToHashMap(moduledetail));
			}
			
			defaultfield.setModuleDetails(moduledetails);
		}
		
		if(defaultFields.has("priority_details"))
		{
			JSONArray priorityDetails = defaultFields.getJSONArray("priority_details");	//No I18N
			
			List<HashMap<String, Object>> prioritydetails = new ArrayList<HashMap<String,Object>>();
			
			for (int i = 0; i < priorityDetails.size(); i++)
			{
				JSONObject prioritydetail = priorityDetails.getJSONObject(i);
				
				prioritydetails.add(this.jsonToHashMap(prioritydetail));
				
			}
			
			defaultfield.setPriorityDetails(prioritydetails);
		}
		
		if(defaultFields.has("classification_details"))
		{
			JSONArray classificationDetails = defaultFields.getJSONArray("classification_details");	//No I18N
			
			List<HashMap<String, Object>> classificationdetails = new ArrayList<HashMap<String,Object>>();
			
			for (int i = 0; i < classificationDetails.size(); i++)
			{
				JSONObject classificationdetail = classificationDetails.getJSONObject(i);
				
				classificationdetails.add(this.jsonToHashMap(classificationdetail));
			}
			
			defaultfield.setClassificationDetails(classificationdetails);
		}
		
		
		return defaultfield;
	}
	
	/**
	 * Parse the JSONObject into HashMap Object.
	 * 
	 * @param jsonObject JSONObject contains the details of default fields.
	 * 
	 * @return Returns the HashMap Object.
	 * 
	 * @throws JSONException
	 */
	
	public HashMap<String, Object> jsonToHashMap(JSONObject jsonObject)throws JSONException
	{
		
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		
		Iterator<?> keyIterator = jsonObject.keys();
		
		while (keyIterator.hasNext()) 
		{
			String key = (String) keyIterator.next();
			
			hashMap.put(key, jsonObject.get(key));
		}
		
		return hashMap;
		
	}
	
	/**
	 * Parse the JSON response and make it into List of Comment object.
	 * 
	 * @param response JSON response contains the details of list of comments.
	 * 
	 * @return Returns List of Comment object.
	 * 
	 * @throws JSONException
	 */
	
	public List<BugComment> getComments(String response)throws JSONException
	{
		
		JSONObject jsonObject = JSONObject.fromObject(response.trim());
		
		List<BugComment> commentList = new ArrayList<>();
		
		if(jsonObject.has("comments"))
		{
			JSONArray comments = jsonObject.getJSONArray("comments");	//No I18N
			
			for(int j = 0; j < comments.size(); j++)
			{
				JSONObject comment = comments.getJSONObject(j);
				
				commentList.add(this.jsonToComment(comment));
			}
			
		}
		
		return commentList;
		
	}
	
	/**
	 * Parse the JSON response and make it into the Comment object.
	 * 
	 * @param response JSON response contains the details of comment.
	 * 
	 * @return Returns the Comment object.
	 * 
	 * @throws JSONException
	 */
	
	public BugComment getComment(String response)throws JSONException
	{
		
		JSONObject jsonObject = JSONObject.fromObject(response.trim());
		
		JSONArray comments = jsonObject.getJSONArray("comments");	//No I18N
		
		JSONObject comment = comments.getJSONObject(0);
		
		return this.jsonToComment(comment);
		
	}
	
	
	/**
	 * Parse the JSONObject into Comment object.
	 * 
	 * @param jsonObject JSONObject contains the details of a comment.
	 * 
	 * @return Returns the Comment object.
	 * 
	 * @throws JSONException
	 */
	
	public BugComment jsonToComment(JSONObject jsonObject)throws JSONException
	{
		
		BugComment comment = new BugComment();
		
		if(jsonObject.has("comment_id"))
		{
			comment.setId(jsonObject.getString("comment_id"));	//No I18N
		}
		if(jsonObject.has("created_time_long"))
		{
			comment.setCreatedTimeLong(jsonObject.getLong("created_time_long"));
		}
		if(jsonObject.has("created_time"))
		{
			comment.setCreatedTime(Convert.formatDate(Convert.DATE_TIME_DASH_PATTERN_12HR, jsonObject.getString("created_time")));
		}
		if(jsonObject.has("added_by"))
		{
			comment.setAddedBy(jsonObject.getLong("added_by"));
		}
		if(jsonObject.has("comment"))
		{
			comment.setComment(jsonObject.getString("comment"));	//No I18N
		}
		if(jsonObject.has("added_person"))
		{
			comment.setAddedPerson(jsonObject.getString("added_person"));
		}
		
		return comment;
		
	}

	/**
	 * Parse the JSON response and make it into List of Attachment object.
	 * 
	 * @param response JSON response contains the details of list of attachments.
	 * 
	 * @return Returns List of Attachment object.
	 * 
	 * @throws JSONException
	 */
	
	public List<BugAttachment> getAttachments(String response)throws JSONException
	{
		
		JSONObject jsonObject = JSONObject.fromObject(response.trim());
		
		List<BugAttachment> attachmentList = new ArrayList<>();
		
		if(jsonObject.has("attachment_details"))
		{
			JSONArray attachments = jsonObject.getJSONArray("attachment_details");	//No I18N
			
			for(int j = 0; j < attachments.size(); j++)
			{
				JSONObject attachment = attachments.getJSONObject(j);
				
				attachmentList.add(this.jsonToAttachment(attachment));
			}
			
		}
		
		return attachmentList;
		
	}

	/**
	 * Parse the JSONObject into Comment object.
	 * 
	 * @param jsonObject JSONObject contains the details of a comment.
	 * 
	 * @return Returns the Comment object.
	 * 
	 * @throws JSONException
	 */
	
	public BugAttachment jsonToAttachment(JSONObject jsonObject)throws JSONException
	{
		
		BugAttachment attachment = new BugAttachment();
		
		if(jsonObject.has("attached_time"))
		{
			attachment.setAttachedDate(Convert.formatDate(Convert.DATE_DASH_PATTERN, jsonObject.getString("attached_time")));	//No I18N
		}
		if(jsonObject.has("file_size"))
		{
			attachment.setFileSize(jsonObject.getLong("file_size"));
		}
		if(jsonObject.has("attached_time_format"))
		{
			attachment.setAttachedDateTime(Convert.formatDate(Convert.DATE_TIME_DASH_PATTERN_12HR, jsonObject.getString("attached_time_format")));
		}
		if(jsonObject.has("author_id"))
		{
			attachment.setAuthorId(jsonObject.getLong("author_id"));
		}
		if(jsonObject.has("file_uri"))
		{
			attachment.setFileUri(jsonObject.getString("file_uri"));	//No I18N
		}
		if(jsonObject.has("author_name"))
		{
			attachment.setAuthorName(jsonObject.getString("author_name"));
		}
		if(jsonObject.has("file_name"))
		{
			attachment.setFileName(jsonObject.getString("file_name"));
		}
		if(jsonObject.has("file_type"))
		{
			attachment.setFileType(jsonObject.getString("file_type"));
		}

		return attachment;
		
	}

	/**
	 * Parse the JSON response and make it into List of Attachment object.
	 * 
	 * @param response JSON response contains the details of list of attachments.
	 * 
	 * @return Returns List of Attachment object.
	 * 
	 * @throws JSONException
	 */
	
	public List<BugResolution> getResolutions(String response)throws JSONException
	{
		
		JSONObject jsonObject = JSONObject.fromObject(response.trim());
		
		List<BugResolution> resolutionList = new ArrayList<>();
		
		if(jsonObject.has("resolution_details"))
		{
			JSONArray resolutions = jsonObject.getJSONArray("resolution_details");	//No I18N
			
			for(int j = 0; j < resolutions.size(); j++)
			{
				JSONObject resolution = resolutions.getJSONObject(j);
				
				resolutionList.add(this.jsonToResolution(resolution));
			}
			
		}
		
		return resolutionList;
		
	}

	/**
	 * Parse the JSONObject into Comment object.
	 * 
	 * @param jsonObject JSONObject contains the details of a comment.
	 * 
	 * @return Returns the Comment object.
	 * 
	 * @throws JSONException
	 */
	
	public BugResolution jsonToResolution(JSONObject jsonObject)throws JSONException
	{
		
		BugResolution resolution = new BugResolution();
		
		if(jsonObject.has("resolved_time"))
		{
			resolution.setResolvedTime(Convert.formatDate(Convert.DATE_DASH_PATTERN, jsonObject.getString("resolved_time")));	//No I18N
		}
		if(jsonObject.has("resolved_time_format"))
		{
			resolution.setResolvedTimeFormat(Convert.formatDate(Convert.DATE_TIME_DASH_PATTERN_12HR, jsonObject.getString("resolved_time_format")));
		}
		if(jsonObject.has("issue_id"))
		{
			resolution.setIssueId(jsonObject.getLong("issue_id"));
		}
		if(jsonObject.has("resolved_time_long"))
		{
			resolution.setResolvedTimeLong(jsonObject.getLong("resolved_time_long"));
		}
		if(jsonObject.has("resolver"))
		{
			resolution.setResolver(jsonObject.getString("resolver"));
		}
		if(jsonObject.has("resolver_id"))
		{
			resolution.setResolverId(jsonObject.getLong("resolver_id"));
		}
		if(jsonObject.has("resolution"))
		{
			resolution.setResolution(jsonObject.getString("resolution"));
		}

		return resolution;
		
	}
}
