package br.edu.ifpb;

import br.edu.ifpb.persistencia.api.Banco;
import org.junit.Assert;
import org.junit.Test;

public class ContaTest {
    @Test

    public void ContasInvalidas()
    {
        Banco b = new Banco();
        Assert.assertFalse(b.cadastrarConta(-123, "alguem", 500));
        Assert.assertFalse(b.cadastrarConta(23, "alguem", -234));
        Assert.assertFalse(b.cadastrarConta(0, "alguem", 90));
        Assert.assertFalse(b.cadastrarConta(32, null, 500));
    }

}
