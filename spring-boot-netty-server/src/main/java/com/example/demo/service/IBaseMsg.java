package com.example.demo.service;

import com.alibaba.fastjson.JSONObject;

/**
 * 交易类接口
 */
public interface IBaseMsg {
    //接收报文
    void parseReq(JSONObject msg);

    //返回报文
    JSONObject createResp();

    void setOrgId(String orgId);

    void setUserId(Integer userId);

    void setAreaType(Integer areaType);

    void setTransCode(String transCode);

    void setSerialNo(String serialNo);
}
