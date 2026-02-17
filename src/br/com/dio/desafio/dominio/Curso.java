package br.com.dio.desafio.dominio;

/**
 * Classe que representa um Curso, estendendo a funcionalidade de Conteudo.
 * Adiciona a propriedade de carga horária para o cálculo de XP.
 */
public class Curso extends Conteudo {

    private int cargaHoraria;

    /**
     * Construtor para criar um novo Curso.
     *
     * @param titulo       O título do curso.
     * @param descricao    A descrição do curso.
     * @param cargaHoraria A carga horária do curso em horas (deve ser maior que
     *                     zero).
     * @throws ConteudoInvalidoException se a carga horária for menor ou igual a
     *                                   zero.
     */
    public Curso(String titulo, String descricao, int cargaHoraria) {
        super(titulo, descricao);
        if (cargaHoraria <= 0) {
            throw new ConteudoInvalidoException("Carga horária deve ser maior que zero.");
        }
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public double calcularXp() {
        return XP_PADRAO * cargaHoraria;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    /**
     * Define a nova carga horária do curso.
     *
     * @param cargaHoraria A nova carga horária (deve ser maior que zero).
     * @throws ConteudoInvalidoException se a carga horária for menor ou igual a
     *                                   zero.
     */
    public void setCargaHoraria(int cargaHoraria) {
        if (cargaHoraria <= 0) {
            throw new ConteudoInvalidoException("Carga horária deve ser maior que zero.");
        }
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                '}';
    }
}
