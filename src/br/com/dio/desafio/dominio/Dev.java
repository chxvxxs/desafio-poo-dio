package br.com.dio.desafio.dominio;

import java.util.*;

/**
 * Classe que representa um Desenvolvedor inscrito no Bootcamp.
 * Gerencia os conteúdos inscritos, concluídos e o cálculo de XP.
 */
public class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    /**
     * Construtor do Dev.
     * 
     * @param nome Nome do desenvolvedor.
     */
    public Dev(String nome) {
        this.nome = nome;
    }

    /**
     * Inscreve o dev em um bootcamp.
     * Adiciona todos os conteúdos do bootcamp aos conteúdos inscritos do dev
     * e adiciona o dev à lista de inscritos do bootcamp.
     *
     * @param bootcamp O bootcamp para inscrição (não pode ser nulo).
     * @throws MatriculaInvalidaException se o bootcamp for nulo.
     */
    public void inscreverBootcamp(Bootcamp bootcamp) {
        if (bootcamp == null) {
            throw new MatriculaInvalidaException("Bootcamp não pode ser nulo para inscrição.");
        }
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.adicionarDev(this);
    }

    /**
     * Progride no primeiro conteúdo da lista de inscritos.
     * Move o conteúdo de inscritos para concluídos.
     *
     * @throws ProgressoInvalidoException se não houver conteúdos inscritos.
     */
    public void progredir() {
        Conteudo conteudo = this.conteudosInscritos.stream()
                .findFirst()
                .orElseThrow(() -> new ProgressoInvalidoException("Você não está matriculado em nenhum conteúdo!"));

        this.conteudosConcluidos.add(conteudo);
        this.conteudosInscritos.remove(conteudo);
    }

    /**
     * Progride em um conteúdo específico.
     * Útil se o dev quiser escolher qual curso fazer primeiro.
     *
     * @param conteudo O conteúdo a ser concluído.
     * @throws ProgressoInvalidoException se o conteúdo não estiver na lista de
     *                                    inscritos.
     */
    public void progredir(Conteudo conteudo) {
        if (!this.conteudosInscritos.contains(conteudo)) {
            throw new ProgressoInvalidoException(
                    "Conteúdo não encontrado na lista de inscritos: " + conteudo.getTitulo());
        }
        this.conteudosConcluidos.add(conteudo);
        this.conteudosInscritos.remove(conteudo);
    }

    /**
     * Calcula o total de XP ganho com os conteúdos concluídos.
     *
     * @return Total de XP.
     */
    public double calcularTotalXp() {
        return this.conteudosConcluidos.stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna uma visualização imutável dos conteúdos inscritos.
     * 
     * @return Set imutável.
     */
    public Set<Conteudo> getConteudosInscritos() {
        return Collections.unmodifiableSet(conteudosInscritos);
    }

    /**
     * Retorna uma visualização imutável dos conteúdos concluídos.
     * 
     * @return Set imutável.
     */
    public Set<Conteudo> getConteudosConcluidos() {
        return Collections.unmodifiableSet(conteudosConcluidos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos)
                && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }
}
