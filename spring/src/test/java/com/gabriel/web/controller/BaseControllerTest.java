package com.gabriel.web.controller;

import com.gabriel.web.config.DataConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.persistence.EntityManager;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class BaseControllerTest {

    String url = "/api/v1/data";
    @Autowired
    private MockMvc mvc;
    
    @Autowired
    private DataConfig dataConfig;

    @Autowired
    private EntityManager entityManager;

    @Test
    void getColumnsShouldReturn200() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(dataConfig.getColumns().toString()))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void getUniqueRowsShouldReturn200() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get(url + "/{type}/{columName}", "UNIQUE", "kolumna1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(entityManager.createNativeQuery("select distinct * from tabela_testowa A where (select count(*) from tabela_testowa B where A.kolumna1 = B.kolumna2)<2").getResultList().toString()))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void getRowsShouldReturn422AsWrongOperationType() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get(url + "/{type}/{columName}", "s", "kolumna1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andReturn();
    }

    @Test
    void getRowsShouldReturn422AsNotExistingColumnName() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get(url + "/{type}/{columName}", "UNIQUE", "kolumna")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andReturn();
    }

}