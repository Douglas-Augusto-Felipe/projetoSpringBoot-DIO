package dio.projetoSpringBootDIO.service.impl;

import dio.projetoSpringBootDIO.model.Cliente;
import dio.projetoSpringBootDIO.model.ClienteRepository;
import dio.projetoSpringBootDIO.model.Endereco;
import dio.projetoSpringBootDIO.model.EnderecoRepository;
import dio.projetoSpringBootDIO.service.ClienteService;
import dio.projetoSpringBootDIO.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementação da <b>Strategy</b>{@link ClienteService}, a qual pode ser
 * injetada pelo Spring (via {@link Autowired}). com isso, como essa classe é um
 * ({@link Service}, ela será tratada como um <b>Singleton</b>.
 *
 * @author Douglas
 */
@Service
public class ClienteServiceImpl implements ClienteService {
    //TODO Singleton: Injetar os componentes do Spring com @Autowired.
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;
    //TODO Strategy: Implementar métodos definidos na interface.
    //TODO Facade: Abstrair integrações com subsistemas, provendo uma interface simples.
    @Override
    public Iterable<Cliente> buscarTodos() {
        //FIXME Buscar todos os Clientes.
        return clienteRepository.findAll();
    }
    @Override
    public Cliente buscarporID(Long id) {
        //FIXME Buscar Cliente por ID.
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }
    @Override
    public void inserir(Cliente cliente) {
        //FIXME Verificar se o endereco do cliente ja existe(pelo CEP).
        //FIXME Caso não exista, integrar com o ViaCEP e persistir o retorno.
        //FIXME Inserir Cliente, vinculando o Endereco (novo ou existente).
        salvarClienteComCep(cliente);
    }
    @Override
    public void atualizar(Long id, Cliente cliente) {
        //FIXME Buscar Cliente por ID, caso exista:
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if (clienteBd.isPresent()) {
            //FIXME Verificar se o Endereco do Cliente ja existe (pelo CEP)
            //FIXME Caso não exista, integrar com o ViaCEP e persistir o retorno.
            //FIXME Alterar Cliente, vinculando o Endereco (novo ou Existente).
            salvarClienteComCep(cliente);
        }
    }
    @Override
    public void deletar(Long id) {
        //FIXME Deletar Cliente por ID.
        clienteRepository.deleteById(id);
    }
    private void salvarClienteComCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }
}

