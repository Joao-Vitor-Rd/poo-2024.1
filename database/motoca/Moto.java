public class Moto {
    int potencia;
    int time;
    Pessoa pessoa;

    public Moto(int power) {
        this.potencia = power;
        this.time = 0;
        this.pessoa = null;
    }

    public boolean inserir(Pessoa pessoa) {
        if(this.pessoa != null) {
            System.out.println("fail: busy motorcycle");
            return false;
        }
        this.pessoa = pessoa;
        return true;
    }

    public Pessoa remover() {
        if(this.pessoa == null) {
            System.out.println("fail: empty motorcycle");
            return null;
        }
        Pessoa pessoaSaiu = pessoa;
        pessoa = null;
        return pessoaSaiu;
    }

    public void buyTime(int time) {
        this.time += time;
    }

    public void drive(int time) {
        if(this.time == 0) {
            System.out.println("fail: buy time first");
            return;
        }
        if(this.pessoa == null) {
            System.out.println("fail: empty motorcycle");
            return;
        }
        if(pessoa.getAge() > 10) {
            System.out.println("fail: too old to drive");
            return;
        }
        if(this.time - time <= 0) {
            System.out.println("fail: time finished after " + this.time + " minutes");
            this.time = 0;
            return;
        }
        this.time -= time;

    }

    public String honk() {
        StringBuilder sb = new StringBuilder();
        sb.append("P");
        for(int i = 0; i < this.potencia; i++) {
            sb.append("e");
        }
        sb.append("m");
        return sb.toString();
    }

    public String toString() {
        if(this.pessoa == null) {
            return "power:" + this.potencia + ", time:" + this.time + ", person:(empty)";
        }
        return "power:" + this.potencia + ", time:" + this.time + ", person:(" + pessoa.toString() + ")";
    }
}