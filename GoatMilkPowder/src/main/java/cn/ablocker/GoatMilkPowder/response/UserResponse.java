package cn.ablocker.GoatMilkPowder.response;

import cn.ablocker.GoatMilkPowder.entity.User;
import lombok.Getter;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Getter
public class UserResponse extends BaseResponse
{
	private User data;
	private List<User> data_list;

	public UserResponse(String status)
	{
		super(status);
	}

	public UserResponse(String status, User data)
	{
		super(status);
		this.data = new User();
		BeanUtils.copyProperties(data, this.data);
		this.data.setPassword(null);
	}

	public UserResponse(String status, List<User> data_list)
	{
		super(status);
		this.data_list = new ArrayList<>();
		for (User user : data_list)
		{
			User data = new User();
			BeanUtils.copyProperties(user, data);
			data.setPassword(null);
			this.data_list.add(data);
		}
	}
}
