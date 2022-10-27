package entity;

public class Skills {
   private String name;
   private Integer value;

   public Skills(String name, Integer value) {
      this.setName(name);
      this.setValue(value);
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Integer getValue() {
      return value;
   }

   public void setValue(Integer value) {
      this.value = value;
   }

}
