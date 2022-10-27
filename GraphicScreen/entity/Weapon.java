package entity;

public class Weapon {
   private String color;
   private Integer size;
   private Boolean manner;

   public Weapon(String color, Integer size, Boolean manner) {
      this.setColor(color);
      this.setSize(size);
      if (!manner){
         isClose();
      } else {
         isOpen();
      }
   }

   public String getColor() {
      return color;
   }

   public void setColor(String color) {
      this.color = color;
   }

   public Integer getSize() {
      return size;
   }

   public void setSize(Integer size) {
      this.size = size;
   }

   public Boolean getManner() {
      return manner;
   }

   private void setManner(Boolean manner) {
      this.manner = manner;
   }

   public void isOpen() {
      this.setManner(true);
   }

   public void isClose() {
      this.setManner(false);
   }

}
