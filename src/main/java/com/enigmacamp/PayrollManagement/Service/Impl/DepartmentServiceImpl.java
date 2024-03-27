package com.enigmacamp.PayrollManagement.Service.Impl;

import com.enigmacamp.PayrollManagement.Entity.Department;
import com.enigmacamp.PayrollManagement.Repository.DepartmentRepository;
import com.enigmacamp.PayrollManagement.Service.DepartmentService;
import com.enigmacamp.PayrollManagement.Util.Constant.EDepartment;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final ObjectMapper objectMapper;
    @Override
    public Department saveDepartment(String stringEDepartment) {
        //ubahjson ke map
        try {
            Map<String, String> jsonMap = objectMapper.readValue(stringEDepartment, new TypeReference<Map<String, String>>() {});
            //untuk buat variabel yang dikirinya jadi yang didalam get nya itu key nya, jadi kita masukkan value nya di dalam itu
            String eDepartmentValue = jsonMap.get("name");
            //convert enum value ke enum constant
            EDepartment eDepartment = EDepartment.valueOf(eDepartmentValue);

            Department department = Department.builder()
                    .name(eDepartment)
                    .build();

            return departmentRepository.save(department);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }
}
