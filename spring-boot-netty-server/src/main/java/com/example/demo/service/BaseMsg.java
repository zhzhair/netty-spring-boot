package com.example.demo.service;

import com.alibaba.fastjson.JSONObject;

/**
 * 消息处理基类
 */
public class BaseMsg {
    protected static final String APP_USERID = "userId";
    protected static final String APP_ORGID = "orgId";
    protected static final String APP_AREATYPE = "areaType";
    protected static final String APP_TRANSCODE = "transCode";
    protected static final String APP_DATA = "data";
    protected static final String APP_MSG = "successMsg";
    protected static final String APP_USERINFO = "userInfo";
    protected static final String APP_REQNO = "serialNo";
//    protected static final String APP_ERRORMSG = "errorMsg";

    /*序列号*/
    protected String serialNo;
    /*机构id*/
    protected String orgId;
    /*用户id*/
    protected Integer userId;
    /*机构在总部、省、市、县的标记*/
    protected Integer areaType;
    /*请求的交互码*/
    protected String transCode;
    /*请求数据的data部分*/
    protected JSONObject jsonObjectData;

    public BaseMsg() {

    }

    /*返回数据公共部分处理封装*/
    public void createCommonBody(JSONObject msg) {
        msg.put(APP_USERID, userId);
        msg.put(APP_ORGID, orgId);
        msg.put(APP_AREATYPE, areaType);
        msg.put(APP_TRANSCODE, transCode);
        msg.put(APP_REQNO, serialNo);
    }

    public Integer getAreaType() {
        return areaType;
    }

    public void setAreaType(Integer areaType) {
        this.areaType = areaType;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTransCode() {
        return transCode;
    }

    public void setTransCode(String transCode) {
        this.transCode = transCode;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }
}
