package br.com.dio.desafio.dominio;

/**
 * Lançada quando há erro na inscrição de um Dev (ex: bootcamp nulo).
 */
public class MatriculaInvalidaException extends DominioException {
    public MatriculaInvalidaException(String message) {
        super(message);
    }
}
