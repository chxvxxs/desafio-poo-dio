package br.com.dio.desafio.dominio;

/**
 * Exceção base para todo o domínio do Bootcamp.
 * É uma RuntimeException, indicando que são exceções de negócio
 * que podem ocorrer em tempo de execução, mas que devem ser tratadas
 * ou pelo menos conhecidas pelo chamador.
 */
public class DominioException extends RuntimeException {
    public DominioException(String message) {
        super(message);
    }
}
