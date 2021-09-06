package com.example.vhsshop.service.impl;

import com.example.vhsshop.exception.VhsNotFoundException;
import com.example.vhsshop.mapper.dto.VhsDto;
import com.example.vhsshop.mapper.MapStructMapper;
import com.example.vhsshop.model.Vhs;
import com.example.vhsshop.repository.VhsRepository;
import com.example.vhsshop.service.VhsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VhsServiceImpl implements VhsService {

    @Autowired
    private MapStructMapper mapper;

    @Autowired
    private VhsRepository vhsRepository;

    @Override
    public List<VhsDto> getVhs() {
        List<Vhs> list = vhsRepository.findAll();
        return mapper.vhoListToVhsDtoList(list);
    }

    @Override
    public VhsDto getVhsById(Long id) {
        return mapper.vhsToVhsDto(
                vhsRepository.findById(id).orElseThrow(
                        () -> new VhsNotFoundException("Vhs with id: " + id + " not found!"))
        );
    }
}