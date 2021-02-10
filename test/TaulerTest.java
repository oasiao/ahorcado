package test;

import com.jaume.penjat.Tauler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaulerTest {

    private Tauler tauler;

    @BeforeEach
    void reiniciar() {
        this.tauler = new Tauler();
        this.tauler.inicialitzarPartida("paraula", 4);
    }

    @Test
    void inicialitzarPartidaParaulaSecreta() {
        Assertions.assertArrayEquals(new char[]{'p', 'a', 'r', 'a', 'u', 'l', 'a'}, this.tauler.getParaulaSecreta());
    }

    @Test
    void inicialitzarPartidaNombreIntents() {
        Assertions.assertEquals(4, this.tauler.getVides());
    }

    @Test
    void verificarEntradaIncorrecte() { Assertions.assertEquals("Lletra incorrecta", this.tauler.verificar("ll"));
    }

    @Test
    void verificarEntradaCorrecteEncertat() {
        this.tauler.verificar("a");
        Assertions.assertArrayEquals(new String[]{null, "a", null, "a", null, null, "a"}, this.tauler.getPalabraEndevinada());
    }

    @Test
    void verificarEntradaCorrecteErrada() {
        this.tauler.verificar("n");
        Assertions.assertEquals(3, this.tauler.getVides());
    }

    @Test
    void imprimirCapEncert() {
        Assertions.assertEquals("_______", this.tauler.imprimir());
    }

    @Test
    void imprimirAmbLletres() {
        this.tauler.verificar("a");
        Assertions.assertEquals("_a_a__a", this.tauler.imprimir());
    }

    @Test
    void imprimirTotEncertat() {
        this.tauler.verificar("a");
        this.tauler.verificar("p");
        this.tauler.verificar("r");
        this.tauler.verificar("u");
        this.tauler.verificar("l");
        Assertions.assertEquals("paraula", this.tauler.imprimir());
    }


    @Test
    void imprimirVidesPlural() {
        Assertions.assertEquals("Et queden 4 vides de 4", this.tauler.imprimirVides());
    }

    @Test
    void imprimirVidesSingular() {
        this.tauler.verificar("n");
        this.tauler.verificar("n");
        this.tauler.verificar("n");
        Assertions.assertEquals("Et queda 1 vida de 4", this.tauler.imprimirVides());
    }

    @Test
    void restarIntents() {
        this.tauler.verificar("n");
        Assertions.assertEquals(3, this.tauler.getVides());
    }

    @Test
    void hasGuanyatTrue() {
        this.tauler.verificar("a");
        this.tauler.verificar("p");
        this.tauler.verificar("r");
        this.tauler.verificar("u");
        this.tauler.verificar("l");
        Assertions.assertTrue(this.tauler.hasGuanyat());
    }

    @Test
    void hasGuanyatFalse() {
        Assertions.assertFalse(this.tauler.hasGuanyat());
    }

}