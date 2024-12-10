
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
        if(tamanho.equals("P")){return 10;}
        if(tamanho.equals("M")){return 20;}
        return 30;

    }

    public void torcer() {
        this.umidade = 0;
    }

    public void enxugar(int umidade) {

        if(this.umidade + umidade >= this.getMaxUmidade()) {
            System.out.println("toalha encharcada");
            this.umidade = getMaxUmidade();
            return;
        }

        this.umidade += umidade;
    }

    public boolean estaSeca() {
        return this.umidade == 0;
    }

    public String toString() {
        return "Cor: " + cor + ", Tamanho: " + tamanho + ", Umidade: " + umidade;
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

    public void estaSeca() {
        if(t.estaSeca()){
            System.out.println("sim");
            return;
        }
        System.out.println("nao");
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
            System.out.println("$" + line);

            if(arg[0].equals("criar")) { adp.init(arg[1], arg[2]);}
            else if(arg[0].equals("mostrar")) {adp.mostrar();}
            else if(arg[0].equals("seca")) {adp.estaSeca();}
            else if(arg[0].equals("enxugar")) {adp.enxugar(Integer.parseInt(arg[1]));}
            else if(arg[0].equals("torcer")) {adp.torcer();}
            else if(arg[0].equals("end")){break;}
            
        }
        sc.close();
        
    }
}

