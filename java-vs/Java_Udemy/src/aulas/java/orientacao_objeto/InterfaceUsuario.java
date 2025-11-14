package orientacao_objeto;

import java.util.List;
import java.util.Scanner;

/**
 * Classe de Interface com Usuário (UI - User Interface).
 * Responsabilidade: Gerenciar toda a interação com o usuário via console.
 * Desacoplada da lógica de negócio (Agenda).
 */
public class InterfaceUsuario {

    private Agenda agenda;
    private Scanner scanner;

    /**
     * Construtor que injeta a dependência de Agenda.
     *
     * @param agenda A instância da agenda a ser manipulada
     */
    public InterfaceUsuario(Agenda agenda) {
        this.agenda = agenda;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Inicia o loop principal do programa (menu).
     */
    public void iniciar() {
        boolean executando = true;
        while (executando) {
            exibirMenu();
            int opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    executarAdicionarContato();
                    break;
                case 2:
                    executarListarContatos();
                    break;
                case 3:
                    executarBuscarContato();
                    break;
                case 4:
                    executarRemoverContato();
                    break;
                case 0:
                    executando = false;
                    exibirMensagem("\n>>> Saindo do sistema. Até logo! <<<\n");
                    break;
                default:
                    exibirMensagem("\n[ERRO] Opção inválida! Tente novamente.\n");
            }
        }
        scanner.close();
    }

    /**
     * Exibe o menu principal no console.
     */
    private void exibirMenu() {
        System.out.println("\n===== AGENDA DE CONTATOS =====");
        System.out.println("1. Adicionar Contato");
        System.out.println("2. Listar Todos os Contatos");
        System.out.println("3. Buscar Contato por Nome");
        System.out.println("4. Remover Contato por Nome");
        System.out.println("0. Sair");
        System.out.print("================================\nEscolha sua opção: ");
    }

    /**
     * Lê a opção do usuário com tratamento de erros.
     *
     * @return A opção escolhida ou -1 em caso de erro
     */
    private int lerOpcao() {
        try {
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consome a quebra de linha
            return opcao;
        } catch (Exception e) {
            scanner.nextLine(); // Limpa o buffer
            return -1;
        }
    }

    /**
     * Executa a operação de adicionar contato.
     */
    private void executarAdicionarContato() {
        exibirMensagem("\n--- Adicionar Novo Contato ---");
        
        String nome = lerEntrada("Digite o nome: ");
        String telefone = lerEntrada("Digite o telefone: ");
        String email = lerEntrada("Digite o email: ");

        Contato novoContato = new Contato(nome, telefone, email);
        if (agenda.adicionarContato(novoContato)) {
            exibirMensagem(">>> Contato '" + nome + "' adicionado com sucesso!\n");
        } else {
            exibirMensagem("\n[ERRO] Nome e Telefone são obrigatórios. O contato não foi salvo.\n");
        }
    }

    /**
     * Executa a operação de listar todos os contatos.
     */
    private void executarListarContatos() {
        if (agenda.estaVazia()) {
            exibirMensagem("\n>>> A agenda está vazia. Nenhum contato para exibir.\n");
            return;
        }

        System.out.println("\n===== LISTA DE CONTATOS =====");
        List<Contato> contatos = agenda.listarContatos();
        for (Contato c : contatos) {
            System.out.println(c.toString());
        }
        System.out.println("==============================\n");
    }

    /**
     * Executa a operação de buscar contato.
     */
    private void executarBuscarContato() {
        exibirMensagem("\n--- Buscar Contato ---");
        String nome = lerEntrada("Digite o nome para busca: ");

        Contato encontrado = agenda.buscarContato(nome);
        if (encontrado != null) {
            System.out.println("\n>>> Contato encontrado: <<<");
            System.out.println(encontrado.toString());
        } else {
            exibirMensagem("\n[INFO] Nenhum contato encontrado com o nome '" + nome + "'.\n");
        }
    }

    /**
     * Executa a operação de remover contato.
     */
    private void executarRemoverContato() {
        exibirMensagem("\n--- Remover Contato ---");
        String nome = lerEntrada("Digite o nome do contato a ser removido: ");

        if (agenda.removerContato(nome)) {
            exibirMensagem("\n>>> Contato '" + nome + "' removido com sucesso!\n");
        } else {
            exibirMensagem("\n[INFO] Nenhum contato encontrado com o nome '" + nome + "'.\n");
        }
    }

    /**
     * Lê uma entrada do usuário (linha completa).
     *
     * @param prompt O texto a ser exibido antes de ler
     * @return A entrada do usuário
     */
    private String lerEntrada(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    /**
     * Exibe uma mensagem no console.
     *
     * @param mensagem A mensagem a ser exibida
     */
    private void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
