package br.com.maisvida.consultasclinicas;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.maisvida.consultasclinicas.services.CrudAgendamentosConsultasService;

@EnableJpaRepositories
@SpringBootApplication
public class ConsultasClinicasApplication implements CommandLineRunner {
	private Boolean system = true;
	private final CrudAgendamentosConsultasService crudAgendamentos;
	
	public ConsultasClinicasApplication(CrudAgendamentosConsultasService crudAgendamentos) {
		this.crudAgendamentos = crudAgendamentos;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ConsultasClinicasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		while (system) {
			System.out.println("0 - Sair");
			System.out.println("1 - Agendar um consulta");
			Integer function = scanner.nextInt();
			switch (function) {
			case 1:
				crudAgendamentos.begin();
				break;
			default:
				system = false;
				System.out.println("Saindo ...");
				break;
			}
		}
	}

}
