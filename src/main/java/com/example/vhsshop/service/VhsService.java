package com.example.vhsshop.service;

import com.example.vhsshop.mapper.dto.VhsDto;
import java.util.List;

public interface VhsService {
    List<VhsDto> getVhs();
    VhsDto getVhsById(Long id);
}