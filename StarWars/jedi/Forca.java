package jedi;

public class Forca {
   private String nome;
   private int potencia;

   public Forca(String nome, int potencia) {
      this.setNome(nome);
      this.setPotencia(potencia);
   }

   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public int getPotencia() {
      return potencia;
   }

   public void setPotencia(int potencia) {
      this.potencia = potencia;
   }

   @Override
   public String toString() {
      return this.getNome() + ": " + this.getPotencia();
   }
}