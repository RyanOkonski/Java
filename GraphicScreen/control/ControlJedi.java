package control;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import entity.Jedi;

public class ControlJedi {
   private Jedi jedi;

   public void saveJedi(String jedi) {
      String[] data = jedi.split(",");
      this.jedi = new Jedi(String.valueOf(data[0]),
            Integer.valueOf(data[1]),
            Float.valueOf(data[2]));
   }

   public void escreverArquivoJedi() throws IOException {
      String dados = this.jedi.getName() + "," +
            this.jedi.getAge() + "," +
            this.jedi.getHight();

      File arquivo = new File("C:\\Users\\lucia\\Documents\\GitHub\\MyProfileGit\\Java\\GraphicScreen\\jedi.csv");
      if (!arquivo.exists()) {
         FileWriter fw = new FileWriter(arquivo, true);
         BufferedWriter bw = new BufferedWriter(fw);
         bw.write("JediName, JediAge, JediSize");
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
