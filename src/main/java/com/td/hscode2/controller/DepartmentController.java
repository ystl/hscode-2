package com.td.hscode2.controller;

import com.td.hscode2.common.CommonMsg;
import com.td.hscode2.persistent.entity.Department;
import com.td.hscode2.persistent.repository.DepartmentRepository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Resource
    DepartmentRepository departmentRepository;

    @GetMapping("/list")
    public CommonMsg getList() {
        CommonMsg cm = new CommonMsg();
        cm.setData(departmentRepository.findAll());
        return cm;
    }

    @GetMapping("/delete")
    @ResponseBody
    public CommonMsg deleteUser(Integer id) {
        CommonMsg cm = new CommonMsg();
        if(null == id) {
            cm.setMsg("参数缺失");
            return cm;
        }
        departmentRepository.deleteById(id);
        return cm;
    }

    @PostMapping("/add")
    @ResponseBody
    public CommonMsg addList(Department department) {
        CommonMsg cm = new CommonMsg();
        departmentRepository.saveAndFlush(department);
        return cm;
    }

    @PostMapping("/modify")
    public CommonMsg modifyList(Department department) {
        return addList(department);
    }

}
