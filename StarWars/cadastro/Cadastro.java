package cadastro;

import java.util.Arrays;
import java.util.Scanner;
import jedi.Jedi;
import jedi.Forca;
import planeta.Planeta;
import planeta.Academia;
import sabreLuz.SabreLuz;

public class Cadastro {

   public Cadastro() {
      Scanner sc = new Scanner(System.in);

      String[] nomesForca = new String[4];
      SabreLuz[] coresSabre = new SabreLuz[4];
      Forca[] forcas = new Forca[4];
      Jedi[] jedi = new Jedi[8];
      Planeta[] planeta = new Planeta[4];
      Academia[] academia = new Academia[2];

      System.out.println("\n\n======== BEM VINDO ========");

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
         planeta[i] = new Planeta(nome, galax, tam, popu);
         sc.nextLine();
      }

      for (int f = 0; f < forcas.length; f++) {
         System.out.println("\n------ Cadastro Forças ------");
         System.out.print("Digite o nome da Força[" + (f + 1) + "]: ");
         String nomeForca = sc.nextLine();
         nomesForca[f] = new String(nomeForca);
      }

      for (int s = 0; s < coresSabre.length; s++) {
         System.out.println("\n------ Cadastro Sabre de Luz ------");
         System.out.print("Digite a cor do Sabre[" + (s + 1) + "]: ");
         String corSabre = sc.nextLine();
         coresSabre[s] = new SabreLuz(corSabre);
      }

      for (int i = 0; i < jedi.length; i++) {
         System.out.println("\n------ Cadastro Jedi's ------");
         System.out.print("Insira o nome do Jedi[" + (i + 1) + "]: ");
         String nome = sc.nextLine();
         System.out.print("Insira o lado do Jedi[" + (i + 1) + "]: ");
         String lado = sc.nextLine();

         for (int s = 0; s < coresSabre.length; s++){
            System.out.print("Sabre[" + (s + 1) + "]: " + coresSabre[s] + "\n");
         }
         System.out.print("Escolha um Sabre de Luz: ");
         int sabreCor = sc.nextInt();

         for (int f = 0; f < forcas.length; f++) {
            System.out.print("Insira a intensidade de[" + nomesForca[f] + "]: ");
            int potencia = sc.nextInt();
            forcas[f] = new Forca(nomesForca[f], potencia);
         }
         jedi[i] = new Jedi(nome, lado, coresSabre[sabreCor - 1], forcas);
         jedi[i].apertarBotaoSabre();
         sc.nextLine();
      }

      for (int i = 0; i < academia.length; i++) {
         System.out.println("\n------ Cadastro Academia's ------");
         System.out.print("Insira o endereço da Academia[" + (i + 1) + "]: ");
         String end = sc.nextLine();
         System.out.print("Insira o tamanho da Academia[" + (i + 1) + "]: ");
         int ta2 = sc.nextInt();
         
         for (int s = 0; s < planeta.length; s++){
            System.out.print("\nPlaneta[" + (s + 1) + "]: " + planeta[s].getNome());
         }
         System.out.print("\nEscolha um Planeta para a academia: ");
         int escPla = sc.nextInt();
         
         System.out.print("\nInsira a quantidade máx de Jedis na Academia[" + (i + 1) + "]: ");
         int tamMax = sc.nextInt();

         Jedi[] jediAca = new Jedi[tamMax];
         for (int m = 0; m < jedi.length; m++){
            System.out.print("\nJedi[" + (m + 1) + "]: " + jedi[m].getNome());
         }
         for (int z = 0; z < jediAca.length; z++){
            System.out.print("\nEscolha um Jedi para a academia: ");
            int escJedi = sc.nextInt();
            jediAca[z] = jedi[escJedi - 1];
         }
         academia[i] = new Academia(end, ta2, tamMax, planeta[escPla - 1], jediAca);
         sc.nextLine();
      }
      sc.close();

      System.out.println("\n\n------ DADOS JEDI'S ------");
      for (int i = 0; i < jedi.length; i++) {
         System.out.println(jedi[i].toString());
         System.out.println(Arrays.toString(jedi[i].getForca()));
      }

      System.out.println("\n\n------ DADOS ACADEMIA'S ------");
      for (Academia newAcad : academia) {
         System.out.println(newAcad.toString());
      }
      System.out.println("\n======== PROGRAMA FINALIZADO ========\n\n");
   }
}