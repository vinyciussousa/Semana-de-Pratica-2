package br.com.prog3.semana_de_pratica_2.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name="carro")
@Table(name="Carro")
public class Carro implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="placa", nullable=false)
	private String placa;
	@Basic
	@Column(name = "cor")
	private String cor;
	@Basic
	@Column(name = "ano")
	private Integer ano;
	@Basic
	@Column(name = "anoModelo")
	private Integer anoModelo;
	@Basic
	@Column(name = "marca")
	private String marca;
	@Basic
	@Column(name = "modelo")
	private String modelo;
	
	@JsonBackReference
    @ManyToOne
    @JoinColumn(name = "oficina_codigo")
	private Oficina oficina_codigo;
	
	@JsonBackReference
    @ManyToOne
    @JoinColumn(name = "cliente_cpf")
	private Cliente cliente_cpf;
	
	
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public Integer getAnoModelo() {
		return anoModelo;
	}
	public void setAnoModelo(Integer anoModelo) {
		this.anoModelo = anoModelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Cliente getCliente_cpf() {
		return cliente_cpf;
	}
	public void setCliente_cpf(Cliente cliente_cpf) {
		this.cliente_cpf = cliente_cpf;
	}
	public Oficina getOficina_codigo() {
		return oficina_codigo;
	}
	public void setOficina_codigo(Oficina oficina_codigo) {
		this.oficina_codigo = oficina_codigo;
	}
	public Carro(String placa, String cor, Integer ano, Integer anoModelo, String marca, String modelo,
			Cliente cliente_cpf, Oficina oficina_codigo) {
		super();
		this.placa = placa;
		this.cor = cor;
		this.ano = ano;
		this.anoModelo = anoModelo;
		this.marca = marca;
		this.modelo = modelo;
		this.cliente_cpf = cliente_cpf;
		this.oficina_codigo = oficina_codigo;
	}
	public Carro(String placa, String cor, Integer ano, Integer anoModelo, String marca, String modelo) {
		super();
		this.placa = placa;
		this.cor = cor;
		this.ano = ano;
		this.anoModelo = anoModelo;
		this.marca = marca;
		this.modelo = modelo;
	}
	public Carro(String placa, String cor, Integer ano, Integer anoModelo, String marca, String modelo,
			Cliente cliente_cpf) {
		this.placa = placa;
		this.cor = cor;
		this.ano = ano;
		this.anoModelo = anoModelo;
		this.marca = marca;
		this.modelo = modelo;
		this.cliente_cpf = cliente_cpf;
	}
	public Carro(String placa, String cor, Integer ano, Integer anoModelo, String marca, String modelo,
			Oficina oficina_codigo) {
		this.placa = placa;
		this.cor = cor;
		this.ano = ano;
		this.anoModelo = anoModelo;
		this.marca = marca;
		this.modelo = modelo;
		this.oficina_codigo = oficina_codigo;
	}
	public Carro(String placa) {
		this.placa = placa;
	}
	public Carro() {
	}
	@Override
	public String toString() {
		return "Carro [placa=" + placa + ", cor=" + cor + ", ano=" + ano + ", anoModelo=" + anoModelo + ", marca="
				+ marca + ", modelo=" + modelo + ", cliente_cpf=" + cliente_cpf + ", oficina_codigo=" + oficina_codigo
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(ano, anoModelo, cliente_cpf, cor, marca, modelo, oficina_codigo, placa);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		return Objects.equals(ano, other.ano) && Objects.equals(anoModelo, other.anoModelo)
				&& Objects.equals(cliente_cpf, other.cliente_cpf) && Objects.equals(cor, other.cor)
				&& Objects.equals(marca, other.marca) && Objects.equals(modelo, other.modelo)
				&& Objects.equals(oficina_codigo, other.oficina_codigo) && Objects.equals(placa, other.placa);
	}
	
	
}
