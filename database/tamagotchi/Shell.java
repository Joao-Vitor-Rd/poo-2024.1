import java.util.*;


class Pet {
    private int energyMax;
    private int cleanMax;
    private int energy;
    private int clean;
    private int age;
    private boolean alive;

    public Pet(int energy, int clean) {
        energyMax = energy;
        this.energy = energy;
        cleanMax = clean;
        this.clean = clean;
        this.age = 0;
        this.alive = true;
    }

    public void setEnergy(int energy) {
        if(energy > getEnergyMax()) {
            energy = getEnergyMax();
            return;
        }

        if(energy == 0) {
            this.alive = false;
            System.out.println("fail: pet esta morto");
        }
    }

    public void setClean(int clean) {
        if(clean > getCleanMax()) {
            clean = getCleanMax();
            return;
        }

        if(clean == 0) {
            this.alive = false;
            System.out.println("fail: pet esta morto");
        }
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "E: " + this.energy + ", L: " + this.clean + ", I:" + this.age;
    }

    public int getCleanMax() {
        return cleanMax;
    }

    public int getEnergyMax() {
        return energyMax;
    }

    public int getClean() {
        return clean;
    }

    public int getEnergy() {
        return energy;
    }

    public boolean isAlive() {
        return this.alive;
    }

    public int getAge() {
        return age;
    }
}

class Game {
    private Pet pet;

    public Game(Pet pet) {
        this.pet = pet;
    }

    public boolean testAlive() {
        return pet.isAlive();
    }

    public String toString() {
        return pet.toString();
    }

    public void play() {
        pet.setEnergy(pet.getEnergy() - 2);
        pet.setClean(pet.getClean() - 3);
        pet.setAge(pet.getAge() + 1);
    }

    public void sleep() {

        if(pet.getEnergy() <= pet.getEnergyMax() - 5) {
            pet.setEnergy(pet.getEnergyMax());
            pet.setAge(pet.getAge() + 5);
            return;
        }
        System.out.println("fail: nao esta com sono");
    }

    public void shower() {
        pet.setEnergy(pet.getEnergy() - 3);
        pet.setClean(pet.getCleanMax());
        pet.setAge(pet.getAge() + 2);
    }
}

class Adapter {
    private Game game = new Game(new Pet(0, 0));

    public void init(int energy, int clean) {
        this.game = new Game(new Pet(energy, clean));
    }

    public void show() {
        System.out.println(this.game.toString());
    }

    public void play() {
        this.game.play();
    }

    public void shower() {
        this.game.shower();
    }

    public void sleep() {
        this.game.sleep();
    }
}

public class Shell {
    public static void main(String[] a) {
        Adapter adp = new Adapter();
        
        while (true) {
            var line = input();
            write("$" + line);
            var args = line.split(" ");

            if      (args[0].equals("end"))   { break;                                                }
            else if (args[0].equals("show"))  { adp.show();                                           }
            else if (args[0].equals("init"))  { adp.init((int)number(args[1]), (int)number(args[2])); }
            else if (args[0].equals("play"))  { adp.play();                                           }
            else if (args[0].equals("sleep")) { adp.sleep();                                          }
            else if (args[0].equals("shower")){ adp.shower();                                         }
            else                              { write("fail: comando invalido");                      }
        }
    }

    private static Scanner scanner = new Scanner(System.in);
    private static String  input()              { return scanner.nextLine(); }
    private static double  number(String value) { return Double.parseDouble(value); }
    private static void    write(String value)  { System.out.println(value); }
}
