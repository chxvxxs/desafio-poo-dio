import br.com.dio.desafio.dominio.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
        
            Curso curso1 = new Curso("curso java", "descrição curso java", 8);
            Curso curso2 = new Curso("curso js", "descrição curso js", 4);

            Mentoria mentoria = new Mentoria("mentoria de java", "descrição mentoria java", LocalDate.now());
        
            Bootcamp bootcamp = new Bootcamp("Bootcamp Java Developer", "Descrição Bootcamp Java Developer");

            bootcamp.adicionarConteudo(curso1);
            bootcamp.adicionarConteudo(curso2);
            bootcamp.adicionarConteudo(mentoria);

            Dev devCamila = new Dev("Camila");
            devCamila.inscreverBootcamp(bootcamp);
            System.out.println("Conteúdos Inscritos Camila:" + devCamila.getConteudosInscritos());

            devCamila.progredir();
            devCamila.progredir();
            System.out.println("-");
            System.out.println("Conteúdos Inscritos Camila:" + devCamila.getConteudosInscritos());
            System.out.println("Conteúdos Concluídos Camila:" + devCamila.getConteudosConcluidos());
            System.out.println("XP:" + devCamila.calcularTotalXp());

            System.out.println("-------");

            Dev devJoao = new Dev("Joao");
            devJoao.inscreverBootcamp(bootcamp);
            System.out.println("Conteúdos Inscritos João:" + devJoao.getConteudosInscritos());

            devJoao.progredir(); 
            devJoao.progredir();

            devJoao.progredir(mentoria);

            System.out.println("-");
            System.out.println("Conteúdos Inscritos João:" + devJoao.getConteudosInscritos());
            System.out.println("Conteúdos Concluidos João:" + devJoao.getConteudosConcluidos());
            System.out.println("XP:" + devJoao.calcularTotalXp());

            System.out.println("\n--- Testes de Exception ---");

            try {
                devJoao.progredir();
            } catch (ProgressoInvalidoException e) {
                System.out.println("Erro experado (Progresso): " + e.getMessage());
            }

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
