package ru.mts.medhack2019.shared.exception;

public class ResourceException extends RuntimeException {
    public ResourceException() {
        super();
    }

    public ResourceException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ResourceException(final String message) {
        super(message);
    }

    public ResourceException(final Throwable cause) {
        super(cause);
    }
}
