package cn.ablocker.GoatMilkPowder.response;

import cn.ablocker.GoatMilkPowder.entity.GoatMilkTestingSampleProvince;
import lombok.Getter;

import java.util.List;

@Getter
public class GoatMilkTestingSampleProvinceResponse extends BaseResponse
{
    private GoatMilkTestingSampleProvince data;
    private List<GoatMilkTestingSampleProvince> data_list;

    public GoatMilkTestingSampleProvinceResponse(String status)
    {
        super(status);
    }

    public GoatMilkTestingSampleProvinceResponse(String status, GoatMilkTestingSampleProvince sample)
    {
        super(status);
        this.data = sample;
    }

    public GoatMilkTestingSampleProvinceResponse(String status, List<GoatMilkTestingSampleProvince> samples)
    {
        super(status);
        this.data_list = samples;
    }
}
