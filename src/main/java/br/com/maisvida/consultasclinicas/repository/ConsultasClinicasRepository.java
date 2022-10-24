package br.com.maisvida.consultasclinicas.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.maisvida.consultasclinicas.orm.AgendamentosConsultas;

public interface ConsultasClinicasRepository extends CrudRepository<AgendamentosConsultas, Long> {

}
