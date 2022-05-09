package com.xxxx.flyserver.controller;


import com.xxxx.flyserver.pojo.Employee;
import com.xxxx.flyserver.pojo.RespBean;
import com.xxxx.flyserver.service.IEmployeeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cxf
 * @since 2022-03-12
 */
@RestController
@RequestMapping("/admin/emp")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @ApiOperation(value = "查看员工列表")
    @GetMapping("/")
    public List<Employee> getEmp(){
        return employeeService.getEmp();
    }

    @ApiOperation(value = "删除员工列表")
    @DeleteMapping("/{id}")
    public RespBean deleteEmp(@PathVariable("id") Integer id){
        return employeeService.deleteEmp(id);
    }

    @ApiOperation(value = "添加员工列表")
    @PostMapping("/")
    public RespBean addEmp(@RequestBody Employee employee){
        return employeeService.addEmp(employee);
    }

    @ApiOperation(value = "更新员工列表")
    @PutMapping("/")
    public RespBean updateEmp(@RequestBody Employee employee){
        return employeeService.updateEmp(employee);
    }
}
