package br.com.gestao.contas.dividas;

import br.com.gestao.contas.cartoes.dto.CartaoDTO;
import br.com.gestao.contas.dividas.dto.DividaDTO;
import br.com.gestao.contas.dividas.repository.DividaRepository;
import br.com.gestao.contas.dividas.viewmodel.DividaViewModel;
import br.com.gestao.contas.pessoas.dto.PessoaDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DividasControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private DividaRepository dividaRepository;

    @Test
    public void deveCadastrarDividas(){
        DividaDTO divida = new DividaDTO()
                .builder()
                .valor(new BigDecimal(10.90))
                .dataCompra(LocalDate.now())
                .descricao("chinelo")
                .status("pendente")
                .cartao(
                        new CartaoDTO()
                                .builder()
                                .codigo("2342")
                                .funcionalidade("CREDITO")
                                .nome("Santander")
                                .build())
                .pessoa(
                        new PessoaDTO()
                        .builder()
                        .codigo(3L)
                        .nome("Luiza")
                        .build())
                .build();

        ResponseEntity<DividaDTO> postDividaResponse = restTemplate.postForEntity("/dividas", divida, DividaDTO.class);
        assertThat(postDividaResponse.getStatusCode().value()).isEqualTo(HttpStatus.CREATED.value());
    }

    @Test
    public void deveConsultarDivida(){
        ResponseEntity<DividaViewModel> getDividaResponse = restTemplate.getForEntity("/dividas/5", DividaViewModel.class);
        assertThat(getDividaResponse.getStatusCode().value()).isEqualTo(HttpStatus.OK.value());
    }

}
