package jedi;

import sabreLuz.SabreLuz;

public class Jedi {
   private String nome;
   private String lado;
   private SabreLuz sabre;
   private Forca[] forca;

   public Jedi(String nome, String lado, SabreLuz sabre, Forca[] forca) {
      this.setNome(nome);
      this.setLado(lado);
      this.setSabre(sabre);
      this.setForca(forca);
   }

   public Forca[] getForca() {
      return forca;
   }

   public void setForca(Forca[] forca) {
      this.forca = forca;
   }

   public SabreLuz getSabre() {
      return sabre;
   }

   public void setSabre(SabreLuz sabre) {
      this.sabre = sabre;
   }

   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public String getLado() {
      return lado;
   }

   public void setLado(String lado) {
      this.lado = lado;
   }

   public void apertarBotaoSabre() {
      if (this.sabre.isAberto()) {
         this.sabre.fechar();
      } else {
         this.sabre.abrir();
      }
   }

   @Override
   public String toString() {
      return "\nNome do Jedi: " + getNome() +
            "\nLado do Jedi: " + getLado() +
            getSabre().toString();
   }
}