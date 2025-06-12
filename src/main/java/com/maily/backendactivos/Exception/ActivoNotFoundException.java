package com.maily.backendactivos.Exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

public class ActivoNotFoundException extends RuntimeException implements GraphQLError {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> extensions = new HashMap<>();

	public ActivoNotFoundException(String message, Long invalidActivoId) {
		super(message);
		extensions.put("invalidActivoId", invalidActivoId);
	}

	@Override
	public List<SourceLocation> getLocations() {
		return null;
	}

	@Override
	public Map<String, Object> getExtensions() {
		return extensions;
	}

	@Override
	public ErrorType getErrorType() {
		return ErrorType.DataFetchingException;
	}
}
