package com.zouhhhhh.bean;


/**
 * @author zouhao
 * @date 2022/4/17
 */
public class Reader {

    private String id;
    private String userName;
    private String password;
    private String name;
    private String tel;
    private String cardId;
    private String gender;

    public Reader(String id, String userName, String password, String name
            , String tel, String cardId, String gender) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.tel = tel;
        this.cardId = cardId;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
