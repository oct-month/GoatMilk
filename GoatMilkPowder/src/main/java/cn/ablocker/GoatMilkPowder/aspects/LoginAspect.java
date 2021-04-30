package cn.ablocker.GoatMilkPowder.aspects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ablocker.GoatMilkPowder.response.MsgResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import cn.ablocker.GoatMilkPowder.utils.LoginUtils;

@Order(1)
@Component
@Aspect
public class LoginAspect
{
    @Autowired
    private LoginUtils loginUtils;

    @Pointcut("@annotation(cn.ablocker.GoatMilkPowder.annotation.LoginNeeded) && args(.., request, response)")
    public void loginNeeded(HttpServletRequest request, HttpServletResponse response) {}

    @Around("loginNeeded(request, response)")
    public Object checkLoginStatus(ProceedingJoinPoint jp, HttpServletRequest request, HttpServletResponse response)
    {
        String sessionId = request.getSession().getId();
        if (loginUtils.isLogin(sessionId))
        {
            try {
                return jp.proceed();
            }
            catch (Throwable e) {
                e.printStackTrace();
            }
        }
        return new MsgResponse("fail", "login needed");
    }
}
