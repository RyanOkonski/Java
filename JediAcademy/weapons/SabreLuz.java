package weapons;

public class SabreLuz{
   private String color;
   private boolean aberto;

   public SabreLuz(String color){
      this.color = color;
   }
   
   public void setColor(String color){
      this.color = color;
   }

   public String getColor(){
      return color;
   }

   private void setOpen(boolean aberto){
      this.aberto = aberto;
   }

   public boolean isOpen(){
      return aberto;
   }

   public void Open(){
      this.setOpen(true);
   }

   public void Close(){
      this.setOpen(false);
   }
}