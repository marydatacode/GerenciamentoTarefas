import java.util.Scanner;
import java.util.ArrayList;

class Tarefa {
    String titulo;
    String descricao;
    String status;

    public Tarefa(String titulo, String descricao, String status) {
        this.titulo = titulo; // this é o atributo da classe
        this.descricao = descricao;
        this.status = status;
    }
}

class GerenciadorTarefas {
    ArrayList<Tarefa> tarefas = new ArrayList<>();

    public void adicionarTarefa(String titulo, String descricao) {
        Tarefa novaTarefa = new Tarefa(titulo, descricao, "Pendente");
        tarefas.add(novaTarefa);
        System.out.println("Tarefa adicionada com sucesso!");
    }

    public void marcarComoConcluida(int indice) {
        if (indice >= 0 && indice < tarefas.size()) {
            tarefas.get(indice).status = "Concluída";
            System.out.println("Tarefa marcada como concluída!");
        } else {
            System.out.println("Índice inválido. Tarefa não encontrada.");
        }
    }

    public void editarTarefa(int indice, String novaDescricao) {
        if (indice >= 0 && indice < tarefas.size()) {
            tarefas.get(indice).descricao = novaDescricao;
            System.out.println("Descrição da tarefa atualizada!");
        } else {
            System.out.println("Índice inválido. Tarefa não encontrada.");
        }
    }

    public void excluirTarefa(int indice) {
        if (indice >= 0 && indice < tarefas.size()) {
            tarefas.remove(indice);
            System.out.println("Tarefa excluída com sucesso!");
        } else {
            System.out.println("Índice inválido. Tarefa não encontrada.");
        }
    }

    public void exibirTarefas() {
        if (tarefas.isEmpty()) {
            System.out.println("Não há tarefas cadastradas.");
        } else {
            System.out.println("\nLista de Tarefas:");
            for (int i = 0; i < tarefas.size(); i++) {
                Tarefa tarefa = tarefas.get(i);
                System.out.println(i + ". " + tarefa.titulo + " - " + tarefa.descricao + " - " + tarefa.status);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorTarefas gerenciador = new GerenciadorTarefas();

        while (true) {
            System.out.println("\n==== Menu ====");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Marcar como Concluída");
            System.out.println("3. Editar Tarefa");
            System.out.println("4. Excluir Tarefa");
            System.out.println("5. Exibir Tarefas");
            System.out.println("6. Sair");

            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do teclado

            switch (escolha) {
                case 1:
                    System.out.print("Digite o título da tarefa: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite a descrição da tarefa: ");
                    String descricao = scanner.nextLine();
                    gerenciador.adicionarTarefa(titulo, descricao);
                    break;
                case 2:
                    System.out.print("Digite o índice da tarefa a ser marcada como concluída: ");
                    int indiceConcluir = scanner.nextInt();
                    gerenciador.marcarComoConcluida(indiceConcluir);
                    break;
                case 3:
                    System.out.print("Digite o índice da tarefa a ser editada: ");
                    int indiceEditar = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer do teclado
                    System.out.print("Digite a nova descrição da tarefa: ");
                    String novaDescricao = scanner.nextLine();
                    gerenciador.editarTarefa(indiceEditar, novaDescricao);
                    break;
                case 4:
                    System.out.print("Digite o índice da tarefa a ser excluída: ");
                    int indiceExcluir = scanner.nextInt();
                    gerenciador.excluirTarefa(indiceExcluir);
                    break;
                case 5:
                    gerenciador.exibirTarefas();
                    break;
                case 6:
                    System.out.println("Saindo do sistema. Até logo!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}