package character;

import weapons.SabreLuz;
import java.util.Scanner;

public class Jedi extends Ser {
   private Skills[] skills;
   private SabreLuz sabre;
   private int midiChlorian;

   public Jedi(String nome, int midiChlorian, int skilss, SabreLuz sabre) {
      Scanner sc = new Scanner(System.in);
      this.setNome(nome);
      this.setMidichlorian(midiChlorian);
      this.skills = new Skills[skilss];
      for (int i = 0; i < skills.length; i++) {
         System.out.print("Type a style for Skill [" + (i + 1) + "]: ");
         String typepower = sc.nextLine();
         skills[i] = new Skills(typepower);
      }
      sc.close();
      this.setSabreLuz(sabre);

   }

   public void setSabreLuz(SabreLuz sabre) {
      this.sabre = sabre;
   }

   public SabreLuz getSabre() {
      return sabre;
   }

   public void setMidichlorian(int midiChlorian) {
      this.midiChlorian = midiChlorian;
   }

   public int getMidichlorian() {
      return midiChlorian;
   }

   @Override
   public String toString() {
      for(Skills skills : skills){System.out.print("Jedi Skill: " + skills.toString());};
      return "Jedi Name: " + this.getNome() + "\n" +
            "Jedi Sabre color: " + this.getSabre().getColor() + "\n" +
            "Jedi MidiChlorian quantified: " + this.midiChlorian + "\n";
   }
}