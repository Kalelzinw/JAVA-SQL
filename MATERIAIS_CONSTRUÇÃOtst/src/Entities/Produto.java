package Entities;

public class Produto {
    private int codigoProduto;
    private String descricaoProduto;
    private float precoUnitarioProduto;

    public Produto(int codigoProduto, String descricaoProduto, float precoUnitarioProduto) {
        this.codigoProduto = codigoProduto;
        this.descricaoProduto = descricaoProduto;
        this.precoUnitarioProduto = precoUnitarioProduto;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public float getPrecoUnitarioProduto() {
        return precoUnitarioProduto;
    }

    public void setPrecoUnitarioProduto(float precoUnitarioProduto) {
        this.precoUnitarioProduto = precoUnitarioProduto;
    }

    public float calcularPrecoUnitario(int quantidade) {
        return this.precoUnitarioProduto * quantidade;
    }
}
