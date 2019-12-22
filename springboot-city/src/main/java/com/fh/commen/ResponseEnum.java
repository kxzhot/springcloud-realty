package com.fh.commen;

public enum ResponseEnum {
    SUCCESS(200,"操作成功"),
    MEMBER_LOGIN_SUCCESS(200,"登录成功"),
    MEMBER_SUCCESS(200,"注册成功"),
    ERROR(1000,"操作失败"),
    MEMBER_NAME_ERROR(1001,"用户名已占用"),
    MEMBER_PHONE_ERROR(1002,"手机已注册"),
    MEMBER_PHONECODE_ERROR(1003,"手机验证码不正确"),

    MEMBER_INPUT_REEOR(1005,"输入错误"),
    MEMBER_NAME_INPUT_REEOR(1006,"用户名输入错误"),
    MEMBER_PWD_INPUT_REEOR(1007,"用户密码输入错误"),
    MEMBER_PHONE_INPUT_REEOR(1008,"用户手机号输入错误"),
    MEMBER_CODE_INPUT_REEOR(1009,"用户验证码输入错误"),
    MEMBER_CODE_ACQUIRE_REEOR(1010,"请获取验证码"),
    MEMBER_INEXISTENCE(1011,"用户不存在"),
    MEMBER_GAIN_ERROER(1012,"获取用户信息错误"),
    SHOPPING_ERROR(1013,"物品信息错误"),
    SHOPPING_NULL_ERROR(1014,"该商品不存在"),
    SHOPPING_OUT_ERROR(1015,"该商品已下架"),
    MEMBER_NULL_ERROR(1016,"用户购物车中没有商品"),
    PRODUCT_INVENTORY_ERROR(1017,"商品库存不足"),
    PAY_LOG_ERROR(1018,"用户交易日志错误"),
    PAY_LOG_WEIXIN_ERROR(1019,"微信支付接口出现错误"),
    MEMBER_ERROR_NOT(1020,"获取收货地址出现错误");
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
