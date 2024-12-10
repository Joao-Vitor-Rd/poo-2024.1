public class Pessoa {
    private int age;
    private String name;

    public Pessoa(String name, int age) {
        setName(name);
        setAge(age);
    }

    public String toString() {
        return getName() + ":" + getAge();
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }

}