import java.util.Scanner;

class Pessoa {
    private String name;
    private int money;

    public Pessoa(String name, int money) {
        this.name = name;
        setMoney(money);
    }


    public int getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String toString() {
        return getName() + ":" + getMoney();
    }
}

class Moto {
    private int custo;
    private Pessoa motorista;
    private Pessoa passageiro;

    public void setMotorista(Pessoa motorista) {
        this.motorista = motorista;
    }

    public void setPassageiro(Pessoa passageiro) {
        if(motorista == null) {
            System.out.println("fail: nao tem motorista");
            return;
        }

        this.passageiro = passageiro;
    }

    public void drive(int km) {
        custo += km;
    }

    public void leavePass() {
        if(custo > passageiro.getMoney()) {
            motorista.setMoney(motorista.getMoney() + custo);
            passageiro.setMoney(0);
            System.out.println("fail: Passenger does not have enough money");
            System.out.println(passageiro + " leave");
            custo = 0;
            passageiro = null;
            return;
        }
        motorista.setMoney(motorista.getMoney() + custo);
        passageiro.setMoney(passageiro.getMoney() - custo);
        System.out.println(passageiro + " leave");
        passageiro = null;
        custo = 0;

    }

    public String toString() {
        if(passageiro == null && motorista == null) {
            return "Cost: " + custo + ", Driver: None, Passenger: None";
        }
        if(passageiro == null) {
            return "Cost: " + custo + ", Driver: " + motorista + ", Passenger: None";
        } 
        if(motorista == null) {
            return "Cost: " + custo + ", Driver: None" + ", Passenger: " + passageiro;
        }

        return "Cost: " + custo + ", Driver: " + motorista + ", Passenger: " + passageiro;
    }
}

class Adapter {

    private Moto moto;

    public Adapter() {
        moto = new Moto();
    }

    public void setDriver(String nome, int money) {
        moto.setMotorista(new Pessoa(nome, money));
    }

    public void setPass(String nome, int money) {
        moto.setPassageiro(new Pessoa(nome, money));
    }

    public void drive(int km) {
        moto.drive(km);
    }

    public void leavePass() {
        moto.leavePass();
    }

    public void show() {
        System.out.println(moto);
    }

}

public class draft {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Adapter adp = new Adapter();

        while(true) {

            String line = sc.nextLine();
            String arg[] = line.split(" ");
            System.out.println("$" + line);

            if(arg[0].equals("setDriver")){adp.setDriver(arg[1], Integer.parseInt(arg[2]));}
            else if(arg[0].equals("setPass")){adp.setPass(arg[1], Integer.parseInt(arg[2]));}  
            else if(arg[0].equals("drive")){adp.drive(Integer.parseInt(arg[1]));}
            else if(arg[0].equals("leavePass")){adp.leavePass();}  
            else if(arg[0].equals("show")){adp.show();} 
            else if(arg[0].equals("end")){break;} 

        }

        sc.close();
    }
}

