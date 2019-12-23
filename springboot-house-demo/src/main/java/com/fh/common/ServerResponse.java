package com.fh.common;

public class ServerResponse {
    private int status;
    private String msg;
    private Object data;

    private ServerResponse() {
    }


    public static ServerResponse codesuccess(Object data){
        return new ServerResponse(ResponseEnum.CODESUCCESS.getCode(),ResponseEnum.CODESUCCESS.getMsg(),data);
    }

    public static ServerResponse codeerror(){
        return new ServerResponse(ResponseEnum.CODEERROR.getCode(),ResponseEnum.CODEERROR.getMsg());
    }


    public static ServerResponse success(){
        return new ServerResponse(ResponseEnum.CODESUCCESS.getCode(),ResponseEnum.CODESUCCESS.getMsg());
    }





    public static ServerResponse error(){
        return new ServerResponse(ResponseEnum.ERROR.getCode(),ResponseEnum.ERROR.getMsg());
    }
    public static ServerResponse error(Object data){
        return new ServerResponse(ResponseEnum.ERROR.getCode(),ResponseEnum.ERROR.getMsg() ,data);
    }
    public static ServerResponse success(Object data){
        return new ServerResponse(ResponseEnum.SUCCESS.getCode(),ResponseEnum.SUCCESS.getMsg(),data);
    }



    public static ServerResponse zhuce(ResponseEnum res){
        return new ServerResponse(res.getCode(),res.getMsg());
    }

    public static ServerResponse zhuce(ResponseEnum res, Object data){
        return new ServerResponse(res.getCode(),res.getMsg(),data);
    }



    private ServerResponse(int status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
    public ServerResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


}
