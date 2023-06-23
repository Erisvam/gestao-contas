package br.com.gestao.contas.pessoas;

import br.com.gestao.contas.pessoas.dto.PessoaDTO;
import br.com.gestao.contas.pessoas.repository.PessoaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PessoasControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Test
    public void deveCadastrarPessoas(){
        PessoaDTO pessoa = new PessoaDTO()
                .builder()
                .nome("Helen")
                .telefone("11992594680")
                .build();

        ResponseEntity<Void> postResponse = restTemplate.postForEntity("/pessoas", pessoa, Void.class);
        assertThat(postResponse.getStatusCode().value()).isEqualTo(HttpStatus.CREATED.value());
    }

    @Test
    public void deveConsultarPessoa(){
        ResponseEntity<PessoaDTO> pessoaResponse = restTemplate.getForEntity("/pessoas/1", PessoaDTO.class);
        assertThat(pessoaResponse.getStatusCode().value()).isEqualTo(HttpStatus.OK.value());
        assertThat(pessoaResponse.getBody().getNome()).isEqualTo("Helen");
    }

    @Test
    public void deveEditarPessoa(){
        ResponseEntity<PessoaDTO> getPessoa = restTemplate.getForEntity("/pessoas/1", PessoaDTO.class);
        getPessoa.getBody().setNome("Helen Silva");
        getPessoa.getBody().setTelefone("11992594680");

        restTemplate.put("/pessoas/1", getPessoa);

        assertThat(getPessoa.getBody().getNome()).isEqualTo("Helen Silva");
    }

    @Test
    public void deveDeletarPessoa(){
        restTemplate.delete("/pessoas/1");

        ResponseEntity<PessoaDTO> getResponse = restTemplate.getForEntity("/pessoas/1", PessoaDTO.class);
        assertThat(getResponse.getStatusCode().value()).isEqualTo(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void deveConsultarPessoas(){
        ResponseEntity<List> pessoasResponse = restTemplate.getForEntity("/pessoas", List.class);
        assertThat(pessoasResponse.getStatusCode().value()).isEqualTo(HttpStatus.OK.value());
    }
}
