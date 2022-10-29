package control;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import entity.Weapon;

public class ControlWeapon {
   private Weapon weapon;

   public void saveWeapon(String weapon) {
      String[] data = weapon.split(",");
      this.weapon = new Weapon(String.valueOf(data[0]), Integer.valueOf(data[1]), Boolean.valueOf(data[2]));
   }

   public void escreverArquivoWeapon() throws IOException {
      String dados = this.weapon.getColor() + "," +
            this.weapon.getSize() + "," + 
            this.weapon.getManner();

      String desktop = System.getProperty ("user.home") + "/Users/claudineisantos/Desktop/Ryan/GitHub/Java/Java/GraphicScreen";
      File arquivo = new File(desktop + "weapon.csv");
      if (!arquivo.exists()) {
         FileWriter fw = new FileWriter(arquivo, true);
         BufferedWriter bw = new BufferedWriter(fw);
         bw.write("WeaponColor, WeaponSize, WeaponManner");
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
