import java.util.Scanner;
import java.util.Stack;

public class Pilha {

    public static void main(String[] args) {
        Stack<Contato> pilhaContatos = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar elemento - Empilhar");
            System.out.println("2. Verificar o tamanho da pilha");
            System.out.println("3. Imprimir e remover todos os elementos da pilha (desempilhando)");
            System.out.println("4. Exibir o elemento no topo da pilha");
            System.out.println("5. Verificar se um elemento existe na pilha e retornar a posição");
            System.out.println("6. Pesquisar por nome");
            System.out.println("7. Pesquisar por e-mail");
            System.out.println("8. Pesquisar por telefone");
            System.out.println("9. Excluir elemento - Desempilhar");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    pilhaContatos.push(new Contato(nome, email, telefone));
                    System.out.println("Contato empilhado.");
                    break;

                case 2:
                    System.out.println("Tamanho da pilha: " + pilhaContatos.size());
                    break;

                case 3:
                    System.out.println("Imprimindo e removendo os contatos da pilha:");
                    while (!pilhaContatos.isEmpty()) {
                        System.out.println(pilhaContatos.pop());
                    }
                    break;

                case 4:
                    if (!pilhaContatos.isEmpty()) {
                        System.out.println("Topo da pilha: " + pilhaContatos.peek());
                    } else {
                        System.out.println("A pilha está vazia.");
                    }
                    break;

                case 5:
                    System.out.print("Digite o nome do contato para verificar se está na pilha: ");
                    nome = scanner.nextLine();
                    int posicao = buscarContatoPorNome(pilhaContatos, nome);
                    if (posicao != -1) {
                        System.out.println("O contato está na posição " + posicao);
                    } else {
                        System.out.println("Contato não encontrado.");
                    }
                    break;

                case 6:
                    System.out.print("Digite o nome para pesquisa: ");
                    nome = scanner.nextLine();
                    buscarPorNome(pilhaContatos, nome);
                    break;

                case 7:
                    System.out.print("Digite o e-mail para pesquisa: ");
                    email = scanner.nextLine();
                    buscarPorEmail(pilhaContatos, email);
                    break;

                case 8:
                    System.out.print("Digite o telefone para pesquisa: ");
                    telefone = scanner.nextLine();
                    buscarPorTelefone(pilhaContatos, telefone);
                    break;

                case 9:
                    if (!pilhaContatos.isEmpty()) {
                        System.out.println("Desempilhando o contato: " + pilhaContatos.pop());
                    } else {
                        System.out.println("A pilha está vazia.");
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }

    private static int buscarContatoPorNome(Stack<Contato> pilha, String nome) {
        for (int i = 0; i < pilha.size(); i++) {
            if (pilha.get(i).getNome().equalsIgnoreCase(nome)) {
                return i;
            }
        }
        return -1;
    }

    private static void buscarPorNome(Stack<Contato> pilha, String nome) {
        boolean encontrado = false;
        for (Contato contato : pilha) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                System.out.println(contato);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Contato não encontrado.");
        }
    }

    private static void buscarPorEmail(Stack<Contato> pilha, String email) {
        boolean encontrado = false;
        for (Contato contato : pilha) {
            if (contato.getEmail().equalsIgnoreCase(email)) {
                System.out.println(contato);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Contato não encontrado.");
        }
    }

    private static void buscarPorTelefone(Stack<Contato> pilha, String telefone) {
        boolean encontrado = false;
        for (Contato contato : pilha) {
            if (contato.getTelefone().equals(telefone)) {
                System.out.println(contato);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Contato não encontrado.");
        }
    }
}
