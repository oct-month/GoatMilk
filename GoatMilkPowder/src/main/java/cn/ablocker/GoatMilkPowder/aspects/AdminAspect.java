package cn.ablocker.GoatMilkPowder.aspects;

import cn.ablocker.GoatMilkPowder.entity.Role;
import cn.ablocker.GoatMilkPowder.response.MsgResponse;
import cn.ablocker.GoatMilkPowder.utils.LoginUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Order(2)
@Component
@Aspect
public class AdminAspect
{
    @Autowired
    private LoginUtils loginUtils;

    @Pointcut("@annotation(cn.ablocker.GoatMilkPowder.annotation.AdminNeeded) && args(.., request, response)")
    public void adminNeeded(HttpServletRequest request, HttpServletResponse response) {}

    @Around("adminNeeded(request, response)")
    public Object checkUserRole(ProceedingJoinPoint jp, HttpServletRequest request, HttpServletResponse response)
    {
        String sessionId = request.getSession().getId();
        String role = loginUtils.getRole(sessionId);
        if (role != null && role.equals(Role.admin))
        {
            try {
                return jp.proceed();
            }
            catch (Throwable e) {
                e.printStackTrace();
            }
        }
        return new MsgResponse("fail", "admin needed");
    }

}
