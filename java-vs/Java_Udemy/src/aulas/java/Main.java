import orientacao_objeto.Agenda;
import orientacao_objeto.InterfaceUsuario;

/**
 * Classe Principal (Main) que controla a execução do programa.
 * Responsabilidade: Apenas inicializar a aplicação.
 * 
 * ESTE É O PONTO DE ENTRADA DA APLICAÇÃO.
 * 
 * Arquitetura em Camadas (Layered Architecture):
 * - Main: Ponto de entrada
 * - InterfaceUsuario: Camada de apresentação (UI)
 * - Agenda: Camada de negócio (lógica)
 * - Contato: Camada de modelo (dados)
 */
public class Main {

    /**
     * Método principal (entry point) da aplicação.
     * Cria instâncias das classes necessárias e inicia o programa.
     */
    public static void main(String[] args) {
        // Cria a instância da agenda (camada de negócio)
        Agenda agenda = new Agenda();
        
        // Cria a interface de usuário, injetando a agenda como dependência
        InterfaceUsuario ui = new InterfaceUsuario(agenda);
        
        // Inicia o programa
        ui.iniciar();
    }
}