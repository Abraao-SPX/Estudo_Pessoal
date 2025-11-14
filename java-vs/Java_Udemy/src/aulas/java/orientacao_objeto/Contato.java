package orientacao_objeto;

/**
 * Classe de Modelo (POJO) que representa um Contato.
 * Responsabilidade: Encapsular dados e comportamento de um contato individual.
 */
public class Contato {

    private String nome;
    private String telefone;
    private String email;

    /**
     * Construtor para criar um novo objeto Contato.
     *
     * @param nome O nome do contato
     * @param telefone O telefone do contato
     * @param email O email do contato
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

    // --- Setters (para permitir edição) ---

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Valida se o contato possui dados obrigatórios válidos.
     *
     * @return true se nome e telefone não estão vazios
     */
    public boolean eValido() {
        return nome != null && !nome.trim().isEmpty() &&
               telefone != null && !telefone.trim().isEmpty();
    }

    /**
     * Sobrescreve o método toString() para formatação personalizada.
     */
    @Override
    public String toString() {
        return "----------------------------------------\n" +
               " Nome:     " + nome + "\n" +
               " Telefone: " + telefone + "\n" +
               " Email:    " + (email.isEmpty() ? "(não informado)" : email) + "\n" +
               "----------------------------------------";
    }
}
