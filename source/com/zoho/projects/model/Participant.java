/* $Id$ */

package com.zoho.projects.model;

import java.io.Serializable;

/**
 * This class is used to make an object for participant.
 * 
 * @author ramesh-2099
 */

public class Participant implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 7023698454636272880L;
	private String participantId;
	private String participantPerson;


	/**
	 * Set the participant id.
	 * 
	 * @param participantId
	 *            ID of the participant.
	 */

	public void setParticipantId(String participantId) {
		this.participantId = participantId;
	}


	/**
	 * Get the participant id.
	 * 
	 * @return Returns the participant id.
	 */

	public String getParticipantId() {
		return participantId;
	}


	/**
	 * Set the participant name.
	 * 
	 * @param participantPerson
	 *            Name of the participant.
	 */

	public void setParticipantPerson(String participantPerson) {
		this.participantPerson = participantPerson;
	}


	/**
	 * Get the participant name.
	 * 
	 * @return Returns the participant name.
	 */

	public String getParticipantPerson() {
		return participantPerson;
	}

}
