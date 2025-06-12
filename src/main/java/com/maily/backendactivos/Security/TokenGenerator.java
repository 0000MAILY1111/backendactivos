package com.maily.backendactivos.Security;

public interface TokenGenerator {
    String build(Object id, Object role);
}