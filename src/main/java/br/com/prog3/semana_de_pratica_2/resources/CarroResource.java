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

import br.com.prog3.semana_de_pratica_2.domain.Carro;
import br.com.prog3.semana_de_pratica_2.service.CarroService;

@RestController
@RequestMapping("/api/v1/carros")
public class CarroResource {
	@Autowired
	private CarroService carroService;
	
	@PostMapping
    public Carro save(@RequestBody Carro carro) {
        return carroService.save(carro);
    }
	
	@GetMapping
	public List<Carro> findAll(){
		return carroService.findAll();
	}
	
	@GetMapping(path= {"/{placa}"})
	public Optional<Carro> findById(@PathVariable("placa") String placa){
		return carroService.findById(placa);
	}
	
	@PutMapping(value = "/{placa}")
    public Carro update(@PathVariable("placa") String placa, @RequestBody Carro carro) {
        Optional<Carro> optional = carroService.findById(placa);
        if (optional.isPresent()) {
            Carro c = optional.get();
            c.setCor(carro.getCor());
            c.setAno(carro.getAno());
            c.setAnoModelo(carro.getAnoModelo());
            c.setMarca(carro.getMarca());
            c.setModelo(carro.getModelo());
            carroService.update(c);
            return c;
        } else {
            throw new RuntimeException("ERRO: Não foi possível alterar os registro");
        }
    }

    @DeleteMapping(path = {"/{placa}"})
    public void delete(@PathVariable("placa") String placa) { carroService.deleteById(placa); }
}