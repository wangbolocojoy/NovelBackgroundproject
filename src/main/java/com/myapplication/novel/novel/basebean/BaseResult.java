package com.myapplication.novel.novel.basebean;

public class BaseResult {
    private Integer status;//状态码
    private String msg;//消息
    private Object data;//数据对象
    private boolean yes;
    public BaseResult() {
    }

    public BaseResult(Integer code, String massege) {
        this.status = code;
        this.msg = massege;
    }

    public BaseResult(Integer code, String massege, Object result) {
        this.status = code;
        this.msg = massege;
        this.data = result;
    }

    public BaseResult(boolean yes,Object data) {
        if (yes){
            this.status = HttpCode.successcode;
            this.msg = HttpCode.successmsg;
            this.data = data;
        }else{
            this.status = HttpCode.failcode;
            this.msg = HttpCode.failmsg;
            this.data = data;
        }

    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
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
