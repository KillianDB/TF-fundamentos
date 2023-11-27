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

    public void adicionarLembreteCalendario(int diaLembrete, int mesLembrete, int anoLembrete) {
        LocalDate data = LocalDate.now();
        if (mesLembrete == data.getMonthValue() && anoLembrete == data.getYear()) {
            if (diaLembrete >= 1 && diaLembrete <= TAMANHO_MES * 7) {
            
            LocalDate primeiroDiaDoMes = LocalDate.of(data.getYear(), data.getMonth(), 1);
            int diaDaSemanaInicio = primeiroDiaDoMes.getDayOfWeek().getValue();

            int semana = (diaLembrete + diaDaSemanaInicio - 2) / 7;
            int diaDaSemana = (diaLembrete + diaDaSemanaInicio - 2) % 7;
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
                    if (dia == LocalDate.now().getDayOfMonth()) {
                        calendario[i][j] = "|"+ calendario[i][j]+"|"; // Adiciona um traço sob o dia de hoje
                    }
                    dia++;
                }
            }
    
            diaDaSemanaInicio = 0;
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
