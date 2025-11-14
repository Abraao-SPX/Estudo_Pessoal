package orientacao_objeto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Classe de Repositório (Serviço) que gerencia a lógica da agenda.
 * Responsabilidade: Gerenciar a coleção de contatos e operações CRUD.
 * Utiliza ArrayList para armazenar contatos em memória.
 */
public class Agenda {

    private List<Contato> contatos;

    /**
     * Construtor que inicializa a lista de contatos.
     */
    public Agenda() {
        this.contatos = new ArrayList<>();
    }

    /**
     * Adiciona um novo contato à agenda.
     *
     * @param contato O objeto Contato a ser adicionado
     * @return true se adicionado com sucesso, false caso contrário
     */
    public boolean adicionarContato(Contato contato) {
        if (contato == null || !contato.eValido()) {
            return false;
        }
        return contatos.add(contato);
    }

    /**
     * Lista todos os contatos da agenda.
     *
     * @return Uma cópia da lista de contatos
     */
    public List<Contato> listarContatos() {
        return new ArrayList<>(contatos);
    }

    /**
     * Busca um contato pelo nome (case-insensitive).
     *
     * @param nome O nome do contato
     * @return O objeto Contato encontrado, ou null se não encontrado
     */
    public Contato buscarContato(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return null;
        }
        for (Contato c : contatos) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                return c;
            }
        }
        return null;
    }

    /**
     * Remove um contato pelo nome (case-insensitive).
     *
     * @param nome O nome do contato a ser removido
     * @return true se removido com sucesso, false se não encontrado
     */
    public boolean removerContato(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return false;
        }
        Iterator<Contato> iterador = contatos.iterator();
        while (iterador.hasNext()) {
            Contato c = iterador.next();
            if (c.getNome().equalsIgnoreCase(nome)) {
                iterador.remove();
                return true;
            }
        }
        return false;
    }

    /**
     * Retorna o total de contatos na agenda.
     *
     * @return Número de contatos
     */
    public int getTotalContatos() {
        return contatos.size();
    }

    /**
     * Verifica se a agenda está vazia.
     *
     * @return true se vazia, false caso contrário
     */
    public boolean estaVazia() {
        return contatos.isEmpty();
    }
}
