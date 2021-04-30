package cn.ablocker.GoatMilkPowder.controller;

import java.util.List;
import java.util.Optional;

import cn.ablocker.GoatMilkPowder.annotation.AdminNeeded;
import cn.ablocker.GoatMilkPowder.annotation.LoginNeeded;
import cn.ablocker.GoatMilkPowder.dao.GoatMilkTestingSampleInternationalDAO;
import cn.ablocker.GoatMilkPowder.entity.GoatMilkTestingSampleInternational;

import cn.ablocker.GoatMilkPowder.response.BaseResponse;
import cn.ablocker.GoatMilkPowder.response.GoatMilkTestingSampleInternationalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/GoatMilkTestingSampleInternational")
public class GoatMilkTestingSampleInternationalController extends BaseController
{
    @Autowired
    private GoatMilkTestingSampleInternationalDAO dao;

    @LoginNeeded
    @GetMapping("/")
    public BaseResponse getAllSamples(HttpServletRequest request, HttpServletResponse response)
    {
        try {
            List<GoatMilkTestingSampleInternational> data_list = dao.findAll();
            return new GoatMilkTestingSampleInternationalResponse(SUCCESS_STATUS, data_list);
        }
        catch (Exception e) {
            return new GoatMilkTestingSampleInternationalResponse(FAIL_STATUS);
        }
    }

    @LoginNeeded
    @GetMapping("/{id}")
    public BaseResponse getSampleById(@PathVariable("id") long id, HttpServletRequest request, HttpServletResponse response)
    {
        try {
            GoatMilkTestingSampleInternational data = dao.getOne(id);
            return new GoatMilkTestingSampleInternationalResponse(SUCCESS_STATUS, data);
        }
        catch (Exception e) {
            return new GoatMilkTestingSampleInternationalResponse(FAIL_STATUS);
        }
    }

    @LoginNeeded
    @AdminNeeded
    @DeleteMapping("/{id}")
    public BaseResponse deleteSampleById(@PathVariable("id") long id, HttpServletRequest request, HttpServletResponse response)
    {
        try {
            dao.deleteById(id);
            return new GoatMilkTestingSampleInternationalResponse(SUCCESS_STATUS);
        }
        catch (Exception e) {
            return new GoatMilkTestingSampleInternationalResponse(FAIL_STATUS);
        }
    }

    @LoginNeeded
    @AdminNeeded
    @PutMapping("/")
    public BaseResponse updateSample(@RequestBody GoatMilkTestingSampleInternational sample, HttpServletRequest request, HttpServletResponse response)
    {
        try {
            GoatMilkTestingSampleInternational data = dao.save(sample);
            return new GoatMilkTestingSampleInternationalResponse(SUCCESS_STATUS, data);
        }
        catch (Exception e) {
            return new GoatMilkTestingSampleInternationalResponse(FAIL_STATUS);
        }
    }

    @LoginNeeded
    @AdminNeeded
    @PostMapping("/")
    public BaseResponse addSample(@RequestBody GoatMilkTestingSampleInternational sample, HttpServletRequest request, HttpServletResponse response)
    {
        try {
            GoatMilkTestingSampleInternational data = dao.save(sample);
            return new GoatMilkTestingSampleInternationalResponse(SUCCESS_STATUS, data);
        }
        catch (Exception e) {
            return new GoatMilkTestingSampleInternationalResponse(FAIL_STATUS);
        }
    }
}
