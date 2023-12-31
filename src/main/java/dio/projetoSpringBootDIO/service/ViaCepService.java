package dio.projetoSpringBootDIO.service;

import dio.projetoSpringBootDIO.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Clinte HTTP, criado via <b>OpenFeign</b>, para consumo da API do
 * <b>ViaCEP</b>.
 *
 * @see <a href = "https://spring.io/projects/spring-cloud-openfeign">Spring Cloud OpenFeign</a>
 * @see  <a href = "https://viacep.com.br">ViaCEP</a>
 *
 * @author Douglas
 */
@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {
    @RequestMapping(method = RequestMethod.GET, value = "/{cep}/json/")
    Endereco consultarCep(@PathVariable("cep")String cep);

    //Outra forma de escrever
//    @GetMapping("/{cep}/json/")
//    Endereco consultarCep(@PathVariable("cep")String cep);
}
