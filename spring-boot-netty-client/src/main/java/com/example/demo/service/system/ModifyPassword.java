package com.example.demo.service.system;

import com.example.demo.service.IBaseMsg;

/**
 * 修改用户密码
 */
public class ModifyPassword implements IBaseMsg {

    private String msg;

    @Override
    public String createResp() {
        //业务逻辑处理...
        return getMsg();
    }

    private String getMsg() {
        //数字签名验证和解密忽略
        return msg;
    }

    @Override
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
