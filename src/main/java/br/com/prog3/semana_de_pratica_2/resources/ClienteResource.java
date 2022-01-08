package br.com.prog3.semana_de_pratica_2.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.prog3.semana_de_pratica_2.domain.Cliente;
import br.com.prog3.semana_de_pratica_2.service.ClienteService;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteResource {
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
    public Cliente save(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    @GetMapping
    public List<Cliente> findAll() {
        return clienteService.findAll();
    }

    @GetMapping(path = {"/{cpf}"})
    public Optional<Cliente> findById(@PathVariable("cpf") String cpf) {
        return clienteService.findById(cpf);
    }

    @PutMapping(value = "/{cpf}")
    public Cliente update(@PathVariable("cpf") String cpf, @RequestBody Cliente cliente) {
        Optional<Cliente> optional = clienteService.findById(cpf);
        if (optional.isPresent()) {
            Cliente c = optional.get();
            c.setNome(cliente.getNome());
            c.setDataNascimento(cliente.getDataNascimento());
            clienteService.update(c);
            return c;
        } else {
            throw new RuntimeException("ERRO: Não foi possível alterar registro");
        }
    }

    @DeleteMapping(path = {"/{cpf}"})
    public void delete(@PathVariable("cpf") String cpf) {
        clienteService.deleteById(cpf);
    }
}
