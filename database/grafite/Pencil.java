public class Pencil {
    double thickness;
    Lead tip = null;

    public Pencil(double thickness) {
        this.thickness = thickness;
    }
    
    public boolean hasGrafite() {
        if(tip != null) {
            return true;
        }
        return false;
    }

    public void insert(Lead lead) {
        if(!hasGrafite()) {
            if(this.thickness != lead.thickness) {
                System.out.println("fail: calibre incompativel");
                return;
            }
            tip = lead;
            return;
        }
        System.out.println("fail: ja existe grafite");
        return;
    }

    public Lead remove() {
        if(!hasGrafite()) {
            System.out.println("fail: nao existe grafite");
            return null;
        }
        
        Lead removidoLead = tip;
        tip = null;
        return removidoLead;
    }

    public void writePage() {
        if(!hasGrafite()) {
            System.out.println("fail: nao existe grafite");
            return;
        }
        if(tip.size <= 10) {
            System.out.println("fail: tamanho insuficiente");
            return;
        }
        if(tip.size > 10) {
            tip.usagePerSheet();
            if(tip.size < 10) {
                tip.size = 10;
                System.out.println("fail: folha incompleta");
                return;
            }
            return;
        }
    }

    public String toString() {
        if(tip != null) {
        return "calibre: " + this.thickness + ", grafite: " + "[" + tip.thickness + ":" 
        + tip.hardness + ":" + tip.size + "]";
        }
        return "calibre: " + this.thickness + ", grafite: null";
    }
}