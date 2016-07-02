package es.upm.miw.innoassessment.business.api.exceptions;

public class AlreadyExistFactorException extends ApiException {

    private static final long serialVersionUID = -1344640670884805385L;

    public static final String DESCRIPTION = "Already factor exist";

    public static final int CODE = 1;

    public AlreadyExistFactorException() {
        this("");
    }

    public AlreadyExistFactorException(String detail) {
        super(DESCRIPTION + ". " + detail, CODE);
    }

}
