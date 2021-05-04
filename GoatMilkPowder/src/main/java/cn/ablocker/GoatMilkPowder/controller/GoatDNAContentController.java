package cn.ablocker.GoatMilkPowder.controller;

import cn.ablocker.GoatMilkPowder.annotation.AdminNeeded;
import cn.ablocker.GoatMilkPowder.annotation.LoginNeeded;
import cn.ablocker.GoatMilkPowder.dao.GoatDNAContentDAO;
import cn.ablocker.GoatMilkPowder.entity.GoatDNAContent;
import cn.ablocker.GoatMilkPowder.response.BaseResponse;
import cn.ablocker.GoatMilkPowder.response.GoatDNAContentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api/GoatDNAContent")
public class GoatDNAContentController extends BaseController
{
    @Autowired
    private GoatDNAContentDAO dao;

    @LoginNeeded
    @GetMapping("/")
    public BaseResponse getAll(HttpServletRequest request, HttpServletResponse response)
    {
        try {
            List<GoatDNAContent> data_list = dao.findAll();
            return new GoatDNAContentResponse(SUCCESS_STATUS, data_list);
        }
        catch (Exception e) {
            System.out.println(e);
            return new GoatDNAContentResponse(FAIL_STATUS);
        }
    }

    @LoginNeeded
    @GetMapping("/{id}")
    public BaseResponse getById(@PathVariable("id") long id, HttpServletRequest request, HttpServletResponse response)
    {
        try {
            GoatDNAContent data = dao.getOne(id);
            return new GoatDNAContentResponse(SUCCESS_STATUS, data);
        }
        catch (Exception e) {
            System.out.println(e);
            return new GoatDNAContentResponse(FAIL_STATUS);
        }
    }

    @LoginNeeded
    @AdminNeeded
    @DeleteMapping("/{id}")
    public BaseResponse deleteById(@PathVariable("id") long id, HttpServletRequest request, HttpServletResponse response)
    {
        try {
            dao.deleteById(id);
            return new GoatDNAContentResponse(SUCCESS_STATUS);
        }
        catch (Exception e) {
            System.out.println(e);
            return new GoatDNAContentResponse(FAIL_STATUS);
        }
    }

    @LoginNeeded
    @AdminNeeded
    @PutMapping("/")
    public BaseResponse update(@RequestBody GoatDNAContent sample, HttpServletRequest request, HttpServletResponse response)
    {
        try {
            GoatDNAContent data = dao.save(sample);
            return new GoatDNAContentResponse(SUCCESS_STATUS, data);
        }
        catch (Exception e) {
            System.out.println(e);
            return new GoatDNAContentResponse(FAIL_STATUS);
        }
    }

    @LoginNeeded
    @AdminNeeded
    @PostMapping("/")
    public BaseResponse add(@RequestBody GoatDNAContent sample, HttpServletRequest request, HttpServletResponse response)
    {
        try {
            GoatDNAContent data = dao.save(sample);
            return new GoatDNAContentResponse(SUCCESS_STATUS, data);
        }
        catch (Exception e) {
            System.out.println(e);
            return new GoatDNAContentResponse(FAIL_STATUS);
        }
    }
}
