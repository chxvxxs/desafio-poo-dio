import br.com.dio.desafio.dominio.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            // Criação de cursos e mentorias utilizando construtores (Encapsulamento e
            // Imutabilidade)
            Curso curso1 = new Curso("curso java", "descrição curso java", 8);
            Curso curso2 = new Curso("curso js", "descrição curso js", 4);

            Mentoria mentoria = new Mentoria("mentoria de java", "descrição mentoria java", LocalDate.now());

            // Criação do Bootcamp
            Bootcamp bootcamp = new Bootcamp("Bootcamp Java Developer", "Descrição Bootcamp Java Developer");

            // Adicionando conteúdos ao bootcamp
            bootcamp.adicionarConteudo(curso1);
            bootcamp.adicionarConteudo(curso2);
            bootcamp.adicionarConteudo(mentoria);

            // Inscrevendo Dev Camila
            Dev devCamila = new Dev("Camila");
            devCamila.inscreverBootcamp(bootcamp);
            System.out.println("Conteúdos Inscritos Camila:" + devCamila.getConteudosInscritos());

            // Progresso de Camila (Consome na ordem de inserção - LinkedHashSet)
            devCamila.progredir();
            devCamila.progredir();
            System.out.println("-");
            System.out.println("Conteúdos Inscritos Camila:" + devCamila.getConteudosInscritos());
            System.out.println("Conteúdos Concluídos Camila:" + devCamila.getConteudosConcluidos());
            System.out.println("XP:" + devCamila.calcularTotalXp());

            System.out.println("-------");

            // Inscrevendo Dev Joao
            Dev devJoao = new Dev("Joao");
            devJoao.inscreverBootcamp(bootcamp);
            System.out.println("Conteúdos Inscritos João:" + devJoao.getConteudosInscritos());

            // Progresso de João
            devJoao.progredir(); // Conclui o primeiro
            devJoao.progredir(); // Conclui o segundo

            // Demonstração de progresso específico (novo recurso)
            // João decide fazer a Mentoria (último item) antes de terminar tudo
            devJoao.progredir(mentoria);

            System.out.println("-");
            System.out.println("Conteúdos Inscritos João:" + devJoao.getConteudosInscritos());
            System.out.println("Conteúdos Concluidos João:" + devJoao.getConteudosConcluidos());
            System.out.println("XP:" + devJoao.calcularTotalXp());

            // --- Testes de exceção ---
            System.out.println("\n--- Testes de Exception ---");

            // 1. Tentar progredir sem estar inscrito em nada (agora, deve estar vazio)
            try {
                devJoao.progredir();
            } catch (ProgressoInvalidoException e) {
                System.out.println("Erro experado (Progresso): " + e.getMessage());
            }

            // 2. Tentar criar curso inválido
            try {
                new Curso("Inválido", "Sem carga", 0);
            } catch (ConteudoInvalidoException e) {
                System.out.println("Erro experado (Conteúdo): " + e.getMessage());
            }

        } catch (DominioException e) {
            System.err.println("Erro de domínio genérico capturado: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erro inesperado: " + e.getMessage());
        }
    }
}
