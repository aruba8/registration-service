package com.jetminds.model;

public class BodyEmail {

    private String password;
    private String email;
    private String code;

    public void setParameter(String password, String email, String code) {
        this.password = password;
        this.email = email;
        this.code = code;
    }

    public String getBodyEmail() {
        String bodyEmail = null;

        bodyEmail = "<!DOCTYPE html>\n"
                + "<html>\n <head lang=\"en\">\n"
                + "<meta charset=\"UTF-8\">\n"
                + "<style type=\"text/css\">\n"
                + "p {font-family: Helvetica; margin: 20px 0;}\n"
                + "</style>\n </head>\n"
                + "<body>\n <div>\n <center>\n"
                + "<h1>Thank you for registration!</h1>\n"
                + "<p>You have succesfully created account on our site.</p>\n"
                + "<br/>\n<p>Your email " + email + " and you pass ends on ****"
                + password.substring(password.length() - 3)
                + "</p>\n <br/>\n"
                + "<p>To confirm your account please click on this link</p>\n"
                + "<br/>\n<a href=\"http://localhost:8080/confirm/"
                + code + "\">http://localhost:8080/confirm/" + code
                + "</a>\n </center>\n </div>\n </body>\n </html>";
        return bodyEmail;
    }
}
