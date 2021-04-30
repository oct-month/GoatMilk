package cn.ablocker.GoatMilkPowder.response;

import cn.ablocker.GoatMilkPowder.entity.User;
import lombok.Getter;
import org.springframework.beans.BeanUtils;

@Getter
public class AccountResponse extends BaseResponse
{
    private User data;

    public AccountResponse(String status)
    {
        super(status);
    }

    public AccountResponse(String status, User user)
    {
        super(status);
        this.data = new User();
        BeanUtils.copyProperties(user, this.data);
        this.data.setPassword(null);
    }
}
