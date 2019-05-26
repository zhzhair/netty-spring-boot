package com.example.demo.service.system;

import com.example.demo.service.IBaseMsg;

/**
 * 获取用户信息
 */
public class UserInfo implements IBaseMsg {

    protected String msg;

    @Override
    public String createResp() {
        //业务逻辑处理...
        return getMsg();
    }

    @Override
    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        //数字签名验证和解密忽略
        return msg;
    }

}
