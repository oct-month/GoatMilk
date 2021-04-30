package cn.ablocker.GoatMilkPowder.response;

import lombok.Getter;

@Getter
public class MsgResponse extends BaseResponse
{
    private String msg;

    public MsgResponse(String status, String msg)
    {
        super(status);
        this.msg = msg;
    }
}
