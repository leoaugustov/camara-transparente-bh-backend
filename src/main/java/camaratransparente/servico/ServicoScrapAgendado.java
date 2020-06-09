package camaratransparente.servico;

import java.io.IOException;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class ServicoScrapAgendado {

	private static final String TODO_DIA_AS_DUAS_E_QUINZE_DA_MANHA = "0 15 2 ? * TUE";
	
	private final ServicoScrap servicoScrap;
	
	
	
//	@Scheduled(cron = TODO_DIA_AS_DUAS_E_QUINZE_DA_MANHA)
	private void realizarScrap() {
		try {
			servicoScrap.realizarScrap();
			log.info("Scrap agendado realizado com sucesso!");
		}catch(IOException | InterruptedException e) {
			log.error("Problema ao realizar o scrap agendado.", e);
		}
	}
	
}
