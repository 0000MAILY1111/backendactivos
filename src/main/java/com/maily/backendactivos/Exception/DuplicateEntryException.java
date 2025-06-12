package com.maily.backendactivos.Exception;

public class DuplicateEntryException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateEntryException(String cause) {
        super(cause);
    }
}