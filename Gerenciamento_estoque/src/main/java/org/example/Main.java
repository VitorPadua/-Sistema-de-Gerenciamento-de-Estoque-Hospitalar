import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Classe que representa um Produto Hospitalar
class Produto {
    private int id;
    private String nome;
    private int quantidade;

    public Produto(int id, String nome, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public int getQuantidade() { return quantidade; }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Nome: " + nome +
                " | Quantidade: " + quantidade;
    }
}

// Classe que simula o CRUD do estoque hospitalar
class SistemaEstoque {
    private List<Produto> produtos = new ArrayList<>();

    // Função para adicionar um produto
    public void adicionarProduto(int id, String nome, int quantidade) {
        Produto produto = new Produto(id, nome, quantidade);
        produtos.add(produto);
        System.out.println("✔ Produto adicionado com sucesso!\n");
    }

    // Função para consultar um produto pelo ID
    public void consultarProduto(int id) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                System.out.println("🔎 Produto encontrado:");
                System.out.println(p);
                return;
            }
        }
        System.out.println("❌ Produto não encontrado.\n");
    }
}

// Classe principal
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SistemaEstoque sistema = new SistemaEstoque();
        int opcao;

        do {
            System.out.println("\n==== ESTOQUE HOSPITALAR ====");
            System.out.println("1 - Adicionar Produto");
            System.out.println("2 - Consultar Produto");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("ID do produto: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // limpar buffer

                    System.out.print("Nome do produto: ");
                    String nome = sc.nextLine();

                    System.out.print("Quantidade: ");
                    int quantidade = sc.nextInt();

                    sistema.adicionarProduto(id, nome, quantidade);
                    break;

                case 2:
                    System.out.print("Informe o ID para consulta: ");
                    int idConsulta = sc.nextInt();
                    sistema.consultarProduto(idConsulta);
                    break;

                case 0:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}
