/* $Id$ */

package com.zoho.projects.api;

import java.util.HashMap;
import java.util.List;

import com.zoho.projects.model.Document;

import com.zoho.projects.parser.DocumentParser;

import com.zoho.projects.util.ZohoHTTPClient;

/**
 * DocumentsAPI is used to:
 *
 * 	Get list of documents.
 *
 * 	Get the details of a document.
 *
 * 	Add a document.
 *
 * 	Update the details of a document.
 *
 * 	Delete an existing document.
 *
 * @author ramesh-2099
 */

public class DocumentsAPI extends API {

	//DocumentParser is used to parse the JSON response into respective objects.
	DocumentParser documentParser = new DocumentParser();

	/**
	 * Construct a new DocumentsAPI using user's authToken and portalId.
	 * @param authToken user's authToken.
	 * @param portalId user's portalId.
	 */
	public DocumentsAPI(String authToken, String portalId) {
		super(authToken, portalId);
	}

	/**
	 * Get list of documents for the project.
	 * @param projectId ID of the project.
	 * @param queryMap This queryMap contains the filters in the form of key-value pair.
	 * @return Returns list of Document object.
	 * @throws Exception
	 */
	public List<Document> getDocuments(String projectId, HashMap<String, Object> queryMap) throws Exception {
		StringBuilder url = new StringBuilder(150);
		url.append(getBaseURL()).append("/projects/").append(projectId).append("/documents/");	//No I18N

		String response = ZohoHTTPClient.get(url.toString(), getQueryMap(queryMap));

		return documentParser.getDocuments(response);
	}

	/**
	 * Get the details of a document.
	 * @param projectId ID of the project.
	 * @param documentId ID of the document.
	 * @param queryMap This queryMap contains the filters in the form of key-value pair.
	 * @return Returns the Document object.
	 * @throws Exception
	 */
	public Document get(String projectId, String documentId, HashMap<String, Object> queryMap) throws Exception {
		StringBuilder url = new StringBuilder(150);
		url.append(getBaseURL()).append("/projects/").append(projectId);
		url.append("/documents/").append(documentId).append("/");	//No I18N

		String response = ZohoHTTPClient.get(url.toString(), getQueryMap(queryMap));

		return documentParser.getDocument(response);
	}

	/**
	 * Add a document for the project.
	 * @param projectId Id of the project.
 	 * @param document Document object.
	 * @return Returns the Document object.
	 * @throws Exception
	 */
	public Document add(String projectId, Document document) throws Exception {
		StringBuilder url = new StringBuilder(150);
		url.append(getBaseURL()).append("/projects/").append(projectId).append("/documents/");	//No I18N

		HashMap<String, Object> fileBody = new HashMap<>();

		fileBody.put("uploaddoc", document.getUploaddoc());

		String response = ZohoHTTPClient.post(url.toString(), getQueryMap(), document.toParamMAP(), fileBody);

		return documentParser.getDocument(response);
	}

	/**
	 * Update the details of a document.
	 * @param projectId ID of the project.
	 * @param document Document object.
	 * @return Returns the Document object.
	 * @throws Exception
	 */
	public Document update(String projectId, Document document) throws Exception {
		StringBuilder url = new StringBuilder(150);
		url.append(getBaseURL()).append("/projects/").append(projectId);
		url.append("/documents/").append(document.getId()).append("/");	//No I18N

		HashMap<String, Object> fileBody = new HashMap<>();

		fileBody.put("uploaddoc", document.getUploaddoc());

		String response = ZohoHTTPClient.post(url.toString(), getQueryMap(), document.toParamMAP(), fileBody);

		return documentParser.getDocument(response);
	}

	/**
	 * Delete an existing document for the project.
 	 * @param projectId ID of the project.
	 * @param documentId ID of the document.
	 * @return Returns the String object.
	 * @throws Exception
	 */
	public String delete(String projectId, String documentId)throws Exception {
		StringBuilder url = new StringBuilder(150);
		url.append(getBaseURL()).append("/projects/").append(projectId);
		url.append("/documents/").append(documentId).append("/");	//No I18N

		String response = ZohoHTTPClient.delete(url.toString(), getQueryMap());

		return documentParser.getResult(response);
	}
}