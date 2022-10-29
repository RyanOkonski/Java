package entity;

public class Jedi {
   private String name;
   private Integer age;
   private Float hight;


   public Jedi(String name, Integer age, Float hight) {
      this.setName(name);
      this.setAge(age);
      this.setHight(hight);
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Integer getAge() {
      return age;
   }

   public void setAge(Integer age) {
      this.age = age;
   }

   public Float getHight() {
      return hight;
   }
   
   public void setHight(Float hight) {
      this.hight = hight;
   }
}