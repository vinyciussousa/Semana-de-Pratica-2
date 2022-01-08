package br.com.prog3.semana_de_pratica_2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prog3.semana_de_pratica_2.domain.Cliente;
import br.com.prog3.semana_de_pratica_2.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteRepository.findAll();
	}
	
	public Optional<Cliente> findById(String id) {
		return clienteRepository.findById(id);
	}
	
	public Cliente update(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public void deleteById(String id) {
		clienteRepository.deleteById(id);
	}
}
