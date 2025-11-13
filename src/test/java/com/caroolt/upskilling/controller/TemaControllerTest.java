package com.caroolt.upskilling.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TemaController.class)
class TemaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getInfo_deveRetornarInformacoesDoTema() throws Exception {
        mockMvc.perform(get("/info"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tema").value("Plataformas de upskilling e reskilling baseadas em IA"))
                .andExpect(jsonPath("$.membro1").value("Carolina Teixeira - RM: 97643"))
                .andExpect(jsonPath("$.membro2").value("Daniel Marin - RM: 551738"))
                .andExpect(jsonPath("$.descricao").exists());
    }

    @Test
    void getInfo_deveRetornarJsonComTodasAsChaves() throws Exception {
        mockMvc.perform(get("/info"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tema").exists())
                .andExpect(jsonPath("$.membro1").exists())
                .andExpect(jsonPath("$.membro2").exists())
                .andExpect(jsonPath("$.descricao").exists());
    }

    @Test
    void getInfo_descricaoNaoDeveEstarVazia() throws Exception {
        mockMvc.perform(get("/info"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.descricao").isNotEmpty());
    }
}

