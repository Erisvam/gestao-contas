package br.com.gestao.contas.cartao.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ListaCartoesDTO implements Serializable {
	private static final long serialVersionUID = 202292172096027285L;
	
	@JsonProperty("cartoes")
	private List<CartaoResponseDTO> cartoes = new ArrayList<CartaoResponseDTO>();
	
}
