public class Lead {
    double thickness;
    String hardness;
    int size;

    public Lead(double thickness, String hardness, int size) {
        this.thickness = thickness;
        this.hardness = hardness;
        this.size = size;
    }

    public int usagePerSheet() {
        if(hardness.equals("HB")) {
            this.size -= 1;
        }
        if(hardness.equals("2B")) {
            this.size -= 2;
        }
        if(hardness.equals("4B")) {
            this.size -= 4;
        }
        if(hardness.equals("6B")) {
            this.size -= 6;
        }
        return size;
    }
}