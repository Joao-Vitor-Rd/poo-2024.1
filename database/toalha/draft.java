
import java.util.Scanner;

class Toalha {
    String tamanho;
    String cor;
    int umidade;


    public Toalha(String cor,String tamanho) {
        this.cor = cor;
        this.tamanho = tamanho;
    }

    public int getMaxUmidade() {
        switch (cor) {
            case "P":
                return 10;
            case "M":
                return 20;
            case "G":
                return 30;
            default:
                return 0;
        }
    }

    public void torcer() {
        this.umidade = 0;
    }

    public void enxugar(int umidade) {

        if(this.umidade + umidade >= this.getMaxUmidade()) {
            System.out.println("msg: toalha encharcada");
            this.umidade = getMaxUmidade();
            return;
        }

        this.umidade += umidade;
    }

    public boolean estaSeca() {
        return this.umidade == 0;
    }

    public String toString() {
        return cor + " " + tamanho + " " + umidade;
    }
}

class Adapter {

    Toalha t;

    public void init(String cor, String tamanho) {
        t = new Toalha(cor, tamanho);
    }

    public void enxugar(int umidade) {
        t.enxugar(umidade);
    }

    public void torcer() {
        t.torcer();
    }

    public boolean estaSeca() {
        return t.estaSeca();
    }

    public void mostrar() {
        System.out.println(t.toString());
    }

}
public class draft {
    public static void main(String args[]) {
        Adapter adp = new Adapter();
        Scanner sc = new Scanner(System.in);
        while(true) {

            
            String line = sc.nextLine();
            String arg[] = line.split(" ");
            System.out.println("$" + arg[0]);

            if(arg[0].equals("init")) { adp.init(arg[1], arg[2]);}
            else if(arg[0].equals("mostrar")) {adp.mostrar();}
            else if(arg[0].equals("estaSeca")) {System.out.println(adp.estaSeca());}
            else if(arg[0].equals("enxugar")) {adp.enxugar(Integer.parseInt(arg[1]));}
            else if(arg[0].equals("torcer")) {adp.torcer();}
            else if(arg[0].equals("end")){break;}
            
        }
        sc.close();
        
    }
}

