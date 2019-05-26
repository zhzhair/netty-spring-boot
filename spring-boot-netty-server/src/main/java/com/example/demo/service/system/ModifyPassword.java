package com.example.demo.service.system;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.BaseMsg;
import com.example.demo.service.IBaseMsg;

/**
 * 修改用户密码
 */
public class ModifyPassword extends BaseMsg implements IBaseMsg {
    private String oldPassword;
    private String newPassword;

    @Override
    public void parseReq(JSONObject msg) {
        JSONObject jsonObject = msg.getJSONObject("data");
        if (jsonObject != null) {
            oldPassword = jsonObject.getString("oldPassword");
            newPassword = jsonObject.getString("newPassword");
        }
    }

    @Override
    public JSONObject createResp() {
        JSONObject msg = new JSONObject();
        System.out.println(oldPassword + "|" + newPassword);
        msg.put(APP_MSG, "ok");
        createCommonBody(msg);
        return msg;
    }
}
