import java.util.Scanner;

class Roupa {

    private String tamanho;

    public Roupa() {
        tamanho = "";
    }

    public String getTamanho() {
        return "size: (" +  this.tamanho + ")";
    }

    public void setTamanho(String tamanho) {
        if(tamanho.equals("PP") || tamanho.equals("P")
        || tamanho.equals("M") || tamanho.equals("G") 
        || tamanho.equals("GG") || tamanho.equals("GX")
        ) {
            this.tamanho = tamanho;
            return;
        }

        System.out.println("fail: Valor inválido, tente PP, P, M, G, GG ou XG");
    }
}

class Adapter {
    private Roupa rp;

    public Adapter() {
        rp = new Roupa();
    }
    
    public void size(String tamanho) {
        rp.setTamanho(tamanho);
    }

    public void show() {
        System.out.println(rp.getTamanho());
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
            
            if(arg[0].equals("show")){adp.show();}
            else if(arg[0].equals("size")){adp.size(arg[1]);}
            else if(arg[0].equals("end")){break;}
        }

        sc.close();
    }
}

