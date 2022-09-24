package character;

public class Skills{
   private String typePower;
   private int valor;

   public Skills(String typepower, int valuePower){
      this.setTypepower(typepower);
      this.setValor(valuePower);
   }

   public void setTypepower(String typepower){
      this.typePower = typepower;
   }

   public String getTypepower(){
      return typePower;
   }

   public void setValor(int valor){
      this.valor = valor;
   }

   public int getValor(){
      return valor;
   }

   @Override
   public String toString(){
      return "Jedi Skill: " + this.getTypepower() + ", Value: " + this.valor + "\n";
   }
}