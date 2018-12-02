package br.com.vwapp.testes;

import br.com.vwapp.poo.banco.Conta;
import br.com.vwapp.poo.banco.ContaBB;
import br.com.vwapp.poo.banco.ContaITAU;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ContaTest {

    ContaBB contaBB;
    ContaITAU contaITAU;

    @Before
    public void setUp() {
        contaBB = new ContaBB(10_000.0, "admin");
        contaITAU = new ContaITAU(5_320.0, "test");
    }

    @Test
    public void testSacar() {
        assertEquals(10_000.0, contaBB.getSaldo(), 0.0001);

        contaBB.saca(100);

        assertEquals(9_900.0, contaBB.getSaldo(), 0.0001);
    }

    @Test
    public void testDepositar() {
        assertEquals(10_000.0, contaBB.getSaldo() ,0.0001);

        contaBB.deposita(100);

        assertEquals(10_100.0, contaBB.getSaldo(), 0.0001);
    }

    @Test
    public void testTransferencia() {
        assertEquals(10_000.0, contaBB.getSaldo() ,0.0001);
        assertEquals(5_320.0, contaITAU.getSaldo() ,0.0001);

        contaBB.transferePara(contaITAU, 100);

        assertEquals(9_860.0, contaBB.getSaldo(), 0.0001);
        assertEquals(5_420.0, contaITAU.getSaldo(), 0.0001);
    }
}
