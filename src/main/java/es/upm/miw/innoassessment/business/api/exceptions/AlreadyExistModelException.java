package es.upm.miw.innoassessment.business.api.exceptions;

public class AlreadyExistModelException extends ApiException {

    private static final long serialVersionUID = -1344640670884805385L;

    public static final String DESCRIPTION = "Already model exist";

    public static final int CODE = 1;

    public AlreadyExistModelException() {
        this("");
    }

    public AlreadyExistModelException(String detail) {
        super(DESCRIPTION + ". " + detail, CODE);
    }

}
