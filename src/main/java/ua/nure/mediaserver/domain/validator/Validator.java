package ua.nure.mediaserver.domain.validator;

public abstract class Validator<T> {

    abstract boolean isValid(T t);

}
