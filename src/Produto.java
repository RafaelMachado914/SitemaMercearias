public class Produto {
    private  String nome;
    private  float preco;
    private  int estoque;
    private  int quantidadeVendida = 0;
    private  float valorVendido = 0;

    public Produto(String nome, float preco, int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
    public float calcularPreco(float preco){
        return (preco + (preco/2f));
    }
    public float calcularDesconto(float precofinal){
        precofinal = (float) (precofinal - (precofinal * 0.10));
        return precofinal;
    }

    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void setQuantidadeVendida(int quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }

    public float getValorVendido() {
        return valorVendido;
    }

    public void setValorVendido(float valorVendido) {
        this.valorVendido = valorVendido;
    }

    @Override
    public String toString() {
        return  " " +
                "nome:" + nome + '\'' +
                ", preco: " + preco +
                ", estoque: " + estoque +
                "Quantidade Vendida:  " + quantidadeVendida ;
    }
}
