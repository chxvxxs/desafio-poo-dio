package br.com.dio.desafio.dominio;

/**
 * Lançada quando um conteúdo (Curso, Mentoria) é criado com dados inválidos
 * (ex: carga horária negativa, data nula).
 */
public class ConteudoInvalidoException extends DominioException {
    public ConteudoInvalidoException(String message) {
        super(message);
    }
}
