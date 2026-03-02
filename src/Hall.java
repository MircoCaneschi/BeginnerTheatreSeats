public class Hall {
    String name;
    int x=0;
    int y=0;
    private boolean[][] seats;

    //costruttore
    public Hall(String name, int x, int y){
        this.name= name;
        this.x= x;
        this.y= y;
        this.seats= new boolean[x][y];
    }

    public void freSeats(){
        int count=0;
        for(int i=0; i<x; i++){
            for(int j=0; j<y; j++){
                if(!this.seats[i][j]){
                    count++;
                }
            }
        }
        System.out.println("There are "+count+" free seats.");
        System.out.println();
    }

    //todo add a way to occupy a seat per user

    public void drawHall(){
        System.out.println("----Seats of "+ this.name+"-----");
        for(int i=0; i<y; i++){
            System.out.print("Fila "+i+"  ");
            for(int j=0; j<x; j++){
                if (this.seats[j][i]){
                    System.out.print("[ ]");
                }
                else System.out.print("[X] ");
            }
            System.out.println();
        }
    }
    //theatre dimensions
    public int getX() {
        return x;
    } //abscissas
    public int getY() {
        return y;
    } //ordinates
}
