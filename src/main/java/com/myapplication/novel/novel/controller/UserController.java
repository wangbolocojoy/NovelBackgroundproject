package com.myapplication.novel.novel.controller;

import com.myapplication.novel.novel.annotation.TokenService;
import com.myapplication.novel.novel.basebean.BaseResult;
import com.myapplication.novel.novel.basebean.HttpCode;
import com.myapplication.novel.novel.repository.UserRespository;
import com.myapplication.novel.novel.table.User;
import com.myapplication.novel.novel.untils.JsonHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/mynovel")
public class UserController {
    public Logger log =  LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserRespository userRespository;
    @Autowired
    private TokenService tokenService;
    /**
     * @param response
     * @param phone
     * @param password
     * @throws Exception
     * 注册
     */
    @RequestMapping("/register")
    private void registeruser(HttpServletResponse response, @RequestParam(name = "phone", defaultValue = "") String phone,
                              @RequestParam(name = "password", defaultValue = "") String password) throws Exception {
        if (!phone.isEmpty() && !password.isEmpty()) {
            if(phone.length()==11){
                User user = userRespository.findByAccount(phone);
                if (null != user) {
                    JsonHelper.toJson(new BaseResult(HttpCode.failcode, HttpCode.failmsg, "该账号已经注册,请直接登陆"), response);
                } else {
                    User user1 = new User();
                    user1.setRelasename("超级大灰狼");
                    user1.setFances(0);
                    user1.setIcon("https://superhero-android-ios-myapplication-picture.oss-cn-hangzhou.aliyuncs.com/qq3.png");
                    user1.setLikestarts(0);
                    user1.setNickname("superhero");
                    user1.setAccount(phone);
                    user1.setPassword(password);
                    user1.setToken(tokenService.getToken(user1));
                    userRespository.save(user1);
                    JsonHelper.toJson(new BaseResult(true, "注册成功,请登陆"), response);
                }
            }else {
                JsonHelper.toJson(new BaseResult(HttpCode.failcode, HttpCode.failmsg, "手机号位数不正确,请重新填写"), response);
            }
        } else {
            JsonHelper.toJson(new BaseResult(HttpCode.failcode, HttpCode.failmsg, "注册信息为空,请填写注册信息"), response);
        }

    }

    /**
     * 登陆
     * @param response
     * @param phone
     * @param password
     * @throws Exception
     */
    @RequestMapping("/login")
    private void loginbyuser(HttpServletResponse response, @RequestParam(name = "phone", defaultValue = "") String phone,
                             @RequestParam(name = "password", defaultValue = "") String password) throws Exception {
        log.info("phone.length"+phone.length());
        log.info("phone.length"+phone);
        if (!phone.isEmpty() && !password.isEmpty()) {
            if (phone.length()==11){
                User user = userRespository.findByAccount(phone);
                if (null != user) {
                    if (user.getAccount().equals(phone) && user.getPassword().equals(password)) {
                        user.setPassword("******");
                        JsonHelper.toJson(new BaseResult(true, user), response);
                    } else {
                        JsonHelper.toJson(new BaseResult(HttpCode.failcode, HttpCode.failmsg, "密码错误,请重新输入密码"), response);
                    }
                } else {
                    JsonHelper.toJson(new BaseResult(HttpCode.failcode, HttpCode.failmsg, "该账号还未注册,请先注册"), response);
                }
            }else {
                JsonHelper.toJson(new BaseResult(HttpCode.failcode, HttpCode.failmsg, "手机号位数不正确,请重新填写"), response);
            }

        } else {
            JsonHelper.toJson(new BaseResult(HttpCode.failcode, HttpCode.failmsg, "登陆信息为空,请填写手机号以及密码"), response);
        }

    }


}
