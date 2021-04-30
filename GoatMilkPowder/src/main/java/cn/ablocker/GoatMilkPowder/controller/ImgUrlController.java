package cn.ablocker.GoatMilkPowder.controller;

import cn.ablocker.GoatMilkPowder.annotation.LoginNeeded;
import cn.ablocker.GoatMilkPowder.dao.ImgUrlDAO;
import cn.ablocker.GoatMilkPowder.entity.ImgUrl;
import cn.ablocker.GoatMilkPowder.response.BaseResponse;
import cn.ablocker.GoatMilkPowder.response.ImgUrlResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api/imgs")
public class ImgUrlController extends BaseController
{
	@Autowired
	private ImgUrlDAO dao;

	@LoginNeeded
	@GetMapping("/")
	public BaseResponse getAllImgUrl(HttpServletRequest request, HttpServletResponse response)
	{
		try {
			List<ImgUrl> data_list = dao.findAll();
			return new ImgUrlResponse(SUCCESS_STATUS, data_list);
		}
		catch (Exception e) {
			return new ImgUrlResponse(FAIL_STATUS);
		}
	}

	@LoginNeeded
	@PostMapping("/")
	public BaseResponse putAImgUrl(@RequestBody ImgUrl url, HttpServletRequest request, HttpServletResponse response)
	{
		try {
			ImgUrl data = dao.saveAndFlush(url);
			return new ImgUrlResponse(SUCCESS_STATUS, data);
		}
		catch (Exception e) {
			return new ImgUrlResponse(FAIL_STATUS);
		}
	}
}
