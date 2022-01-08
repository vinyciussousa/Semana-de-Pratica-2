package br.com.prog3.semana_de_pratica_2.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name="oficina")
@Table(name="Oficina")
public class Oficina implements Serializable{
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="codigo", nullable=false)
	private Integer codigo;
	@Basic
	@Column(name = "nome")
	private String nome;
	@Basic
	@Column(name = "especialidade")
	private String especialidade;
	@Basic
	@Column(name = "endereco")
	private String endereco;
	
	@JsonManagedReference
	@OneToMany(mappedBy="oficina_codigo")
	private List<Carro> carros = new ArrayList<>();
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public List<Carro> getCarros() {
		return carros;
	}
	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}
	public Oficina(Integer codigo, String nome, String especialidade, String endereco, List<Carro> carros) {
		this.codigo = codigo;
		this.nome = nome;
		this.especialidade = especialidade;
		this.endereco = endereco;
		this.carros = carros;
	}
	public Oficina(Integer codigo, String nome, String especialidade, String endereco) {
		this.codigo = codigo;
		this.nome = nome;
		this.especialidade = especialidade;
		this.endereco = endereco;
	}
	public Oficina(Integer codigo) {
		this.codigo = codigo;
	}
	public Oficina() {
	}
	@Override
	public String toString() {
		return "Oficina [codigo=" + codigo + ", nome=" + nome + ", especialidade=" + especialidade + ", endereco="
				+ endereco + ", carros=" + carros + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(carros, codigo, endereco, especialidade, nome);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Oficina other = (Oficina) obj;
		return Objects.equals(carros, other.carros) && Objects.equals(codigo, other.codigo)
				&& Objects.equals(endereco, other.endereco) && Objects.equals(especialidade, other.especialidade)
				&& Objects.equals(nome, other.nome);
	}
	
	
}
