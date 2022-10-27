package entity;

public class Jedi {
   private String name;
   private Integer age;
   private Float hight;
   private Weapon sabreLuz;
   private Skills skillJedi;

   public Jedi(String name, Integer age, Float hight, Weapon sabreLuz, Skills skill) {
      this.setName(name);
      this.setAge(age);
      this.setHight(hight);
      this.setSabreLuz(sabreLuz);
      this.setSkillJedi(skill);
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

   public Weapon getSabreLuz() {
      return sabreLuz;
   }

   public void setSabreLuz(Weapon sabreLuz) {
      this.sabreLuz = sabreLuz;
   }

   public Skills getSkillJedi() {
      return skillJedi;
   }

   public void setSkillJedi(Skills skillJedi) {
      this.skillJedi = skillJedi;
   }
}