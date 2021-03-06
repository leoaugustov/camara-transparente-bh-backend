package camaratransparente.modelo.dto;

import java.util.UUID;

import camaratransparente.modelo.EstatisticasPresencasReunioes;
import camaratransparente.modelo.entidade.ModeloVereador;
import lombok.Getter;

@Getter
public class ModeloVereadorDto {

	private final UUID id;
	private final String nome;
	private final String linkFoto;
	private final String partido;
	private final String perfilCmbh;
	private final double maiorCusteioMensal;
	private final double custeioTotal;
	private final EstatisticasPresencasReunioes estatisticasPresencas;
	
	
	
	public ModeloVereadorDto(ModeloVereador vereador, String linkFoto, EstatisticasPresencasReunioes estatisticasPresencas) {
		id = vereador.getUuid();
		nome = vereador.getNome();
		this.linkFoto = linkFoto;
		partido = vereador.getSiglaPartido();
		this.perfilCmbh = vereador.getPerfilCmbh();
		maiorCusteioMensal = vereador.getMaiorCusteioMensal();
		custeioTotal = vereador.getCusteioTotal();
		this.estatisticasPresencas = estatisticasPresencas;
	}
	
}
