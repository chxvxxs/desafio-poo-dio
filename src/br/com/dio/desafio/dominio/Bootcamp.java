package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.*;

/**
 * Classe que representa um Bootcamp.
 * Um bootcamp possui um conjunto de conteúdos e desenvolvedores inscritos,
 * além de datas de início e fim.
 */
public class Bootcamp {
    private String nome;
    private String descricao;
    private final LocalDate dataInicial;
    private final LocalDate dataFinal;
    private final Set<Dev> devsInscritos = new HashSet<>();
    private final Set<Conteudo> conteudos = new LinkedHashSet<>();

    /**
     * Construtor principal.
     * Define a data inicial como a data atual e a final como 45 dias depois.
     *
     * @param nome      Nome do Bootcamp.
     * @param descricao Descrição do Bootcamp.
     */
    public Bootcamp(String nome, String descricao) {
        this(nome, descricao, LocalDate.now(), LocalDate.now().plusDays(45));
    }

    /**
     * Construtor com datas personalizadas.
     *
     * @param nome        Nome do Bootcamp.
     * @param descricao   Descrição do Bootcamp.
     * @param dataInicial Data de início.
     * @param dataFinal   Data de término.
     */
    public Bootcamp(String nome, String descricao, LocalDate dataInicial, LocalDate dataFinal) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
    }

    /**
     * Retorna uma visualização imutável dos devs inscritos.
     * Para inscrever um dev, utilize o método
     * {@link Dev#inscreverBootcamp(Bootcamp)}.
     *
     * @return Set imutável de devs inscritos.
     */
    public Set<Dev> getDevsInscritos() {
        return Collections.unmodifiableSet(devsInscritos);
    }

    /**
     * Método protegido para permitir que a classe Dev se inscreva.
     * Apenas classes do mesmo pacote (como Dev) devem chamar isso diretamente
     * para manter a consistência bidirecional.
     * 
     * @param dev Dev a ser inscrito.
     */
    protected void adicionarDev(Dev dev) {
        this.devsInscritos.add(dev);
    }

    /**
     * Retorna uma visualização imutável dos conteúdos do bootcamp.
     *
     * @return Set imutável de conteúdos.
     */
    public Set<Conteudo> getConteudos() {
        return Collections.unmodifiableSet(conteudos);
    }

    /**
     * Adiciona um conteúdo ao bootcamp.
     * 
     * @param conteudo O conteúdo a ser adicionado.
     */
    public void adicionarConteudo(Conteudo conteudo) {
        this.conteudos.add(conteudo);
    }

    public String getNome() {
        return nome;
    }

    // Setters removidos ou mantidos apenas se mutabilidade for desejada após
    // construção
    // Manterei setters de nome/descrição por flexibilidade, mas datas são finais.

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Bootcamp bootcamp = (Bootcamp) o;
        return Objects.equals(nome, bootcamp.nome) && Objects.equals(descricao, bootcamp.descricao)
                && Objects.equals(dataInicial, bootcamp.dataInicial) && Objects.equals(dataFinal, bootcamp.dataFinal)
                && Objects.equals(devsInscritos, bootcamp.devsInscritos)
                && Objects.equals(conteudos, bootcamp.conteudos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao, dataInicial, dataFinal, devsInscritos, conteudos);
    }
}
