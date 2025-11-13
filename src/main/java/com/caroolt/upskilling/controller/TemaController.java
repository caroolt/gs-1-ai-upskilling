package com.caroolt.upskilling.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.HashMap;
import java.util.Map;

@RestController
@Tag(name = "Tema", description = "Endpoint com informações do tema do projeto")
public class TemaController {

    @GetMapping("/info")
    @Operation(summary = "Retorna informações sobre o tema do projeto", 
               description = "Endpoint que retorna o tema escolhido, membros do grupo e descrição detalhada")
    public Map<String, String> getInfo() {
        Map<String, String> info = new HashMap<>();
        info.put("tema", "Plataformas de upskilling e reskilling baseadas em IA");
        info.put("membro1", "Carolina Teixeira - RM: 97643");
        info.put("membro2", "Daniel Marin - RM: 551738");
        info.put("descricao", "Esta plataforma utiliza Inteligência Artificial para identificar gaps de competências " +
                "e recomendar trilhas de aprendizado personalizadas. O sistema analisa o perfil profissional do usuário, " +
                "suas habilidades atuais e objetivos de carreira para sugerir cursos, treinamentos e certificações " +
                "alinhados com as demandas do mercado de trabalho. Através de machine learning, a plataforma adapta " +
                "continuamente as recomendações baseadas no progresso do usuário e nas tendências emergentes do setor, " +
                "promovendo o desenvolvimento contínuo de habilidades técnicas e comportamentais essenciais para o " +
                "futuro do trabalho.");
        return info;
    }
}

