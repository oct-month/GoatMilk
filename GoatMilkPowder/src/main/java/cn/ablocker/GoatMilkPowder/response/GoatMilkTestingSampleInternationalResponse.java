package cn.ablocker.GoatMilkPowder.response;

import cn.ablocker.GoatMilkPowder.entity.GoatMilkTestingSampleInternational;
import lombok.Getter;

import java.util.List;

@Getter
public class GoatMilkTestingSampleInternationalResponse extends BaseResponse
{
    private GoatMilkTestingSampleInternational data;
    private List<GoatMilkTestingSampleInternational> data_list;

    public GoatMilkTestingSampleInternationalResponse(String status)
    {
        super(status);
    }

    public GoatMilkTestingSampleInternationalResponse(String status, GoatMilkTestingSampleInternational sample)
    {
        super(status);
        this.data = sample;
    }

    public GoatMilkTestingSampleInternationalResponse(String status, List<GoatMilkTestingSampleInternational> samples)
    {
        super(status);
        this.data_list = samples;
    }
}
