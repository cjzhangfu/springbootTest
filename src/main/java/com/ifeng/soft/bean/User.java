package com.ifeng.soft.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

@Entity
public class User implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false,unique = true)
    private String userName;
    @Column(nullable = false,unique = true)
    private  String passWord;
    @Column(nullable = false,unique = true)
    private  String emails;
    @Column(nullable = true,unique = true)
    private  String nickName;
    @Column(nullable = false)
    private  String regTime;
    public User(){}
    private List<String> kk;

    private List<Long> ss;

    public User(String userName, String passWord, String emails, String nickName, String regTime) {
        this.userName = userName;
        this.passWord = passWord;
        this.emails = emails;
        this.nickName = nickName;
        this.regTime = regTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }

    public List<String> getKk() {
        return kk;
    }

    public void setKk(List<String> kk) {
        this.kk = kk;
    }

    public List<Long> getSs() {
        return ss;
    }

    public void setSs(List<Long> ss) {
        this.ss = ss;
    }
}
