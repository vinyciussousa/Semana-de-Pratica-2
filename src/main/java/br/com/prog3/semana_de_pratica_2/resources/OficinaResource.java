package br.com.prog3.semana_de_pratica_2.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.prog3.semana_de_pratica_2.domain.Oficina;
import br.com.prog3.semana_de_pratica_2.service.OficinaService;

@RestController
@RequestMapping("/api/v1/oficinas")
public class OficinaResource {
	@Autowired
	private OficinaService oficinaService;
	
	@PostMapping
    public Oficina save(@RequestBody Oficina oficina) {
        return oficinaService.save(oficina);
    }

    @GetMapping
    public ResponseEntity<List<Oficina>> findAll() {
        List<Oficina> cursos = oficinaService.findAll();
        if (cursos == null || cursos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cursos, HttpStatus.OK);
    }

    @GetMapping(path = {"/{codigo}"})
    public Optional<Oficina> findById(@PathVariable("codigo") Integer codigo) {
        return oficinaService.findById(codigo);
    }

    @PutMapping(value = "/{codigo}")
    public Oficina update(@PathVariable("codigo") Integer codigo, @RequestBody Oficina oficina) {
        Optional<Oficina> optional = oficinaService.findById(codigo);
        if (optional.isPresent()) {
            Oficina c = optional.get();
            c.setNome(oficina.getNome());
            c.setEspecialidade(oficina.getEspecialidade());
            c.setEndereco(oficina.getEndereco());
            oficinaService.update(c);
            return c;
        } else {
            throw new RuntimeException("ERRO: Não foi possível alterar registro");
        }
    }

    @DeleteMapping(path = {"/{codigo}"})
    public void delete(@PathVariable("codigo") Integer codigo) {
        oficinaService.deleteById(codigo);
    }
}
