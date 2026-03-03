public class Hall {
    private final String name;
    private int x = 0;
    private int y = 0;
    private boolean[][] seats;
    private double price = 10.99;
    private double concession = 6.99;


    //costruttore
    public Hall(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.seats = new boolean[x][y];
    }

    public int freSeats() {
        int count = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (!this.seats[i][j]) {
                    count++;
                }
            }
        }
        System.out.println("There are " + count + " free seats.");
        return count;
    }


    protected boolean isSeatFree(int x, int y) {
        if(!this.seats[x][y]){
            this.seats[x][y]=true;
            return true;
        }
        System.out.println("Sorry, this seat is not available!");
        return false;
    }
    protected boolean check(double balance, boolean disable){
        if(disable)
            if(balance>this.concession){
                return true;
            }
            else
            if(balance>this.price) {
                return true;
            }
        System.out.println("Not enough credit... looser:P");
        return false;
    }

    public void drawHall() {
        System.out.println("----Seats of " + this.name + "-----");
        System.out.println("         0   1   2   3   4   5   6   7   8   9");
        for (int i = 0; i < y; i++) {
            System.out.print("Fila " + i + "  ");   //optiona: replace the numbers with letters somehow and parse the letters to numbers to use it as index in the matrix (reserve c4 = 2,4)
            for (int j = 0; j < x; j++) {
                if (this.seats[j][i]) {
                    System.out.print("[X] ");
                } else System.out.print("[ ] ");
            }
            System.out.println();
        }
    }

    public boolean[][] getSeats() {
        return seats;
    }
    public double getPrice() {
        return price;
    }
    public double getConcession() {
        return concession;
    }

    //theatre dimensions
    public int getX() {
        return x;
    } //abscissas
    public int getY() {
        return y;
    } //ordinates
}
