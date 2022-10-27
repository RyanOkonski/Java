package control;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import entity.Jedi;
import entity.Weapon;
import entity.Skills;

public class ControlSystem {
   private Jedi jedi;
   private Weapon weapon;
   private Skills skill;

   public void salvarJedi(String jedi) {
      String[] data = jedi.split(",");
      this.weapon = new Weapon(String.valueOf(data[0]), Integer.valueOf(data[1]), Boolean.valueOf(data[2]));
      this.skill = new Skills(String.valueOf(data[3]), Integer.valueOf(data[4]));
      this.jedi = new Jedi(String.valueOf(data[5]),
            Integer.valueOf(data[6]),
            Float.valueOf(data[7]),
            weapon,
            skill);
   }

   public void escreverArquivoJedi() throws IOException {
      String dados = this.jedi.getName() + "," +
            this.jedi.getAge() + "," +
            this.jedi.getHight() + "," +
            this.jedi.getSkillJedi().getName() + "," +
            this.jedi.getSkillJedi().getValue() + "," +
            this.jedi.getSabreLuz().getColor() + "," +
            this.jedi.getSabreLuz().getSize() + "," +
            this.jedi.getSabreLuz().getManner();

      File arquivo = new File("C:\\Users\\lucia\\Documents\\Info -UEM\\Trabalhos\\POO\\Java\\GraphicScreen\\jedi.csv");
      if (!arquivo.exists()) {
         FileWriter fw = new FileWriter(arquivo, true);
         BufferedWriter bw = new BufferedWriter(fw);
         bw.write("JediName, JediAge, JediSize, SkillName, SkillValue, WeaponColor, WeaponSize, WeaponManner");
         bw.newLine();
         bw.write(dados);
         bw.close();
         fw.close();
      } else {
         FileWriter fw = new FileWriter(arquivo, true);
         BufferedWriter bw = new BufferedWriter(fw);
         bw.newLine();
         bw.write(dados);
         bw.close();
         fw.close();
      }
   }
}
