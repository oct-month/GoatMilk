package cn.ablocker.GoatMilkPowder.response;

import cn.ablocker.GoatMilkPowder.entity.GoatDNAContent;
import lombok.Getter;

import java.util.List;

@Getter
public class GoatDNAContentResponse extends BaseResponse
{
    private GoatDNAContent data;
    private List<GoatDNAContent> data_list;

    public GoatDNAContentResponse(String status)
    {
        super(status);
    }

    public GoatDNAContentResponse(String status, GoatDNAContent data)
    {
        super(status);
        this.data = data;
    }

    public GoatDNAContentResponse(String status, List<GoatDNAContent> data_list)
    {
        super(status);
        this.data_list = data_list;
    }
}
