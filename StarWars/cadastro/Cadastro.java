package cadastro;

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import jedi.Jedi;
import jedi.Forca;
import planeta.Planeta;
import planeta.Academia;
import sabreLuz.SabreLuz;

public class Cadastro {
   Jedi[] jedi;
   Planeta[] planeta;
   Academia[] academia;
   SabreLuz[] sabreluz;

   public Cadastro() {
      Scanner sc = new Scanner(System.in);

      String nomes[] = { "Correr", "Desviar", "Saltar", "Atirar" };
      Forca[] forcas = new Forca[4];
      SabreLuz[] sabreluz = new SabreLuz[8];
      Jedi[] jedi = new Jedi[8];
      Planeta[] planeta = new Planeta[2];
      Academia[] academia = new Academia[2];
      ArrayList<String> listJedi = new ArrayList<>();

      System.out.println("\n\n======== BEM VINDO ========");
      for (int i = 0; i < jedi.length; i++) {
         System.out.println("\n------ Cadastro Jedi's ------");
         System.out.print("Insira o nome do Jedi[" + (i + 1) + "]: ");
         String nome = sc.nextLine();
         System.out.print("Insira o lado do Jedi[" + (i + 1) + "]: ");
         String lado = sc.nextLine();
         System.out.print("Insira a cor do Sabre[" + (i + 1) + "]: ");
         String cor = sc.nextLine();
         sabreluz[i] = new SabreLuz(cor);
         for (int f = 0; f < forcas.length; f++) {
            System.out.println("Insira a intensidade da Habilidade[" + (f + 1) + "]: ");
            int potencia = sc.nextInt();
            forcas[f] = new Forca(nomes[f], potencia);
         }
         Forca[] forcas2 = { forcas[0], forcas[1], forcas[2], forcas[3] };
         jedi[i] = new Jedi(nome, lado, sabreluz[i], forcas2);
         jedi[i].apertarBotaoSabre();
         listJedi.add(nome);
         sc.nextLine();
      }

      Jedi[] jedi_meio = { jedi[0], jedi[1], jedi[2], jedi[3]};
      Jedi[] jedi_restante = { jedi[4], jedi[5], jedi[6], jedi[7]};

      for (int i = 0; i < planeta.length; i++) {
         System.out.println("\n------ Cadastro Planeta's ------");
         System.out.print("Insira o nome do Planeta[" + (i + 1) + "]: ");
         String nome = sc.nextLine();
         System.out.print("Insira a galaxia do Planeta[" + (i + 1) + "]: ");
         String galax = sc.nextLine();
         System.out.print("Insira o tamanho do Planeta[" + (i + 1) + "]: ");
         double tam = sc.nextDouble();
         System.out.print("Insira a população do Planeta[" + (i + 1) + "]: ");
         int popu = sc.nextInt();
         sc.nextLine();
         planeta[i] = new Planeta(nome, galax, tam, popu);
         System.out.println("\n------ Cadastro Academia's ------");
         System.out.print("Insira o endereço da Academia[" + (i + 1) + "]: ");
         String end = sc.nextLine();
         System.out.print("Insira o tamanho da Academia[" + (i + 1) + "]: ");
         int ta2 = sc.nextInt();
         System.out.print("Insira a quantidade máx de alunos da Academia[" + (i + 1) + "]: ");
         int tamMax = sc.nextInt();
         if (i == 0 && tamMax >= 4) {
            academia[i] = new Academia(end, ta2, tamMax, planeta[i], jedi_meio);
         } else if (i == 1 && tamMax >= 4) {
            academia[i] = new Academia(end, ta2, tamMax, planeta[i], jedi_restante);
         }
         sc.nextLine();
      }
      sc.close();

      System.out.println("\n\n------ DADOS JEDI'S ------");
      for (Jedi newJedi : jedi) {
         System.out.println(newJedi.toString());
         System.out.println(Arrays.toString(newJedi.getForca()));
      }

      System.out.println("\n\n------ DADOS ACADEMIA'S ------");
      for  (int j = 0; j < academia.length; j++){
         if (j == 0){
            System.out.println(academia[j].toString());
            for (int d = 0; d < jedi.length/2; d++){
               System.out.println(listJedi.get(d));
            }
         } else if (j == 1){
            System.out.println(academia[j].toString());
            for (int d = 4; d < jedi.length; d++){
               System.out.println(listJedi.get(d));
            }
         }
      }
      System.out.println("\n======== PROGRAMA FINALIZADO ========\n\n");
   }
}