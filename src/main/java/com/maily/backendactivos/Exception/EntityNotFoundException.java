package com.maily.backendactivos.Exception;

public class EntityNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EntityNotFoundException(String string) {
        super(string);
    }
}