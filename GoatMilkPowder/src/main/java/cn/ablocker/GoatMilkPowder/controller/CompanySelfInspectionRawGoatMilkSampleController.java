package cn.ablocker.GoatMilkPowder.controller;

import java.util.List;

import cn.ablocker.GoatMilkPowder.annotation.AdminNeeded;
import cn.ablocker.GoatMilkPowder.annotation.LoginNeeded;
import cn.ablocker.GoatMilkPowder.response.BaseResponse;
import cn.ablocker.GoatMilkPowder.response.CompanySelfInspectionRawGoatMilkSampleResponse;
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

import cn.ablocker.GoatMilkPowder.dao.CompanySelfInspectionRawGoatMilkSampleDAO;
import cn.ablocker.GoatMilkPowder.entity.CompanySelfInspectionRawGoatMilkSample;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/CompanySelfInspectionRawGoatMilkSample")
public class CompanySelfInspectionRawGoatMilkSampleController extends BaseController
{
    @Autowired
    private CompanySelfInspectionRawGoatMilkSampleDAO dao;

    @LoginNeeded
    @GetMapping("/")
    public BaseResponse getAllSamples(HttpServletRequest request, HttpServletResponse response)
    {
        try {
            List<CompanySelfInspectionRawGoatMilkSample> data_list = dao.findAll();
            return new CompanySelfInspectionRawGoatMilkSampleResponse(SUCCESS_STATUS, data_list);
        }
        catch (Exception e) {
            return new CompanySelfInspectionRawGoatMilkSampleResponse(FAIL_STATUS);
        }
    }

    @LoginNeeded
    @GetMapping("/{id}")
    public BaseResponse getSampleById(@PathVariable("id") long id, HttpServletRequest request, HttpServletResponse response)
    {
        try {
            CompanySelfInspectionRawGoatMilkSample data = dao.getOne(id);
            return new CompanySelfInspectionRawGoatMilkSampleResponse(SUCCESS_STATUS, data);
        }
        catch (Exception e) {
            return new CompanySelfInspectionRawGoatMilkSampleResponse(FAIL_STATUS);
        }
    }

    @LoginNeeded
    @AdminNeeded
    @DeleteMapping("/{id}")
    public BaseResponse deleteSampleById(@PathVariable("id") long id, HttpServletRequest request, HttpServletResponse response)
    {
        try {
            dao.deleteById(id);
            return new CompanySelfInspectionRawGoatMilkSampleResponse(SUCCESS_STATUS);
        }
        catch (Exception e) {
            return new CompanySelfInspectionRawGoatMilkSampleResponse(FAIL_STATUS);
        }
    }

    @LoginNeeded
    @AdminNeeded
    @PutMapping("/")
    public BaseResponse updateSample(@RequestBody CompanySelfInspectionRawGoatMilkSample sample, HttpServletRequest request, HttpServletResponse response)
    {
        try {
            CompanySelfInspectionRawGoatMilkSample data = dao.saveAndFlush(sample);
            return new CompanySelfInspectionRawGoatMilkSampleResponse(SUCCESS_STATUS, data);
        }
        catch (Exception e) {
            return new CompanySelfInspectionRawGoatMilkSampleResponse(FAIL_STATUS);
        }
    }

    @LoginNeeded
    @AdminNeeded
    @PostMapping("/")
    public BaseResponse addSample(@RequestBody CompanySelfInspectionRawGoatMilkSample sample, HttpServletRequest request, HttpServletResponse response)
    {
        try {
            sample.setId(0);
            CompanySelfInspectionRawGoatMilkSample data = dao.saveAndFlush(sample);
            return new CompanySelfInspectionRawGoatMilkSampleResponse(SUCCESS_STATUS, data);
        }
        catch (Exception e) {
            return new CompanySelfInspectionRawGoatMilkSampleResponse(FAIL_STATUS);
        }
    }
}
