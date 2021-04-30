package cn.ablocker.GoatMilkPowder.response;

import cn.ablocker.GoatMilkPowder.entity.ImgUrl;
import lombok.Getter;

import java.util.List;

@Getter
public class ImgUrlResponse extends BaseResponse
{
	private List<ImgUrl> data_list;
	private ImgUrl data;

	public ImgUrlResponse(String status)
	{
		super(status);
	}

	public ImgUrlResponse(String status, List<ImgUrl> data_list)
	{
		super(status);
		this.data_list = data_list;
	}

	public ImgUrlResponse(String status, ImgUrl data)
	{
		super(status);
		this.data = data;
	}
}
