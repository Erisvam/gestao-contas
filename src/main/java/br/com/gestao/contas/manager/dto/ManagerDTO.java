package br.com.gestao.contas.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ManagerDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = -3591321078374761373L;

    @JsonProperty("id")
    private Long id;

    @JsonProperty("nome")
    private String nome;
}
