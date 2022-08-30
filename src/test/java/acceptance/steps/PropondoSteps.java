package acceptance.steps;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class PropondoSteps {

	private Lance lance;
	private Leilao leilao;
	private ArrayList<Lance> lista;

	@Before
	public void setup() {
		this.lista = new ArrayList<Lance>();
		leilao = new Leilao("Tablet");
	}
	
	@Dado("um lance valido")
	public void um_lance_valido() {
		Usuario usuario = new Usuario("fulano");
		lance = new Lance(usuario, BigDecimal.TEN);
		leilao = new Leilao("Tablet");
	}

	@Quando("propoe o lance")
	public void propoe_o_lance() {
		leilao.propoe(lance);
	}

	@Entao("o lance eh aceito")
	public void o_lance_eh_aceito() {
		assertEquals(1, leilao.getLances().size());
		assertEquals(BigDecimal.TEN, leilao.getLances().get(0).getValor());
	}

	@Quando("propoe ao leilao")
	public void propoe_ao_leilao() {
		leilao.propoe(lance);
	}

	@Então("o lances sao aceitos")
	public void o_lances_sao_aceitos() {
		assertEquals(BigDecimal.TEN, leilao.getLances().get(0).getValor());
		assertEquals(new BigDecimal("15.0"), leilao.getLances().get(1).getValor());
	}
	
	@Dado("um lance de {double} reais do usuario {string}")
	public void um_lance_de_reais_do_usuario(Double double1, String string) {
		Lance lance = new Lance(new Usuario(string), new BigDecimal(double1));
		lista.add(lance);
	}

	@Quando("quando propoe varios lances ao leilao")
	public void quando_propoe_varios_lances_ao_leilao() {
		this.lista.forEach(lanceNovo -> leilao.propoe(lance));
	}
	
	@Dado("um lanche valido")
	public void um_lanche_valido() {
		assertEquals(this.lista.size(), leilao.getLances().size());
	}
}
