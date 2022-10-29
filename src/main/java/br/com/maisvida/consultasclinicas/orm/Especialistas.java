package br.com.maisvida.consultasclinicas.orm;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ESPECIALISTAS")
public class Especialistas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "NOME")
	private String nome;
	@Column(name = "ESPECIALIDADE")
	private String especialidade;
	@Column(name = "DATA_DA_CONSULTA")
	private LocalDate data_da_Consulta;
	@Column(name = "HORARIO")
	private LocalTime horario;
	@Column(name = "DIA_DA_SEMANA")
	private String diaDaSemana;

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

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public LocalDate getData_da_Consulta() {
		return data_da_Consulta;
	}

	public void setData_da_Consulta(LocalDate data_da_Consulta) {
		this.data_da_Consulta = data_da_Consulta;
	}

	public LocalTime getHorario() {
		return horario;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	public String getDiaDaSemana() {
		return diaDaSemana;
	}

	public void setDiaDaSemana(String diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
	}

	@Override
	public String toString() {
		return "Especialistas [id=" + id + ", nome=" + nome + ", especialidade=" + especialidade + ", data_da_Consulta="
				+ data_da_Consulta + ", horario=" + horario + ", diaDaSemana=" + diaDaSemana + "]";
	}

}
