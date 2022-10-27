package vehicles;

public class Nave{
   private String tipo;

   public Nave(String tipo){
      this.setTipo(tipo);
   }

   public void setTipo(String tipo){
      this.tipo = tipo;
   }

   public String getTipo(){
      return tipo;
   }

   @Override
   public String toString(){
      return this.getTipo();
   }
}