package br.com.dio.desafio.dominio;

/**
 * Classe abstrata que representa um conteúdo educacional (Curso, Mentoria, etc.).
 * Serve como base para outros tipos de conteúdo, garantindo atributos comuns
 * e o contrato para cálculo de XP.
 */
public abstract class Conteudo {

    /**
     * Valor padrão de XP para cada conteúdo.
     */
    protected static final double XP_PADRAO = 10d;

    private String titulo;
    private String descricao;

    /**
     * Construtor padrão da classe Conteudo.
     * @param titulo O título do conteúdo.
     * @param descricao A descrição do conteúdo.
     */
    public Conteudo(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }

    /**
     * Calcula o XP (Experiência) conferido por este conteúdo.
     *
     * @return O valor de XP calculado.
     */
    public abstract double calcularXp();

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
