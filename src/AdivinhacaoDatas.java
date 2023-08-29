import java.util.Scanner;

public class AdivinhacaoDatas {
    Scanner sc = new Scanner(System.in);
    int numeroEncontrado;
    String preenchimentoDias[] = new String[5];
    String preenchimentoMeses[] = new String[4];
    String mensagem;
    int resposta;
    String unidadeDeTempo;
    int qtdCalendarios;

    public AdivinhacaoDatas() {

    }

    void preencherDias() {
        unidadeDeTempo = "dia";
        preenchimentoDias[0] = "1 | 3 | 5 | 7 | 9 | 11 | 13 | 15 | 17 | 19 | 21 | 23 | 25 | 27 | 29 | 31";
        preenchimentoDias[1] = "2 | 3 | 6 | 7 | 10 | 11 | 14 | 15 | 18 | 19 | 22 | 23 | 26 | 27 | 30 | 31";
        preenchimentoDias[2] = "4 | 5 | 6 | 7 | 12 | 13 | 14 | 15 | 20 | 21 | 22 | 23 | 28 | 29 | 30 | 31";
        preenchimentoDias[3] = "8 | 9 | 10 | 11 | 12 | 13 | 14 | 15 | 24 | 25 | 26 | 27 | 28 | 29 | 30 | 31";
        preenchimentoDias[4] = "16| 17 | 18 | 19 | 20 | 21 | 22 | 23 | 24 | 25 | 26 | 27 | 28 | 29 | 30 | 31";
    }

    void preencherMeses() {
        unidadeDeTempo = "mês";
        preenchimentoMeses[0] = "1 | 3 | 5 | 7 | 9 | 11";
        preenchimentoMeses[1] = "2 | 3 | 6 | 7 | 10 | 11";
        preenchimentoMeses[2] = "4 | 5 | 6 | 7 | 12";
        preenchimentoMeses[3] = "8 | 9 | 10 | 11 | 12";
    }

    String adivinharData() {
        int dia = adivinharNumero("dia");
        int mes = adivinharNumero("mês");

        mensagem = String.format("A sua data de nascimento é %2d/%2d.", dia, mes);
        return mensagem;
    }

    int adivinharNumero(String unidadeDeTempo) {

        if (unidadeDeTempo.equals("dia")) {
            qtdCalendarios = 5;
            preencherDias();
        } else if (unidadeDeTempo.equals("mês")) {
            qtdCalendarios = 4;
            preencherMeses();
        }

        for (int i = 0; i < qtdCalendarios; i++) {
            mensagem = """
                O seu %s de nascimento está entre os números abaixo?
                %s
                Pressione [1] para sim e [2] para não."""
                    .formatted(unidadeDeTempo, unidadeDeTempo == "dia" ? preenchimentoDias[i] : preenchimentoMeses[i]);
            System.out.println(mensagem);
            resposta = sc.nextInt();
        }

        return 0;
    }
}
