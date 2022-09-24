import character.Jedi;
import character.Pilot;
import vehicles.Nave;
import weapons.SabreLuz;
import java.util.ArrayList;
import java.util.Scanner;

public class Main{
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      ArrayList<Jedi> jedis = new ArrayList<Jedi>();
      ArrayList<Pilot> pilots = new ArrayList<Pilot>();
      ArrayList<Nave> naves = new ArrayList<Nave>();

      System.out.print("Type a number of [Naves] to be create: ");
      int qtd = sc.nextInt();
      sc.nextLine();
      for(int i = 0; i < qtd; i++){
         System.out.print("Which is the type of Nave [" + (i + 1) + "]: ");
         String type = sc.nextLine();
         naves.add(new Nave(type));
         System.out.println();
      }

      System.out.print("Type a number of [Pilots] to be create: ");
      int pilotsNum = sc.nextInt();
      sc.nextLine();
      for(int i = 0; i < pilotsNum; i++){
         System.out.print("What is the name of Pilot [" + (i + 1) + "]: ");
         String name = sc.nextLine();
         System.out.print("What is the Id of Pilot [" + (i + 1) + "]: ");
         int id = sc.nextInt();
         for (int x = 0; x < qtd; x++){
            System.out.println("Nave [" + (x + 1) + "]: " + naves.get(x).toString());
         }
         System.out.print("Choose a Nave for you: ");
         int indexNave = sc.nextInt();
         indexNave = indexNave - 1;
         pilots.add(new Pilot(name, naves.get(indexNave), id));
         System.out.println();
         sc.nextLine();
      }

      for(int z = 0; z < pilotsNum; z++){
         System.out.println("------PRINT PILOT [" + (z + 1) + "] DATA------");
         System.out.println(pilots.get(z).toString());
      }

      System.out.print("Type a number of [Jedis] to be create: ");
      int jedisNum = sc.nextInt();
      sc.nextLine();
      for(int i = 0; i < jedisNum; i++){
         System.out.print("What is the name of Jedi [" + (i + 1) + "]: ");
         String name = sc.nextLine();
         System.out.print("What is the color of Jedi [" + (i + 1) + "] weapon: ");
         String colorS = sc.nextLine();
         SabreLuz sabre = new SabreLuz(colorS);
         System.out.print("How many midiClorian of Jedi [" + (i + 1) + "]: ");
         int midiChlorian = sc.nextInt();
         System.out.print("How many powers would you like to have: ");
         int powers = sc.nextInt();
         jedis.add(new Jedi(name, midiChlorian, powers, sabre));
         System.out.println();
         sc.nextLine();
      }

      for(int z = 0; z < jedisNum; z++){
         System.out.println("------PRINT JEDI [" + (z + 1) + "] DATA------");
         System.out.println(jedis.get(z).toString());
      }

      sc.close();
   }
}