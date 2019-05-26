package com.example.demo.service;

public class Factory {

    public static IBaseMsg getInstance(String transCode) {
        String className = "";
        switch (transCode) {
            case "TransCode1":
                className = "com.example.demo.service.system.UserInfo";
                break;
            case "TransCode2":
                className = "com.example.demo.service.system.ModifyPassword";
                break;
        }
        try {
            return (IBaseMsg) Class.forName(className.trim()).newInstance();
        } catch (IllegalAccessException | ClassNotFoundException | InstantiationException e) {
            e.printStackTrace();
            return null;
        }
    }

}
