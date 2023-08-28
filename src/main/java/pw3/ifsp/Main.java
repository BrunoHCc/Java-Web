package pw3.ifsp;

import pw3.ifsp.controller.alunoController;
import pw3.ifsp.models.Aluno;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();

    }
    public static void menu() {
        alunoController controller = new alunoController();
        Integer opt = 0;
        Scanner scanner = new Scanner(System.in);
        while (opt != 6){
            System.out.println("Escolha uma opção: " +
                    "\n1.Cadastrar " +
                    "\n2.Excluir " +
                    "\n3.Alterar " +
                    "\n4.Buscar aluno pelo nome " +
                    "\n5.Listar alunos (com status aprovação) " +
                    "\n6.SAIR");
            opt = scanner.nextInt();
            scanner.nextLine();

            switch (opt){
                case 1 -> {
                    System.out.println("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.println("Registro Acadêmico: ");
                    String ra = scanner.nextLine();
                    System.out.println("Email: ");
                    String email = scanner.nextLine();
                    System.out.println("Nota 1: ");
                    Double nota1 = scanner.nextDouble();
                    System.out.println("Nota 2: ");
                    Double nota2 = scanner.nextDouble();
                    System.out.println("Nota 3: ");
                    Double nota3 = scanner.nextDouble();
                    controller.createAluno(nome, ra, email, nota1, nota2, nota3);
                }
                case 2 -> {
                    System.out.println("Informe o Id do aluno: ");
                    Long id = scanner.nextLong();
                    controller.deleteAluno(id);
                }
                case 3 -> {
                    System.out.println("Digite o ID do aluno a ser alterado: ");
                    Long id = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Digite os novos dados do aluno.");
                    System.out.println("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.println("Registro Acadêmico: ");
                    String ra = scanner.nextLine();
                    System.out.println("Email: ");
                    String email = scanner.nextLine();
                    System.out.println("Nota 1: ");
                    Double nota1 = scanner.nextDouble();
                    System.out.println("Nota 2: ");
                    Double nota2 = scanner.nextDouble();
                    System.out.println("Nota 3: ");
                    Double nota3 = scanner.nextDouble();
                    controller.updateAluno(id,nome, ra, email, nota1, nota2, nota3);
                }
                case 4 -> {
                    System.out.println("Digite o nome do aluno: ");
                    String nome = scanner.nextLine();
                    List<Aluno> alunoList= controller.findAlunoByName(nome);
                    for (Aluno aluno: alunoList){
                        System.out.println(aluno.toString());
                    }
                }
                case 5 -> {
                    List<Aluno> alunoList = controller.findAllAluno();
                    for(Aluno aluno: alunoList){
                        double media = (aluno.getNota1()+ aluno.getNota2()+ aluno.getNota3())/3;
                        if (media>=6){
                            System.out.println("Aluno " +aluno.getNome()+ " aprovado! Média: " + media);
                        } else if (media>=4) {
                            System.out.println("Aluno " +aluno.getNome()+ " IFA! Média: " + media);
                        }
                        else {
                            System.out.println("Aluno " +aluno.getNome()+ " reprovado! Média:" + media);
                        }
                    }
                }
                case 6 -> System.out.println("Saindo!");
                default -> throw new IllegalStateException("Unexpected value: " + opt);
            }

        }
    }
}