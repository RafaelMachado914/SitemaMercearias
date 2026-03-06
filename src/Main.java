import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        //Cadastro
        ArrayList<Produto> ListaDeProdutos = new ArrayList<>();
        System.out.println("Cadastro de Produtos:");
        for (int i = 0; i < 10; i++) {
            System.out.println("Informe o nome do produto " + (i + 1) + "° :");
            String nome = input.nextLine();
            System.out.println("Informe o preco do produto " + (i + 1) + "° :");
            float preco = Float.parseFloat(input.nextLine());
            System.out.println("Informe a quandidade em estoque do produto " + (i + 1) + "° :");
            int estoque = Integer.parseInt(input.nextLine());
            Produto produto = new Produto(nome, preco, estoque);
            ListaDeProdutos.add(produto);
            System.out.println("");
        }

        chamarMenu(ListaDeProdutos);




    }

    public static void chamarMenu(ArrayList<Produto> ListaDeProdutos){
        System.out.println("");
        System.out.println("Selecione uma opcao");
        System.out.println("");
        System.out.println("1 - Vender Produto");
        System.out.println("2 - Reposicao de Estoque");
        System.out.println("3 - Relatorio de Estoque");
        System.out.println("4 - Relatorio de Vendas");
        System.out.println("");

        int opcao = Integer.parseInt(input.nextLine());

        switch(opcao){
            case 1:
                System.out.println("Qual produto deseja repor?");
                String nome1 = input.nextLine();
                VenderProduto(ListaDeProdutos, nome1);
                chamarMenu(ListaDeProdutos);
                break;
            case 2:
                System.out.println("Qual produto deseja repor?");
                String nome2 = input.nextLine();
                ReposicaoDeEstoque(ListaDeProdutos,nome2);
                chamarMenu(ListaDeProdutos);
                break;
            case 3:
                Relatorio(ListaDeProdutos);
                chamarMenu(ListaDeProdutos);
                break;
            case 4:
                RelatorioVendas(ListaDeProdutos);
                chamarMenu(ListaDeProdutos);
                break;
            default:
                System.out.println("Opcao invalida");
                chamarMenu(ListaDeProdutos);
        }
    }

    public static void VenderProduto(ArrayList<Produto> ListaDeProdutos, String nome){
        boolean produtoLocalizado = false;
        for(Produto produto : ListaDeProdutos){
            if(produto.getNome().equalsIgnoreCase(nome)){
                produtoLocalizado = true;
                System.out.println("Quantidade em estoque: " + produto.getEstoque());
                float preco = produto.calcularPreco(produto.getPreco());
                System.out.println("Valor do produto: " + preco );
                System.out.println("Quanto deseja vender?");
                int quantidade = Integer.parseInt(input.nextLine());
                if(quantidade <= produto.getEstoque()){
                    produto.setEstoque(produto.getEstoque() - quantidade);
                    float valorVenda = quantidade * produto.calcularPreco(produto.getPreco());
                    System.out.println("1- Debito");
                    System.out.println("2- Credito");
                    int vendatipo = Integer.parseInt(input.nextLine());
                    switch(vendatipo){
                        case 1:
                            valorVenda = produto.calcularDesconto(valorVenda);
                            System.out.println(produto.getNome());
                            System.out.println("Quantidade: " + quantidade);
                            System.out.println( " Vendido: " + valorVenda);
                            produto.setQuantidadeVendida(produto.getQuantidadeVendida() + quantidade);
                            produto.setValorVendido(produto.getValorVendido() + valorVenda);
                            break;
                        case 2:
                            System.out.println(produto.getNome());
                            System.out.println("Quantidade: " + quantidade);
                            System.out.println( " Vendido: " + valorVenda);
                            produto.setQuantidadeVendida(produto.getQuantidadeVendida() + quantidade);
                            produto.setValorVendido(produto.getValorVendido() + valorVenda);
                            break;
                        default:
                            System.out.println("Invalido");
                            break;
                    }
                }
                else{
                    System.out.println("Quantidade não permitida");
                }
                break;
            }
        if (!produtoLocalizado){
            System.out.println("Produto não encontrado");
            System.out.println("");
        }
        }
    }

    public static void ReposicaoDeEstoque(ArrayList<Produto> ListaDeProdutos, String nome) {
        boolean localizarProduto = false;
        for(Produto produto : ListaDeProdutos){
            if(produto.getNome().equalsIgnoreCase(nome)){
                localizarProduto = true;
                System.out.println(produto.toString());
                System.out.println("Quantidade que deseja repor: ");
                int quantidade = Integer.parseInt(input.nextLine());
                produto.setEstoque(produto.getEstoque() + quantidade);
                System.out.println(produto.getNome());
                System.out.println("Quantidade: " + produto.getEstoque());

            }
        if(!localizarProduto){
            System.out.println("Não encontrado");
        }
        }
    }

    public static void Relatorio(ArrayList<Produto> listaDeProdutos) {
        for(Produto produto : listaDeProdutos){
            System.out.println(produto.toString());
        }
    }

    public static void RelatorioVendas(ArrayList<Produto> ListaDeProdutos) {
        for(Produto produto : ListaDeProdutos){
            System.out.println("");
            System.out.println(produto.getNome());
            System.out.println("Quantidade vendida : " + produto.getQuantidadeVendida());
            System.out.println("Valor vendido : " + produto.getValorVendido());
        }
    }

}