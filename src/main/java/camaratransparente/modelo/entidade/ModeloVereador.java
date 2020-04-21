package camaratransparente.modelo.entidade;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "vereador")
public class ModeloVereador extends EntidadeBase {

	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String nomeCivil;
	
	@Column(nullable = false)
	private String linkFoto;
	
	@Column(nullable = false)
	private String partido;
	
	@Column
	private String email;
	
	@OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "vereador")
	@Setter(AccessLevel.NONE)
	private List<ModeloMandato> mandatos = new ArrayList<>();

	@OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "vereador")
	@Setter(AccessLevel.NONE)
	private List<ModeloCusteioParlamentar> custeios = new ArrayList<>();
	
	@OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "vereador")
	@Setter(AccessLevel.NONE)
	private List<ModeloPresencaReuniao> presencasReunioes = new ArrayList<>();
	
	
	
	public void adicionarCusteio(ModeloCusteioParlamentar custeio) {
		custeio.setVereador(this);
		custeios.add(custeio);
	}
	
	public void adicionarPresencaReuniao(ModeloPresencaReuniao presenca) {
		presenca.setVereador(this);
		presencasReunioes.add(presenca);
	}
	
	public void adicionarMandatos(List<ModeloMandato> mandatos) {
		mandatos.forEach(mandato -> {
			mandato.setVereador(this);
			this.mandatos.add(mandato);
		});
		this.mandatos.addAll(mandatos);
	}
	
	/**
	 * Calcula a maior data de referência dentre todos os custeios do vereador.
	 * @return a maior data de referência dentre todos os custeios
	 */
	public Optional<YearMonth> getMaiorDataReferenciaCusteio() {
		return custeios.stream()
				.map(ModeloCusteioParlamentar::getDataReferencia)
				.max(YearMonth::compareTo);
	}

	/**
	 * Calcula a maior data do exercício dentre todas as informações de presenca do vereador. 
	 * @return a maior data do exercício dentre todas as informações de presenca
	 */
	public Optional<YearMonth> getMaiorDataExercicioPresenca() {
		return presencasReunioes.stream()
				.map(ModeloPresencaReuniao::getDataReuniao)
				.map(YearMonth::from)
				.max(YearMonth::compareTo);
	}

	@Override
	public String toString() {
		return "ModeloVereador [" + nome + "]";
	}
	
}
