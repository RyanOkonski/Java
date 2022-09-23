package character;

import vehicles.Nave;

public class Pilot extends Ser{
   private Nave nave;
   private int id;

   public Pilot(String nome, Nave naves, int id){
      this.setNome(nome);
      this.setId(id);
      this.nave = naves;
   }

   public void setId(int id){
      this.id = id;
   }

   public int getId(){
      return id;
   }

   @Override
   public String toString(){
      return "Pilot Name: " + this.getNome() + "\n" +
             "Pilot Id: " + this.getId() + "\n" +
             "Pilot Nave: " + this.nave + "\n";
   }
}