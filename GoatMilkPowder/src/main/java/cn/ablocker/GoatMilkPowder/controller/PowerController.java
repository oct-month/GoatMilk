package cn.ablocker.GoatMilkPowder.controller;

import cn.ablocker.GoatMilkPowder.annotation.AdminNeeded;
import cn.ablocker.GoatMilkPowder.annotation.LoginNeeded;
import cn.ablocker.GoatMilkPowder.dao.UserDAO;
import cn.ablocker.GoatMilkPowder.entity.User;
import cn.ablocker.GoatMilkPowder.response.BaseResponse;
import cn.ablocker.GoatMilkPowder.response.UserResponse;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api/power")
public class PowerController extends BaseController
{
	private UserDAO dao;

	@LoginNeeded
	@AdminNeeded
	@GetMapping("/")
	public BaseResponse getUsers(HttpServletRequest request, HttpServletResponse response)
	{
		try {
			List<User> data_list = dao.findAll();
			return new UserResponse(SUCCESS_STATUS, data_list);
		}
		catch (Exception e) {
			return new UserResponse(FAIL_STATUS);
		}
	}

	@LoginNeeded
	@AdminNeeded
	@PutMapping("/")
	public BaseResponse changePower(@RequestBody User user, HttpServletRequest request, HttpServletResponse response)
	{
		try {
			User source = dao.getOne(user.getUsername());
			user.setPassword(source.getPassword());
			dao.saveAndFlush(user);
			return new UserResponse(SUCCESS_STATUS, user);
		}
		catch (Exception e) {
			return new UserResponse(FAIL_STATUS);
		}
	}
}
