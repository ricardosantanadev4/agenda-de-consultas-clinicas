package br.com.maisvida.consultasclinicas.orm;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AGENDAMENTOSCONSULTAS")
public class AgendamentosConsultas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "NOME")
	private String nome;
	@Column(name = "RG")
	private String rg;
	@Column(name = "TELEFONE")
	private String telefone;
	@Column(name = "DATA_DE_MASCIMENTO")
	private LocalDate dataNascimento;
	@Column(name = "CODIGO_ESPECIALISTA")
	private Long codigoEspecialista;

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

	public Long getCodigoEspecialista() {
		return codigoEspecialista;
	}

	public void setCodigoEspecialista(Long codigoEspecialista) {
		this.codigoEspecialista = codigoEspecialista;
	}

	@Override
	public String toString() {
		return "AgendamentosConsultas [id=" + id + ", nome=" + nome + ", rg=" + rg + ", telefone=" + telefone
				+ ", dataNascimento=" + dataNascimento + ", codigoEspecialista=" + codigoEspecialista + "]";
	}

}
