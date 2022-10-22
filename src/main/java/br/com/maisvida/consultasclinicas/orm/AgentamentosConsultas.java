package br.com.maisvida.consultasclinicas.orm;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AGENDAMENTOSCONSULTAS")
public class AgentamentosConsultas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String rg;
	private String telefone;
	private LocalDate dataNascimento;
	private LocalDate dataDaConsulta;
	private LocalTime horaDaConsulta;
	private Especialista especialista;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public LocalDate getDataDaConsulta() {
		return dataDaConsulta;
	}

	public void setDataDaConsulta(LocalDate dataDaConsulta) {
		this.dataDaConsulta = dataDaConsulta;
	}

	public LocalTime getHoraDaConsulta() {
		return horaDaConsulta;
	}

	public void setHoraDaConsulta(LocalTime horaDaConsulta) {
		this.horaDaConsulta = horaDaConsulta;
	}

	public Especialista getEspecialista() {
		return especialista;
	}

	public void setEspecialista(Especialista especialista) {
		this.especialista = especialista;
	}

	@Override
	public String toString() {
		return "AgentamentosConsultas [id=" + id + ", nome=" + nome + ", rg=" + rg + ", telefone=" + telefone
				+ ", dataNascimento=" + dataNascimento + ", dataDaConsulta=" + dataDaConsulta + ", horaDaConsulta="
				+ horaDaConsulta + ", especialista=" + especialista + "]";
	}

}
