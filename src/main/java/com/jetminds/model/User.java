package com.jetminds.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Column;

/**
 * User entity.
 *
 * @author Erik Khalimov.
 */
@Entity
@Table(name = "users")
public class User {

    /**
     * User id column.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    /**
     * User email column.
     */
    @Column(name = "email")
    private String email;

    /**
     * User password column.
     */
    @Column(name = "password")
    private String password;

    /**
     * User is_confirmed column.
     */
    @Column(name = "is_confirmed")
    private Boolean isConfirmed;

    /**
     * getter for userId.
     * @return
     *      id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * setter for user id.
     * @param userId
     *  user id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * getter email.
     * @return
     *  email
     */
    public String getEmail() {
        return email;
    }

    /**
     * setter email.
     * @param email
     *  email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * getter password.
     * @return
     *  password
     */
    public String getPassword() {
        return password;
    }

    /**
     * setter password.
     * @param password
     *  password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * getter isConfirmed.
     * @return
     *  isConfirmed
     */
    public Boolean getIsConfirmed() {
        return isConfirmed;
    }

    /**
     * setter isConfirmed.
     * @param isConfirmed
     *  isConfirmed
     */
    public void setIsConfirmed(Boolean isConfirmed) {
        this.isConfirmed = isConfirmed;
    }
}
