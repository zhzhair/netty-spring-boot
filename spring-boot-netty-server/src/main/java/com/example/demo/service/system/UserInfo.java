package com.example.demo.service.system;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.BaseMsg;
import com.example.demo.service.IBaseMsg;

/**
 * 获取用户信息
 */
public class UserInfo extends BaseMsg implements IBaseMsg {
    @Override
    public void parseReq(JSONObject msg) {
        System.out.println(msg);
    }

    @Override
    public JSONObject createResp() {
        JSONObject msg = new JSONObject();
        msg.put(APP_USERINFO, "\"name\":\"小明\",\"age\":\"30\"");
        msg.put(APP_MSG, "ok");
        createCommonBody(msg);
        return msg;
    }
}
