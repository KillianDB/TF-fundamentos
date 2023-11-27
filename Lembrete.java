public class Lembrete {
    private String titulo;
    private String descricao;
    private Data dataLembrete;
    private Usuario criador;

    public Lembrete(String titulo, String descricao, Data dataLembrete, Usuario criador) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataLembrete = dataLembrete;
        this.criador = criador;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Data getDataLembrete() {
        return dataLembrete;
    }

    public int getDia() {
        return this.dataLembrete.getDia();
    }

    public int getMes() {
        return this.dataLembrete.getMes();
    }

    public int getAno() {
        return this.dataLembrete.getAno();
    }

    public void setDataLembrete(Data dataLembrete) {
        this.dataLembrete = dataLembrete;
    }

    public Usuario getCriador() {
        return criador;
    }

    public void setCriador(Usuario criador) {
        this.criador = criador;
    }

    @Override
    public String toString() {
        return String.format("Lembrete: %s, Descrição: %s, Data do Lembrete: %s, Criador: %s",
                titulo, descricao, dataLembrete, criador.getNome());
    }

    public Object getData() {
        return null;
    }
}