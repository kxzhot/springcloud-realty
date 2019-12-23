package com.fh.common;

public enum ResponseEnum {
    SUCCESS(200,"操作成功"),
    ERROR(1000,"操作失败"),
    CODESUCCESS(102,"短线发送成功"),
    CODEERROR(101,"短信发送失败"),
    RESOURCES_IS_NOTE(1010,"注册信息为空"),
    RESOURCES_IS_Wuxiao(1011,"注册验证码为空"),
    RESOURCES_IS_NO_NAME(1013,"注册账号已被注册"),
    RESOURCES_IS_NO_PASSWORD(1014,"注册密码为空"),
    RESOURCES_IS_NO_PHONE(1015,"该手机号已被注册"),
    RESOURCES_IS_NUll(1016,"传入的手机号为空"),
    RESOURCES_IS_QIANNUll(1017,"传入的名字为空"),
    CODE_IS_NUll_ISNO(1018,"验证吗不对应"),
    CODE_IS(1020,"验证吗时间过长失效"),
    CHENGGONG(1021,"注册成功"),
    LOGINMSG_NULL(1022,"登录信息为空"),
    LOGINNAME_NULL(1023,"会员名为空"),
    LOGINPASSWORD_NULL(1024,"密码为空"),
    LOGINNAME_ERROR(1025,"用户名不正确"),
    LOGINPASSWORD_ERROR(1026,"密码错误"),
    Car_IS_null(1027,"没有此商品"),
    Car_IS_XIAJIA(1028,"商品已经下架"),
    Car_CHE_IS_NULL(1029,"商品购物车为空"),
    NOCODDE_IS_NOTE(1030,"订单为空"),
    TOKEN_IS_SHIXIAO(1234,"token失效请重新登录"),
    TOKEN_IS_null(1233,"token为空"),


    ;
    private int code;
    private String msg;

    ResponseEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
