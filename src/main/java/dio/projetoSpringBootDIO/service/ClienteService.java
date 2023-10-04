package dio.projetoSpringBootDIO.service;

import dio.projetoSpringBootDIO.model.Cliente;

/**
 *Interface que define o padrão <b>Strategy</b> no domínio do cliente. com
 * isso, se necessário, podemos ter multiplas implementações dessa mesma
 * interface
 *
 * @author  Douglas
 */
public interface ClienteService {
    Iterable<Cliente> buscarTodos();
    Cliente buscarporID(Long id);
    void inserir (Cliente cliente);
    void  atualizar(Long id, Cliente cliente);
    void deletar(Long id);
}
