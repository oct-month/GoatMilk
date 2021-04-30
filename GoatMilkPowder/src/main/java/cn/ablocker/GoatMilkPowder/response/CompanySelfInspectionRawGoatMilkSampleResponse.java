package cn.ablocker.GoatMilkPowder.response;

import cn.ablocker.GoatMilkPowder.entity.CompanySelfInspectionRawGoatMilkSample;
import lombok.Getter;

import java.util.List;

@Getter
public class CompanySelfInspectionRawGoatMilkSampleResponse extends BaseResponse
{
    private CompanySelfInspectionRawGoatMilkSample data;
    private List<CompanySelfInspectionRawGoatMilkSample> data_list;

    public CompanySelfInspectionRawGoatMilkSampleResponse(String status)
    {
        super(status);
    }

    public CompanySelfInspectionRawGoatMilkSampleResponse(String status, CompanySelfInspectionRawGoatMilkSample sample)
    {
        super(status);
        this.data = sample;
    }

    public CompanySelfInspectionRawGoatMilkSampleResponse(String status, List<CompanySelfInspectionRawGoatMilkSample> samples)
    {
        super(status);
        this.data_list = samples;
    }
}
