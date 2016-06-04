package com.jetminds.model;

/**
 * Blob email.
 */
public class BodyEmail {

    /**
     * New user password.
     */
    private String password;
    /**
     * New user email.
     */
    private String email;
    /**
     * New user code for checked.
     */
    private String code;

    /**
     * Visible char in password.
     */
    private final byte countVisibleCharPassword = 3;

    /**
     * Set parameters ner user.
     * @param password user.
     * @param email user.
     * @param code user.
     */
    public void setParameter(String password, String email, String code) {
        this.password = password;
        this.email = email;
        this.code = code;
    }

    /**
     * Constructor dody email.
     * @return body email.
     */
    public String getBodyEmail() {
        String bodyEmail;

        bodyEmail = "<div>\n <center>\n"
                + "<h1>Thank you for registration!</h1>\n"
                + "<p>You have succesfully created account on our site.</p>\n"
                + "<br/>\n<p>Your email " + email + " and you pass ends on ****"
                + password.substring(password.length() - countVisibleCharPassword)
                + "</p>\n <br/>\n"
                + "<p>To confirm your account please click on this link</p>\n"
                + "<br/>\n<a href=\"http://localhost:8080/confirm/"
                + code + "\">http://localhost:8080/confirm/" + code
                + "</a>\n </center>\n </div>\n";
        return bodyEmail;
    }
}
