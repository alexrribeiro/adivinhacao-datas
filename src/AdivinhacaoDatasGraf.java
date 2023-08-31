import javax.swing.*;

public class AdivinhacaoDatasGraf {
    int numeroEncontrado;
    String preenchimentoDias[] = new String[5];
    String preenchimentoMeses[] = new String[4];
    String mensagem;
    int resposta;
    String unidadeDeTempo;
    int qtdCalendarios;

    public AdivinhacaoDatasGraf() {

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

        mensagem = String.format("A sua data de nascimento é %02d/%02d.", dia, mes);
        return mensagem;
    }

    int adivinharNumero(String unidadeDeTempo) {
        numeroEncontrado = 0;

        if (unidadeDeTempo.equals("dia")) {
            qtdCalendarios = 5;
            preencherDias();
        } else if (unidadeDeTempo.equals("mês")) {
            qtdCalendarios = 4;
            preencherMeses();
        } else {
            System.out.println("Unidade de tempo inválida!");
        }

        for (int i = 0; i < qtdCalendarios; i++) {
            mensagem = """
                O seu %s de nascimento está entre os números abaixo?
                %s"""
                    .formatted(unidadeDeTempo, unidadeDeTempo.equals("dia") ? preenchimentoDias[i] : preenchimentoMeses[i]);
            resposta = JOptionPane.showConfirmDialog(null, mensagem);

            if (resposta == 0) {
                switch (i) {
                    case 0:
                        numeroEncontrado += 1;
                        break;
                    case 1:
                        numeroEncontrado += 2;
                        break;
                    case 2:
                        numeroEncontrado += 4;
                        break;
                    case 3:
                        numeroEncontrado += 8;
                        break;
                    case 4:
                        numeroEncontrado += 16;
                        break;
                    default:
                        System.out.println("Ocorreu um erro.");
                        break;
                }
            } else if (resposta == 2) {
                System.exit(0);
            }
        }

        return numeroEncontrado;
    }
}
