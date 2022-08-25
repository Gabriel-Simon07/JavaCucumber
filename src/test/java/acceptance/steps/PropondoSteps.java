package acceptance.steps;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class PropondoSteps {
	
	private Lance lance;
	private Leilao leilao;
	
	@Dado("um lance valido")
	public void um_lance_valido( ) {
		Usuario usuario = new Usuario("fulano");
		lance = new Lance(usuario, BigDecimal.TEN);
	}
	
	@Quando("propoe o lance")
	public void propoe_o_lance() {
		leilao = new Leilao("Tablet");
		leilao.propoe(lance);
	}
	
	@Entao("o lance eh aceito")
	public void o_lance_eh_aceito() {
		assertEquals(1, leilao.getLances().size());
		assertEquals(BigDecimal.TEN, leilao.getLances().get(0).getValor());
	}
}
