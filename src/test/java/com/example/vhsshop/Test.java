package com.example.vhsshop;


import com.example.vhsshop.controller.VhsController;
import com.example.vhsshop.mapper.MapStructMapper;
import com.example.vhsshop.mapper.dto.VhsDto;
import com.example.vhsshop.model.Vhs;
import com.example.vhsshop.repository.RentalRepository;
import com.example.vhsshop.service.impl.VhsServiceImpl;
import org.assertj.core.api.Assert;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
@WebMvcTest(VhsController.class)
public class Test {

    @Autowired
    private MapStructMapper mapper;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private RestTemplate restTemplate;

    @MockBean
    private VhsServiceImpl vhsService;

    @org.junit.jupiter.api.Test
    public void testExample(){
        Vhs vhs = new Vhs();
        Mockito.when(restTemplate
        .getForEntity("http://localhost:8080/api/vhs/1",Vhs.class)).thenReturn(new ResponseEntity<Vhs>(vhs, HttpStatus.OK));

        VhsDto vhsDto = vhsService.getVhsById(1L);
        Vhs vhsNew = mapper.vhsDtoToVhs(vhsDto);

        org.junit.jupiter.api.Assertions.assertNotEquals(vhs, vhsNew);
    }
}
