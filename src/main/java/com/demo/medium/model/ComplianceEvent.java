package com.demo.medium.model;

import lombok.Data;
@Data
public class ComplianceEvent {
	/** The action. */
	private ComplianceAction action;
	
	/** The resource. */
	private String resource;
	
	/** The event source. */
	private String eventSource;
}
