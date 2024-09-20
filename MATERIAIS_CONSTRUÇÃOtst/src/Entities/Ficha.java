package Entities;

import java.util.Date;

public class Ficha {
    private int numeroFichaControle;
    private String descricaoFichaControle;
    private Date dataFichaControle;
    private Compra compra;
    private Cliente cliente;
    private Produto produto;

    public Ficha() {}

    public Ficha(int numeroFichaControle, String descricaoFichaControle, Date dataFichaControle, Compra compra) {
        this.numeroFichaControle = numeroFichaControle;
        this.descricaoFichaControle = descricaoFichaControle;
        this.dataFichaControle = dataFichaControle;
        this.compra = compra;
    }

    public Ficha(int numeroFichaControle) {
      
        this.numeroFichaControle = numeroFichaControle;
    }

    public int getNumeroFichaControle() {
        return numeroFichaControle;
    }

    public void setNumeroFichaControle(int numeroFichaControle) {
        this.numeroFichaControle = numeroFichaControle;
    }

    public String getDescricaoFichaControle() {
        return descricaoFichaControle;
    }

    public void setDescricaoFichaControle(String descricaoFichaControle) {
        this.descricaoFichaControle = descricaoFichaControle;
    }

    public Date getDataFichaControle() {
        return dataFichaControle;
    }

    public void setDataFichaControle(Date dataFichaControle) {
        this.dataFichaControle = dataFichaControle;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void preencherDescricao() {
        this.descricaoFichaControle = 
                "Nome do Cliente: " + cliente.getNomeCliente() + ", CPF do Cliente: " + cliente.getCpfCliente() + ", RG do Cliente: "
                + cliente.getRgCliente() + ", Código do Produto: " + produto.getCodigoProduto()
                + ", Descrição do Produto: " + produto.getDescricaoProduto() + ", Quantidade de Produtos: " + compra.getQuantidadeProdutosCompra()
                + ", Valor Total: " + compra.getValorTotalCompra();
    }

    public void imprimirFicha() {
        System.out.println("Número da Ficha: " + numeroFichaControle);
        System.out.println("Descrição da Ficha: " + descricaoFichaControle);
        System.out.println("Data da Ficha: " + dataFichaControle);
        System.out.println("Compra ID: " + compra.getIdCompra());
        System.out.println("Cliente ID: " + cliente.getIdCliente());
        System.out.println("Produto ID: " + produto.getCodigoProduto());
        System.out.println("Detalhes: " + descricaoFichaControle);
    }
}
