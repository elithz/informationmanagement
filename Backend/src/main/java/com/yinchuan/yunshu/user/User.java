package com.yinchuan.yunshu.user;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * User Object Class
 *
 * @author Siyuan Zeng
 *
 */

@Entity
@Table(name = "users")
public class User {
    /**
     * The id of the user. Automatically created when the user is created
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * The username of the user.
     */
    @Column(name = "USERNAME")
    private String username;

    /**
     * The password of the user
     */
    @Column(name = "PASSWORD")
    private String password;

    /**
     * The user type of the user
     * 1: Admin
     * 2: Buyer
     * 3: Deliver
     */
    @Column(name = "USERTYPE")
    private int userType;

    /**
     * The name of the user
     */
    @Column(name= "NICKNAME")
    private String nickname;

    /**
     * Empty Construction
     */
    public User(){

    }

    /**
     * Construction for testing and for future default
     */
    public User(String username, String password, int userType, String nickname){
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.nickname = nickname;
    }

    /**
     * default setter and getter
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

}
