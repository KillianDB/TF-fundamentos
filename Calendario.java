import java.time.LocalDate;

public class Calendario {

    private int TAMANHO_MES = 5;
    public String[][] calendario = new String[TAMANHO_MES][7];
    public boolean[][] lembretes = new boolean[TAMANHO_MES][7];

    public void inicializarCalendario() {
        for (int i = 0; i < TAMANHO_MES; i++) {
            for (int j = 0; j < 7; j++) {
                calendario[i][j] = " ";
                lembretes[i][j] = false;
            }
        }
    }

    public void adicionarLembreteCalendario(int dia, int mes, int ano) {
        LocalDate data = LocalDate.now();
        if (mes == data.getMonthValue() && ano == data.getYear()) {
            if (dia >= 1 && dia <= TAMANHO_MES * 7) {
            
            LocalDate primeiroDiaDoMes = LocalDate.of(data.getYear(), data.getMonth(), 1);
            int diaDaSemanaInicio = primeiroDiaDoMes.getDayOfWeek().getValue();

            int semana = (dia + diaDaSemanaInicio - 2) / 7;
            int diaDaSemana = (dia + diaDaSemanaInicio - 2) % 7;
            lembretes[semana][diaDaSemana] = true;
        } else {
            System.out.println("Dia inválido no calendário.");
        }
        }
        
    }

    public void preencherCalendario() {
        LocalDate data = LocalDate.now();
        LocalDate primeiroDiaDoMes = LocalDate.of(data.getYear(), data.getMonth(), 1);
        int diaDaSemanaInicio = primeiroDiaDoMes.getDayOfWeek().getValue();

        int dia = 1;
        for (int i = 0; i < TAMANHO_MES; i++) {
            for (int j = Math.max(0, diaDaSemanaInicio - 1); j < 7; j++) {
                if (dia <= primeiroDiaDoMes.lengthOfMonth()) {
                    calendario[i][j] = String.valueOf(dia);
                    if (lembretes[i][j]) {
                        calendario[i][j] += "*"; // Adiciona um asterisco se houver lembrete
                    }
                    dia++;
                }
            }

            diaDaSemanaInicio = 0; // Na próxima linha, começa na posição 0
        }
    }

    public void exibirCalendario() {
        System.out.println("  Seg   Ter   Qua   Qui   Sex   Sab   Dom");
        for (int i = 0; i < TAMANHO_MES; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.printf("| %-4s", calendario[i][j]);
            }
            System.out.println("|");
        }
    }
}
