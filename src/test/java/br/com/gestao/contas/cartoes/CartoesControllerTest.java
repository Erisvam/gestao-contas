package br.com.gestao.contas.cartoes;

import br.com.gestao.contas.cartoes.dto.CartaoDTO;
import br.com.gestao.contas.cartoes.repository.CartaoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CartoesControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CartaoRepository cartaoRepository;

    @Test
    public void deveCadastrarCartao(){
        CartaoDTO cartaoNubank = CartaoDTO
                .builder()
                .codigo("8232")
                .nome("Nubank")
                .dataFechamento("03-25")
                .dataVencimento("04-05")
                .funcionalidade("credito")
                .build();

        ResponseEntity<Void> cadastroResponse = restTemplate.postForEntity("/cartoes",cartaoNubank, Void.class);

        assertThat(cadastroResponse.getStatusCode().value()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(cadastroResponse.getHeaders().getLocation().getPath()).isEqualTo("/cartoes/".concat(cartaoNubank.getCodigo()));
    }


    @Test
    public void deveConsultarCartao(){
        ResponseEntity<CartaoDTO> consultaCartaoResponse = restTemplate.getForEntity("/cartoes/1234", CartaoDTO.class);
        assertThat(consultaCartaoResponse.getStatusCode().value()).isEqualTo(HttpStatus.OK.value());
    }
}
