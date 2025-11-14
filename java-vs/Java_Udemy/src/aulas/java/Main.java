import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Classe 'Principal' (Main) que controla a execução do programa.
 * Contém o menu de interação com o usuário (CLI - Command Line Interface).
 *
 * ESTE É O PONTO DE ENTRADA DA APLICAÇÃO.
 */
public class Main {

    // Declara 'agenda' e 'scanner' como static para serem acessíveis
    // pelos métodos estáticos de menu.
    private static Agenda agenda = new Agenda();
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Método principal (entry point) da aplicação.
     */
    public static void main(String[] args) {
        // Loop principal do menu
        boolean executando = true;
        while (executando) {
            exibirMenu();
            int opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    adicionarNovoContato();
                    break;
                case 2:
                    agenda.listarContatos();
                    break;
                case 3:
                    buscarContatoPorNome();
                    break;
                case 4:
                    removerContatoPorNome();
                    break;
                case 0:
                    executando = false;
                    System.out.println("\n>>> Saindo do sistema. Até logo! <<<\n");
                    break;
                default:
                    System.out.println("\n[ERRO] Opção inválida! Tente novamente.\n");
            }
        }
        scanner.close(); // Fecha o scanner ao sair do programa
    }

    /**
     * Exibe o menu principal de opções no console.
     */
    private static void exibirMenu() {
        System.out.println("\n===== AGENDA DE CONTATOS =====");
        System.out.println("1. Adicionar Contato");
        System.out.println("2. Listar Todos os Contatos");
        System.out.println("3. Buscar Contato por Nome");
        System.out.println("4. Remover Contato por Nome");
        System.out.println("0. Sair");
        System.out.print("================================\nEscolha sua opção: ");
    }

    /**
     * Lê a entrada do usuário e trata exceções (ex: digitar texto em vez de número).
     *
     * @return O número da opção escolhida.
     */
    private static int lerOpcao() {
        try {
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consome o "Enter" (nova linha) deixado pelo nextInt()
            return opcao;
        } catch (Exception e) {
            scanner.nextLine(); // Limpa o buffer do scanner em caso de erro
            return -1; // Retorna uma opção inválida para o 'default' do switch
        }
    }

    /**
     * Lógica para a opção 1: Adicionar Contato.
     * Pede os dados ao usuário e chama o método da Agenda.
     */
    private static void adicionarNovoContato() {
        System.out.println("\n--- Adicionar Novo Contato ---");
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Digite o email: ");
        String email = scanner.nextLine();

        // Validação simples para não adicionar contatos vazios
        if (nome.trim().isEmpty() || telefone.trim().isEmpty()) {
            System.out.println("\n[ERRO] Nome e Telefone são obrigatórios. O contato não foi salvo.\n");
            return;
        }

        Contato novoContato = new Contato(nome, telefone, email);
        agenda.adicionarContato(novoContato);
    }

    /**
     * Lógica para a opção 3: Buscar Contato.
     */
    private static void buscarContatoPorNome() {
        System.out.println("\n--- Buscar Contato ---");
        System.out.print("Digite o nome para busca: ");
        String nome = scanner.nextLine();

        Contato encontrado = agenda.buscarContato(nome);

        if (encontrado != null) {
            System.out.println("\n>>> Contato encontrado: <<<");
            System.out.println(encontrado.toString());
        } else {
            System.out.println("\n[INFO] Nenhum contato encontrado com o nome '" + nome + "'.");
        }
    }

    /**
     * Lógica para a opção 4: Remover Contato.
     */
    private static void removerContatoPorNome() {
        System.out.println("\n--- Remover Contato ---");
        System.out.print("Digite o nome do contato a ser removido: ");
        String nome = scanner.nextLine();

        boolean removido = agenda.removerContato(nome);

        if (removido) {
            System.out.println("\n>>> Contato '" + nome + "' removido com sucesso!");
        } else {
            System.out.println("\n[INFO] Nenhum contato encontrado com o nome '" + nome + "'.");
        }
    }
}

// -------------------------------------------------------------------
// CLASSE DE GERENCIAMENTO (SERVIÇO)
// -------------------------------------------------------------------

/**
 * Classe de 'Serviço' que gerencia a lógica da agenda.
 * Utiliza um ArrayList para armazenar os contatos em memória.
 * (Esta classe NÃO é pública)
 */
class Agenda {

    private List<Contato> contatos;

    /**
     * Construtor que inicializa a lista de contatos.
     */
    public Agenda() {
        this.contatos = new ArrayList<>();
    }

    /**
     * Adiciona um novo contato à lista.
     *
     * @param contato O objeto Contato a ser adicionado.
     */
    public void adicionarContato(Contato contato) {
        contatos.add(contato);
        System.out.println(">>> Contato '" + contato.getNome() + "' adicionado com sucesso!");
    }

    /**
     * Lista todos os contatos presentes na agenda.
     * Se a lista estiver vazia, informa o usuário.
     */
    public void listarContatos() {
        if (contatos.isEmpty()) {
            System.out.println(">>> A agenda está vazia. Nenhum contato para exibir.");
            return;
        }

        System.out.println("\n===== LISTA DE CONTATOS =====");
        for (Contato c : contatos) {
            System.out.println(c.toString()); // Usa o toString() formatado
        }
        System.out.println("==============================\n");
    }

    /**
     * Busca um contato na lista pelo nome (ignorando maiúsculas/minúsculas).
     *
     * @param nome O nome do contato a ser buscado.
     * @return O objeto Contato se encontrado, ou null se não.
     */
    public Contato buscarContato(String nome) {
        for (Contato c : contatos) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                return c;
            }
        }
        return null; // Retorna null se não encontrar
    }

    /**
     * Remove um contato da lista pelo nome (ignorando maiúsculas/minúsculas).
     *
     * @param nome O nome do contato a ser removido.
     * @return true se o contato foi removido, false se não foi encontrado.
     */
    public boolean removerContato(String nome) {
        // Usamos Iterator para remover com segurança durante a iteração
        Iterator<Contato> iterador = contatos.iterator();
        while (iterador.hasNext()) {
            Contato c = iterador.next();
            if (c.getNome().equalsIgnoreCase(nome)) {
                iterador.remove(); // Remove o contato da lista
                return true;
            }
        }
        return false; // Retorna false se não encontrou o contato
    }
}

// -------------------------------------------------------------------
// CLASSE DE DADOS (MODELO)
// -------------------------------------------------------------------

/**
 * Classe 'Modelo' (POJO) que representa um Contato.
 * Contém apenas os dados e os métodos para acessá-los (getters)
 * e um construtor para inicializar o objeto.
 * (Esta classe NÃO é pública)
 */
class Contato {

    private String nome;
    private String telefone;
    private String email;

    /**
     * Construtor para criar um novo objeto Contato.
     *
     * @param nome O nome do contato.
     * @param telefone O telefone do contato.
     * @param email O email do contato.
     */
    public Contato(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    // --- Getters ---

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    /**
     * Sobrescreve o método toString() para fornecer uma representação
     * textual formatada do objeto Contato, facilitando a exibição.
     */
    @Override
    public String toString() {
        return "----------------------------------------\n" +
               " Nome:     " + nome + "\n" +
               " Telefone: " + telefone + "\n" +
               " Email:    " + email + "\n" +
               "----------------------------------------";
    }
}