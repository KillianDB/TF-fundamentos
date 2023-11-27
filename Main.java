import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static Usuario usuario;

    public static void main(String[] args) {
        // Criando o aplicativo de notas
        AppNotas aplicativo = new AppNotas(10, 5, 5, 2);

        // Criando o calendario
        Calendario calendario = new Calendario();

        // Scanner para entrada do usuário
        Scanner scanner = new Scanner(System.in);

        int escolha;

        boolean usuarioCriado = false;

        do {
            if (!usuarioCriado) {
                entre();
                adicionarUsuario(scanner, aplicativo);
                usuarioCriado = true;
            }
            exibirMenu();
            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    adicionarCategoria(scanner, aplicativo);
                    break;
                case 2:
                    adicionarNota(scanner, aplicativo, usuario);
                    break;
                    case 3:
                    adicionarLembrete(scanner, aplicativo, usuario, aplicativo.getCalendario());
                    break;                
                case 4:
                    exibirInformacoes(aplicativo);
                    break;
                case 5:
                    calendario.inicializarCalendario();
                    calendario.preencherCalendario();
                    calendario.exibirCalendario();
                    System.out.println("\n");
                    exibirInformacoesLembretes(aplicativo);
                    // if (lembrete.getMes() == LocalDate.now().getMonthValue()) {
                    //     System.out.println("\nLembretes do mês:");
                    //     for (Lembrete lembrete : aplicativo.getLembretes()) {
                    //         System.out.println(lembrete);
                    //     }
                    // }
                    break;
                case 0:
                    System.out.println("Saindo do aplicativo. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (escolha != 0);

        // Fechando o scanner
        scanner.close();
    }

    private static void entre() {
        System.out.println("Bem-vindo!");
        System.out.println("Para iniciar crie um usuário =)");
    }

    private static void exibirMenu() {
        System.out.println("\n======= MENU =======");
        System.out.println("1. Adicionar Categoria");
        System.out.println("2. Adicionar Nota");
        System.out.println("3. Adicionar Lembrete");
        System.out.println("4. Exibir Informações");
        System.out.println("5. Ver calendário do mês");
        System.out.println("0. Sair");
    }

    private static void adicionarUsuario(Scanner scanner, AppNotas aplicativo) {
        System.out.print("Nome do usuário: ");
        String nome = scanner.next();
        System.out.print("Email do usuário: ");
        String email = scanner.next();

        usuario = new Usuario(nome, email);
        aplicativo.adicionarUsuario(usuario);

        System.out.println("Usuário adicionado com sucesso!");
    }

    private static void adicionarCategoria(Scanner scanner, AppNotas aplicativo) {
        System.out.print("Nome da categoria: ");
        String nome = scanner.next();

        Categoria categoria = new Categoria(nome);
        aplicativo.adicionarCategoria(categoria);

        System.out.println("Categoria adicionada com sucesso!");
    }

    private static void exibirMenuCategorias(AppNotas aplicativo) {
        System.out.println("\n======= Escolha a categoria da nota =======");
        Categoria[] categorias = aplicativo.getCategorias();
        for (int i = 0; i < categorias.length; i++) {
            System.out.println((i + 1) + ". " + categorias[i].toString());
        }
    }

private static void adicionarNota(Scanner scanner, AppNotas aplicativo, Usuario usuario) {
    System.out.print("Título da nota: ");
    String titulo = scanner.next();
    System.out.print("Conteúdo da nota: ");
    String conteudo = scanner.next();

    exibirMenuCategorias(aplicativo);

    System.out.print("Número da categoria: ");
    int escolhaCategoria = scanner.nextInt();

    Categoria[] categorias = aplicativo.getCategorias();

    if (escolhaCategoria >= 1 && escolhaCategoria <= categorias.length) {
        Categoria categoriaEscolhida = categorias[escolhaCategoria - 1];

        int diaCriacao = LocalDate.now().getDayOfMonth();
        int mesCriacao = LocalDate.now().getMonthValue();
        int anoCriacao = LocalDate.now().getYear();

        Nota nota = new Nota(titulo, conteudo, categoriaEscolhida, usuario,
                new Data(diaCriacao, mesCriacao, anoCriacao));
        aplicativo.adicionarNota(nota);

        System.out.println("Nota adicionada com sucesso!");
    } else {
        System.out.println("Escolha de categoria inválida.");
    }
}


private static void adicionarLembrete(Scanner scanner, AppNotas aplicativo, Usuario usuario, Calendario calendario) {
    String titulo, descricao;
    int diaLembrete, mesLembrete, anoLembrete;

    do {
        System.out.print("Título do lembrete: ");
        titulo = scanner.next();
        System.out.print("Descrição do lembrete: ");
        descricao = scanner.next();

        do {
            System.out.print("Dia do lembrete: ");
            diaLembrete = scanner.nextInt();
            if (diaLembrete <= 31) {
                break;
            } else {
                System.out.println("O número digitado não pode ser maior que 31.");
            }
        } while (true);

        do {
            System.out.print("Mês do lembrete: ");
            mesLembrete = scanner.nextInt();
            if (mesLembrete <= 12) {
                break;
            } else {
                System.out.println("O número digitado não pode ser maior que 12.");
            }
        } while (true);

        do {
            System.out.print("Ano do lembrete: ");
            anoLembrete = scanner.nextInt();
            if (anoLembrete >= 2023) {
                break;
            } else {
                System.out.println("O ano digitado já passou... Por favor, digite uma data futura.");
            }
        } while (true);

        if (mesLembrete == LocalDate.now().getMonthValue() && anoLembrete == LocalDate.now().getYear()) {
            calendario.adicionarLembreteCalendario(diaLembrete, mesLembrete, anoLembrete);
        }

        Lembrete lembrete = new Lembrete(titulo, descricao, new Data(diaLembrete, mesLembrete, anoLembrete), usuario);
        aplicativo.adicionarLembrete(lembrete);

        System.out.println("Lembrete adicionado com sucesso!");
        
        System.out.print("Deseja adicionar outro lembrete? (S/N): ");
    } while (scanner.next().equalsIgnoreCase("S"));
}


    // private static int exibirLembretesData(AppNotas aplicativo){
    //     int[] dataLembretes;
    //     for (Lembrete lembrete : aplicativo.getLembretes()) {
    //         int i =0;
    //         dataLembretes[i] = lembrete.getMes();
    //         i++;
    //     }
    //     return dataLembretes;
    // }
    private static void exibirInformacoesLembretes(AppNotas aplicativo) {
        for (Lembrete lembrete : aplicativo.getLembretes()) {
            System.out.println(lembrete);
        }
    }
    private static void exibirInformacoes(AppNotas aplicativo) {
        System.out.println("\n======= INFORMAÇÕES =======");
        System.out.println("Usuários:");
        for (Usuario usuario : aplicativo.getUsuarios()) {
            System.out.println(usuario);
        }

        System.out.println("\nCategorias:");
        for (Categoria categoria : aplicativo.getCategorias()) {
            System.out.println(categoria);
        }

        System.out.println("\nNotas:");
        for (Nota nota : aplicativo.getNotas()) {
            System.out.println(nota);
        }

        System.out.println("\nLembretes:");
        for (Lembrete lembrete : aplicativo.getLembretes()) {
            System.out.println(lembrete);
        }
    }
}