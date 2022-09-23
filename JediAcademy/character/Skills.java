package character;

public class Skills{
   private String typePower;

   public Skills(String typepower){
      this.setTypepower(typepower);
   }

   public void setTypepower(String typepower){
      this.typePower = typepower;
   }

   public String getTypepower(){
      return typePower;
   }

   @Override
   public String toString(){
      return this.getTypepower() + "\n";
   }
}