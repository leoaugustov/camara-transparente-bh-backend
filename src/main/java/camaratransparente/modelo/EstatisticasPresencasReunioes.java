package camaratransparente.modelo;

import java.util.List;

import camaratransparente.modelo.entidade.ModeloPresencaReuniao;
import lombok.Getter;

@Getter
public class EstatisticasPresencasReunioes {

	private double frequencia;
	private int faltas;
	private int ausenciasJustificadas;
	
	
	
	public EstatisticasPresencasReunioes(List<ModeloPresencaReuniao> presencasReunioes) {
		int presencas = 0;
		
		for(ModeloPresencaReuniao presencaReuniao : presencasReunioes) {
			switch (presencaReuniao.getStatus()) {
			case P:
				presencas++;
				break;

			case F:
				faltas++;
				break;	
				
			case LM:
			case AJ:
				ausenciasJustificadas++;
				break;		
				
			default:
				break;
			}
		}
		
		if(presencasReunioes.size() != 0) {
			frequencia = ((double) presencas / presencasReunioes.size());
		}
	}
	
}
