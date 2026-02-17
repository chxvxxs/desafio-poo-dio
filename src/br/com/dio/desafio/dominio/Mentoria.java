package br.com.dio.desafio.dominio;

import java.time.LocalDate;

/**
 * Classe que representa uma Mentoria, estendendo a funcionalidade de Conteudo.
 * Adiciona uma data específica para a realização.
 */
public class Mentoria extends Conteudo {

    private LocalDate data;

    /**
     * Construtor para criar uma nova Mentoria.
     *
     * @param titulo    O título da mentoria.
     * @param descricao A descrição da mentoria.
     * @param data      A data de realização da mentoria (não pode ser nula).
     * @throws ConteudoInvalidoException se a data for nula.
     */
    public Mentoria(String titulo, String descricao, LocalDate data) {
        super(titulo, descricao);
        if (data == null) {
            throw new ConteudoInvalidoException("A data da mentoria não pode ser nula.");
        }
        this.data = data;
    }

    @Override
    public double calcularXp() {
        return XP_PADRAO + 20d;
    }

    public LocalDate getData() {
        return data;
    }

    /**
     * Define a nova data da mentoria.
     *
     * @param data A nova data (não pode ser nula).
     * @throws ConteudoInvalidoException se a data for nula.
     */
    public void setData(LocalDate data) {
        if (data == null) {
            throw new ConteudoInvalidoException("A data da mentoria não pode ser nula.");
        }
        this.data = data;
    }

    @Override
    public String toString() {
        return "Mentoria{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", data=" + data +
                '}';
    }
}
