
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Scanner;

public class CadastroProdutos {

    private static ArrayList<Produto> produtos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n--- LANCHE ---");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Editar produto");
            System.out.println("3 - Excluir produto");
            System.out.println("4 - Listar produtos");
            System.out.println("5 - Vender produto");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 ->
                    cadastrar();
                case 2 ->
                    editar();
                case 3 ->
                    excluir();
                case 4 ->
                    listar();
                case 5 ->
                    vender();
                case 0 ->
                    System.out.println("Saindo...");
                default ->
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void cadastrar() {
        System.out.print("Informe o código: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Informe a descrição: ");
        String descricao = scanner.nextLine();

        System.out.print("Informe o preço: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Informe a Quantidade do produto: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        String caminhoDaImagem;
        Path destinoImagem = null;

        while (true) {
            System.out.print("Informe o caminho da imagem: ");
            caminhoDaImagem = scanner.nextLine();
            File arquivo = new File(caminhoDaImagem);

            if (arquivo.exists() && arquivo.isFile()) {
                try {

                    File pastaImagens = new File("imagens");
                    if (!pastaImagens.exists()) {
                        pastaImagens.mkdirs();
                    }

                    destinoImagem = new File(pastaImagens, arquivo.getName()).toPath();

                    Files.copy(arquivo.toPath(), destinoImagem, StandardCopyOption.REPLACE_EXISTING);

                    System.out.println(" Imagem copiada para: " + destinoImagem.toString());
                    break;

                } catch (IOException e) {
                    System.out.println(" Erro ao copiar a imagem: " + e.getMessage());
                }
            } else {
                System.out.println(" Caminho inválido ou arquivo não encontrado. Tente novamente.");
            }
        }

        produtos.add(new Produto(codigo, descricao, preco, destinoImagem.toString(), quantidade));
        System.out.println("Produto cadastrado!");
    }

    private static void editar() {
        System.out.print("Informe o código do produto: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        for (Produto p : produtos) {
            if (p.getCodigo() == codigo) {
                System.out.print("Nova descrição: ");
                p.setDescricao(scanner.nextLine());

                System.out.print("Novo preço: ");
                p.setPreco(scanner.nextDouble());
                scanner.nextLine();

                String caminhoDaImagem;
                Path destinoImagem = null;

                while (true) {
                    System.out.print("Novo caminho da imagem: ");
                    caminhoDaImagem = scanner.nextLine();
                    File arquivo = new File(caminhoDaImagem);

                    if (arquivo.exists() && arquivo.isFile()) {
                        try {
                            File pastaImagens = new File("imagens");
                            if (!pastaImagens.exists()) {
                                pastaImagens.mkdirs();
                            }

                            destinoImagem = new File(pastaImagens, arquivo.getName()).toPath();

                            Files.copy(arquivo.toPath(), destinoImagem, StandardCopyOption.REPLACE_EXISTING);

                            System.out.println("Imagem copiada para: " + destinoImagem.toString());

                            p.setCaminhoDaImagem(destinoImagem.toString());
                            break;

                        } catch (IOException e) {
                            System.out.println("Erro ao copiar a imagem: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Caminho inválido ou arquivo não encontrado. Tente novamente.");
                    }
                }
                System.out.println("Produto atualizado!");
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }

    private static void excluir() {
        System.out.print("Informe o código do produto: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        produtos.removeIf(p -> p.getCodigo() == codigo);
        System.out.println("Produto removido!");
    }

    private static void listar() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        for (Produto p : produtos) {
            System.out.println(p);
        }
    }

    private static void vender() {
        System.out.print("Informe o código do produto: ");
        int codigo = scanner.nextInt();

        Produto produto = null;
        for (Produto p : produtos) {
            if (p.getCodigo() == codigo) {
                produto = p;
                break;
            }
        }

        if (produto == null) {
            System.out.println("Produto nao foi encontrado.");
            return;
        }

        System.out.println("Informe a quantidade do produto: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        if (quantidade > produto.getQuantidade()) {
            System.out.println("Estoque insuficiente.");
            return;
        }

        produto.setQuantidade(produto.getQuantidade() - quantidade);

        double total = produto.getPreco() * quantidade;

        System.out.printf("Venda feita! Total: R$ %.2f%n", total);
    }
}
