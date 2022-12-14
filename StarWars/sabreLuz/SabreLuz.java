package sabreLuz;

public class SabreLuz {
   private String cor;
   private boolean aberto;

   public SabreLuz(String cor) {
      this.setCor(cor);
      this.fechar();
   }

   public String getCor() {
      return cor;
   }

   public void setCor(String cor) {
      this.cor = cor;
   }

   public boolean isAberto() {
      return aberto;
   }

   private void setAberto(boolean aberto) {
      this.aberto = aberto;
   }

   public void abrir() {
      this.setAberto(true);
   }

   public void fechar() {
      this.setAberto(false);
   }

   @Override
   public String toString() {
      return "\nCor do sabre: " + this.cor;
   }
}