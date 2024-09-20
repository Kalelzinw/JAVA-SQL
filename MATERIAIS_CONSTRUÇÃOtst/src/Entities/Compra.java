package Entities;

public class Compra {
    private int idCompra;
    private int codigoProduto;
    private int idCliente;
    private int quantidadeProdutosCompra;
    private float valorTotalCompra;
    private Produto produto;

    public Compra(int idCompra, int codigoProduto, int idCliente, int quantidadeProdutosCompra, Produto produto) {
        this.idCompra = idCompra;
        this.codigoProduto = codigoProduto;
        this.idCliente = idCliente;
        this.quantidadeProdutosCompra = quantidadeProdutosCompra;
        this.produto = produto;
        this.valorTotalCompra = calcularTotalCompra();
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getQuantidadeProdutosCompra() {
        return quantidadeProdutosCompra;
    }

    public void setQuantidadeProdutosCompra(int quantidadeProdutosCompra) {
        this.quantidadeProdutosCompra = quantidadeProdutosCompra;
    }

    public float getValorTotalCompra() {
        return valorTotalCompra;
    }

    public void setValorTotalCompra(float valorTotalCompra) {
        this.valorTotalCompra = valorTotalCompra;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    private float calcularTotalCompra() {
        return produto.getPrecoUnitarioProduto() * quantidadeProdutosCompra;
    }
}
