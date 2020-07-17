package com.atguigu.gmail.bean;

import java.io.Serializable;

/**
 * @author hezihao
 * @version 1.0
 * <p>
 * @date 2020/7/16 9:00 下午
 * <p>
 * 用户地址
 */
public class UserAddress implements Serializable {
    private Integer id;
    /**
     * 用户地址
     */
    private String userAddress;
    /**
     * 用户Id
     */
    private String userId;
    /**
     * 收货人
     */
    private String consignee;
    /**
     * 电话号码
     */
    private String phoneNum;
    /**
     * 是否为默认地址，Y-是 N-否
     */
    private String idDefault;

    public UserAddress(Integer id, String userAddress, String userId, String consignee, String phoneNum, String idDefault) {
        this.id = id;
        this.userAddress = userAddress;
        this.userId = userId;
        this.consignee = consignee;
        this.phoneNum = phoneNum;
        this.idDefault = idDefault;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getIdDefault() {
        return idDefault;
    }

    public void setIdDefault(String idDefault) {
        this.idDefault = idDefault;
    }

    @Override
    public String toString() {
        return "UserAddress{" +
                "id=" + id +
                ", userAddress='" + userAddress + '\'' +
                ", userId='" + userId + '\'' +
                ", consignee='" + consignee + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", idDefault='" + idDefault + '\'' +
                '}';
    }
}