package es.upm.miw.innoassessment.business.api.exceptions;

public class AlreadyExistDimensionException extends ApiException {

    private static final long serialVersionUID = -1344640670884805385L;

    public static final String DESCRIPTION = "Already dimension exist";

    public static final int CODE = 1;

    public AlreadyExistDimensionException() {
        this("");
    }

    public AlreadyExistDimensionException(String detail) {
        super(DESCRIPTION + ". " + detail, CODE);
    }

}
