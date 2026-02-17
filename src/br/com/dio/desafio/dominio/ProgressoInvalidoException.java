package br.com.dio.desafio.dominio;

/**
 * Lançada quando um Dev tenta progredir indevidamente (ex: sem estar inscrito).
 */
public class ProgressoInvalidoException extends DominioException {
    public ProgressoInvalidoException(String message) {
        super(message);
    }
}
