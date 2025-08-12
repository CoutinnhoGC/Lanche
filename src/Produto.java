public class Produto {
    private int codigo;
    private String descricao;
    private double preco;
    private int quantidade;
    private String caminhoDaImagem;

    public Produto(int codigo, String descricao, double preco, String caminhoDaImagem, int quantidade) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.caminhoDaImagem = caminhoDaImagem;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getCaminhoDaImagem() {
        return caminhoDaImagem;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public void setCaminhoDaImagem(String caminhoDaImagem) {
        this.caminhoDaImagem = caminhoDaImagem;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "\nCodigo:" + codigo +
                "\nDescricao:'" + descricao + '\'' +
                "\nPreco: R$ " + preco +
                "\nQuantidade: " + quantidade +
                "\nCaminhoDaImagem:'" + caminhoDaImagem + '\'' +
                '}';
    }
}
