import java.util.Arrays;

public class AppNotas {
    private Nota[] notas;
    private Categoria[] categorias;
    private Lembrete[] lembretes;
    private Usuario[] usuarios;
    private int quantidadeNotas;
    private int quantidadeCategorias;
    private int quantidadeLembretes;
    private int quantidadeUsuarios;

    public AppNotas(int maxNotas, int maxCategorias, int maxLembretes, int maxUsuarios) {
        this.notas = new Nota[maxNotas];
        this.categorias = new Categoria[maxCategorias];
        this.lembretes = new Lembrete[maxLembretes];
        this.usuarios = new Usuario[maxUsuarios];
        this.quantidadeNotas = 0;
        this.quantidadeCategorias = 0;
        this.quantidadeLembretes = 0;
        this.quantidadeUsuarios = 0;
    }

    public void adicionarNota(Nota nota) {
        if (quantidadeNotas < notas.length) {
            notas[quantidadeNotas] = nota;
            quantidadeNotas++;
        } else {
            System.out.println("Limite de notas atingido.");
        }
    }

    public void adicionarCategoria(Categoria categoria) {
        if (quantidadeCategorias < categorias.length) {
            categorias[quantidadeCategorias] = categoria;
            quantidadeCategorias++;
        } else {
            System.out.println("Limite de categorias atingido.");
        }
    }

    public void adicionarLembrete(Lembrete lembrete) {
        if (quantidadeLembretes < lembretes.length) {
            lembretes[quantidadeLembretes] = lembrete;
            quantidadeLembretes++;
        } else {
            System.out.println("Limite de lembretes atingido.");
        }
    }

    public void adicionarUsuario(Usuario usuario) {
        if (quantidadeUsuarios < usuarios.length) {
            usuarios[quantidadeUsuarios] = usuario;
            quantidadeUsuarios++;
        } else {
            System.out.println("Limite de usuários atingido.");
        }
    }

   public Usuario[] getUsuarios() {
        return Arrays.copyOf(usuarios, quantidadeUsuarios);
    }

    public Categoria[] getCategorias() {
        return Arrays.copyOf(categorias, quantidadeCategorias);
    }

    public Nota[] getNotas() {
        return Arrays.copyOf(notas, quantidadeNotas);
    }

    public Lembrete[] getLembretes() {
        return Arrays.copyOf(lembretes, quantidadeLembretes);
    }

    public void adicionarLembreteCalendario(int diaLembrete, int mesLembrete, int anoLembrete) {
    }
}