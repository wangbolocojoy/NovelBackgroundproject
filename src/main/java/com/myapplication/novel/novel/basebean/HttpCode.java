package com.myapplication.novel.novel.basebean;

public interface HttpCode {
    public static final Integer successcode = 200;
    public static final Integer failcode = 303;
    public static final Integer notdatacode = 302;
    public static final Integer tokenfiled = 304;

    public static final String successmsg = "success";
    public static final String tokenfiledmsg = "token验证失败";
    public static final String failmsg = "failed";
    public static final String notdatamsg = "暂无数据";
    public static final String nouser = "暂无数据";



}
