package dataFactory;

import pojo.componentePojo;
import pojo.produtoPojo;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDataFactory {
    public static produtoPojo criarProdutoComumComOValorIgualA(double valor){

        produtoPojo produto = new produtoPojo();
        produto.setProdutoNome("PlayStation 5");
        produto.setProdutoValor(valor);
        List<String> cores = new ArrayList<>();
        cores.add("Branco");
        cores.add("Preto");
        produto.setProdutoCores(cores);
        produto.setProdutoUrlMock("");


        List<componentePojo> componentes = new ArrayList<>();
        componentePojo componente = new componentePojo();
        componente.setComponenteNome("Controle");
        componente.setComponenteQuantidade(1);

        componentes.add(componente);

        produto.setComponentes(componentes);
        return produto;
    }
}
