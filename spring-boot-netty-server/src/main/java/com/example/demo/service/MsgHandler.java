package com.example.demo.service;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MsgHandler extends BaseMsg {

    private static final Logger logger = LoggerFactory.getLogger(MsgHandler.class);

    /*解析接收到的消息并返回响应报文*/
    public String parseMsg(String msg) {
        /*验证签名，再解密加密后的请求报文，然后数据库查询看所属机构是否有调用权限，这里省略前述步骤*/
        JSONObject jsonObject = JSONObject.parseObject(msg);
        if (jsonObject == null) {
            logger.warn("请求报文不能为空");
            return null;
        }
        serialNo = jsonObject.getString(APP_REQNO);
        transCode = jsonObject.getString(APP_TRANSCODE);
        jsonObjectData = jsonObject.getJSONObject(APP_DATA);
        if (jsonObjectData == null) {
            logger.warn("请求报文的data部分不能为空");
            return null;
        }
        userId = jsonObjectData.getInteger(APP_USERID);
        orgId = jsonObjectData.getString(APP_ORGID);
        areaType = jsonObjectData.getInteger(APP_AREATYPE);
        IBaseMsg iBaseMsg = Factory.getInstance(transCode);
        if (iBaseMsg != null) {
            iBaseMsg.parseReq(jsonObject);
            iBaseMsg.setSerialNo(serialNo);
            iBaseMsg.setOrgId(orgId);
            iBaseMsg.setUserId(userId);
            iBaseMsg.setAreaType(areaType);
            iBaseMsg.setTransCode(transCode);
            JSONObject jsonObjectReturn = iBaseMsg.createResp();
            if (jsonObjectReturn == null) {
                return null;//jsonObject.toJSONString()此情此景，如果不判断null，直接关闭流不走了，也不报异常
            }
            /*对返回数据做数字签名和加密，这里省略前述操作*/
            return jsonObjectReturn.toJSONString();
        }
        return null;
    }
}
