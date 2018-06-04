package ua.nure.mediaserver.domain.exceptions;

public class ExistingEmailOrPasswordException extends Exception {

    public ExistingEmailOrPasswordException(String s) {
        super(s);
    }
}
