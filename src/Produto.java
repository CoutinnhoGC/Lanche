public class Produto {
    private int codigo;
    private String descricao;
    private double preco;
    private String caminhoDaImagem;

    public Produto(int codigo, String descricao, double preco, String caminhoDaImagem) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
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

    public String getCaminhoDaImagem() {
        return caminhoDaImagem;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(double preco) {
        this.preco = preco;
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
                "\nCaminhoDaImagem:'" + caminhoDaImagem + '\'' +
                '}';
    }
}
