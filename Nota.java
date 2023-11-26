public class Nota {
    private String titulo;
    private String conteudo;
    private boolean favorita;
    private Categoria categoria;
    private Usuario criador;
    private Data dataCriacao;

    public Nota(String titulo, String conteudo, Categoria categoria, Usuario criador, Data dataCriacao) {
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.favorita = false;
        this.categoria = categoria;
        this.criador = criador;
        this.dataCriacao = dataCriacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public boolean isFavorita() {
        return favorita;
    }

    public void setFavorita(boolean favorita) {
        this.favorita = favorita;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Usuario getCriador() {
        return criador;
    }

    public void setCriador(Usuario criador) {
        this.criador = criador;
    }

    public Data getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Data dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Override
    public String toString() {
        return String.format("Título: %s, Conteúdo: %s, Favorita: %b, Categoria: %s, Criador: %s, Data de Criação: %s",
                titulo, conteudo, favorita, categoria.getNome(), criador.getNome(), dataCriacao);
    }

    public void marcarComoFavorita() {
        this.favorita = true;
        System.out.println("Nota marcada como favorita: " + titulo);
    }
}
