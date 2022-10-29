package control;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import entity.Skills;

public class ControlSkill {
   private Skills skill;

   public void saveSkills(String skill) {
      String[] data = skill.split(",");
      this.skill = new Skills(String.valueOf(data[0]), Integer.valueOf(data[1]));
   }

   public void escreverArquivoSkill() throws IOException {
      String dados = this.skill.getName() + "," +
            this.skill.getValue();

      String desktop = System.getProperty("user.home")
            + "/Users/claudineisantos/Desktop/Ryan/GitHub/Java/Java/GraphicScreen";
      File arquivo = new File(desktop + "skill.csv");
      if (!arquivo.exists()) {
         FileWriter fw = new FileWriter(arquivo, true);
         BufferedWriter bw = new BufferedWriter(fw);
         bw.write("SkillName, SkillValue");
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
