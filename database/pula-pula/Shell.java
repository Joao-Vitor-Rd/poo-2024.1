import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

class Kid {

    int age;
    String name;

    public Kid(String name, int age) {
        setName(name);
        setAge(age);
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }


    public void setAge(int age) {
        if(age < 0) {
            return;
        }
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return getName() + ":" + getAge();
    }

}

class Trampoline {
    ArrayList<Kid> playing;
    ArrayList<Kid> wainting;

    public Trampoline() {
        playing = new ArrayList<>();
        wainting = new ArrayList<>();
    }

    public void arrive(Kid kid) {
        wainting.addFirst(kid);
    }

    public void enter() {
        playing.addFirst(wainting.get(wainting.size()-1));
        wainting.remove(wainting.size()-1);
    }

    public void leave(){
        if(playing.size() > 0) {
            wainting.addFirst(playing.get(playing.size()-1));
            playing.remove(playing.size()-1);
        }
    }

    public Kid removeKid(String name) {
        if (playing.size() > 0) {
            for (int i = 0; i < playing.size(); i++) {
                if(playing.get(i).getName().equals(name)) {
                    Kid temp = playing.get(i);
                    playing.remove(i);
                    return temp;
                }
            }  
        }
        if (wainting.size() > 0) {
            for (int i = 0; i < wainting.size(); i++) {
                if(wainting.get(i).getName().equals(name)) {
                    Kid temp = wainting.get(i);
                    wainting.remove(i);
                    return temp;
                }
            }
        }
        return null;
    }

    public String toString() {
        return wainting + " => " + playing;
    }
}


class Adapter {
    Trampoline tr = new Trampoline();
    public void arrive(String name, int age) {
        tr.arrive(new Kid(name, age));
    }
    public void enter() {
        tr.enter();
    }
    public void leave() {
        tr.leave();
    }
    public void remove(String name) {
        tr.removeKid(name);
    }
    public void show() {
        System.out.println(tr.toString());
    }

}

public class Shell {
    public static void main(String[] _args) {
        Adapter adp = new Adapter();
        while(true) {
            System.out.print("$");
            var line = input();
            var args = line.split(" ");

            write(line);
            if     (args[0].equals("end"))    { break;                                      }
            else if(args[0].equals("arrive")) { adp.arrive(args[1],(int) number(args[2])) ; }
            else if(args[0].equals("enter"))  { adp.enter();                                }
            else if(args[0].equals("leave"))  { adp.leave();                                }
            else if(args[0].equals("remove")) { adp.remove(args[1]);                        }
            else if(args[0].equals("show"))   { adp.show();                                 }
            else                              { write("fail: comando invalido");      }
        }
    }

    private static Scanner scanner = new Scanner(System.in);
    private static String input() { return scanner.nextLine(); }
    private static double number(String value) { return Double.parseDouble(value); }
    private static void write(String value) { System.out.println(value); }
}
