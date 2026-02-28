public class Hall {
    int x=0;
    int y=0;
    private boolean[][] seats;

    //costruttore
    public Hall(int x, int y){
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
    }

    //todo add a way to occupy a seat per user

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
