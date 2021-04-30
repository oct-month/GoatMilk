package cn.ablocker.GoatMilkPowder.controller;

import java.util.List;
import java.util.Optional;

import cn.ablocker.GoatMilkPowder.annotation.AdminNeeded;
import cn.ablocker.GoatMilkPowder.annotation.LoginNeeded;
import cn.ablocker.GoatMilkPowder.response.BaseResponse;
import cn.ablocker.GoatMilkPowder.response.GoatMilkTestingSampleProvinceResponse;
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

import cn.ablocker.GoatMilkPowder.dao.GoatMilkTestingSampleProvinceDAO;
import cn.ablocker.GoatMilkPowder.entity.GoatMilkTestingSampleProvince;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/GoatMilkTestingSampleProvince")
public class GoatMilkTestingSampleProvinceController extends BaseController
{
    @Autowired
    private GoatMilkTestingSampleProvinceDAO dao;

    @LoginNeeded
    @GetMapping("/")
    public BaseResponse getAllSamples(HttpServletRequest request, HttpServletResponse response)
    {
        try {
            List<GoatMilkTestingSampleProvince> data_list = dao.findAll();
            return new GoatMilkTestingSampleProvinceResponse(SUCCESS_STATUS, data_list);
        }
        catch (Exception e) {
            return new GoatMilkTestingSampleProvinceResponse(FAIL_STATUS);
        }
    }

    @LoginNeeded
    @GetMapping("/{id}")
    public BaseResponse getSampleById(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response)
    {
        try {
            GoatMilkTestingSampleProvince data = dao.getOne(id);
            return new GoatMilkTestingSampleProvinceResponse(SUCCESS_STATUS, data);
        }
        catch (Exception e) {
            return new GoatMilkTestingSampleProvinceResponse(FAIL_STATUS);
        }
    }

    @LoginNeeded
    @AdminNeeded
    @DeleteMapping("/{id}")
    public BaseResponse deleteSampleById(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response)
    {
        try {
            dao.deleteById(id);
            return new GoatMilkTestingSampleProvinceResponse(SUCCESS_STATUS);
        }
        catch (Exception e) {
            return new GoatMilkTestingSampleProvinceResponse(FAIL_STATUS);
        }
    }

    @LoginNeeded
    @AdminNeeded
    @PutMapping("/")
    public BaseResponse updateSample(@RequestBody GoatMilkTestingSampleProvince sample, HttpServletRequest request, HttpServletResponse response)
    {
        try {
            GoatMilkTestingSampleProvince data = dao.save(sample);
            return new GoatMilkTestingSampleProvinceResponse(SUCCESS_STATUS, data);
        }
        catch (Exception e) {
            return new GoatMilkTestingSampleProvinceResponse(FAIL_STATUS);
        }
    }

    @LoginNeeded
    @AdminNeeded
    @PostMapping("/")
    public BaseResponse addSample(@RequestBody GoatMilkTestingSampleProvince sample, HttpServletRequest request, HttpServletResponse response)
    {
        try {
            GoatMilkTestingSampleProvince data = dao.save(sample);
            return new GoatMilkTestingSampleProvinceResponse(SUCCESS_STATUS, data);
        }
        catch (Exception e) {
            return new GoatMilkTestingSampleProvinceResponse(FAIL_STATUS);
        }
    }
}
