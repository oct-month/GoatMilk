package cn.ablocker.GoatMilkPowder.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ablocker.GoatMilkPowder.response.AccountResponse;
import cn.ablocker.GoatMilkPowder.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cn.ablocker.GoatMilkPowder.entity.User;
import cn.ablocker.GoatMilkPowder.utils.LoginUtils;

@RestController
@RequestMapping("/api/account")
public class AccountController extends BaseController
{
    @Autowired
    private LoginUtils loginUtils;

    @PostMapping(value = "/login", produces = "application/json")
    public BaseResponse login(@RequestBody User user, HttpServletRequest request, HttpServletResponse response)
    {
        String sessionId = request.getSession().getId();
        User dbUser = loginUtils.login(user.getUsername(), user.getPassword(), sessionId);
        if (dbUser != null)
            return new AccountResponse(SUCCESS_STATUS, dbUser);
        else
            return new AccountResponse(FAIL_STATUS);
    }

    @GetMapping(value = "/islogin", produces = "application/json")
    public BaseResponse islogin(HttpServletRequest request, HttpServletResponse response)
    {
        String sessionId = request.getSession().getId();
        boolean flag = loginUtils.isLogin(sessionId);
        if (flag)
            return new AccountResponse(SUCCESS_STATUS);
        else
            return new AccountResponse(FAIL_STATUS);
    }

    @PostMapping(value = "/registry", produces = "application/json")
    public BaseResponse registry(@RequestBody User user, HttpServletRequest request, HttpServletResponse response)
    {
        User dbUser = loginUtils.registry(user);
        if (dbUser != null)
            return new AccountResponse(SUCCESS_STATUS, dbUser);
        else
            return new AccountResponse(FAIL_STATUS);
    }
}
