package planeta;

import jedi.Jedi;

public class Academia {
   private String endereco;
   private int tam;
   private int lotacaoMax;
   private Planeta planeta;
   private Jedi[] jedi;
  
   public Academia(String endereco, int tam, int lotacaoMax, Planeta planeta, Jedi[] jedi) {
      this.setEndereco(endereco);
      this.setTam(tam);
      this.setLotacaoMax(lotacaoMax);
      this.setPlaneta(planeta);
      this.setJedi(jedi);
   }

   public Jedi[] getJedi() {
      return jedi;
   }

   public void setJedi(Jedi[] jedi) {
      this.jedi = jedi;
   }

   public Planeta getPlaneta() {
      return planeta;
   }

   public void setPlaneta(Planeta planeta) {
      this.planeta = planeta;
   }

   public String getEndereco() {
      return endereco;
   }

   public void setEndereco(String endereco) {
      this.endereco = endereco;
   }

   public int getTam() {
      return tam;
   }

   public void setTam(int tam) {
      this.tam = tam;
   }

   public int getLotacaoMax() {
      return lotacaoMax;
   }

   public void setLotacaoMax(int lotacaoMax) {
      this.lotacaoMax = lotacaoMax;
   }

   @Override
   public String toString() {
      return "\nPlaneta da Academia: " + getPlaneta().getNome() +
            "\nEndereço do Academia: " + getEndereco() +
            "\nTamanho do Academia: " + getTam() +
            "\nLotação Máxima da Academia: " + getLotacaoMax() +
            "\nAlunos da Academia: ";
   }
}