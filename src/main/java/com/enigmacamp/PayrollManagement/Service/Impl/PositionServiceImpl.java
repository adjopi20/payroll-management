package com.enigmacamp.PayrollManagement.Service.Impl;

import com.enigmacamp.PayrollManagement.Entity.Department;
import com.enigmacamp.PayrollManagement.Entity.Position;
import com.enigmacamp.PayrollManagement.Repository.PositionRepository;
import com.enigmacamp.PayrollManagement.Service.PositionService;
import com.enigmacamp.PayrollManagement.Util.Constant.EDepartment;
import com.enigmacamp.PayrollManagement.Util.Constant.EPosition;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {
    private final PositionRepository positionRepository;
    private final ObjectMapper objectMapper;
    @Override
    public Position savePosition(String stringEPosition) {

        try {
            Map<String, String> jsonMap = objectMapper.readValue(stringEPosition, new TypeReference<Map<String, String>>() {});
            //untuk buat variabel yang dikirinya jadi yang didalam get nya itu key nya, jadi kita masukkan value nya di dalam itu
            String ePositionValue = jsonMap.get("name");
            //convert enum value ke enum constant
            EPosition ePosition = EPosition.valueOf(ePositionValue);

            Position position = Position.builder()
                    .name(ePosition)
                    .build();

            return positionRepository.save(position);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Position> getAllPosition() {
        return positionRepository.findAll();
    }
}
