package cn.ablocker.GoatMilkPowder.response;

import lombok.Getter;

@Getter
public class BaseResponse
{
    protected String status;

    public BaseResponse()
    {
        this.status = "success";
    }

    public BaseResponse(String status)
    {
        this.status = status;
    }
}
