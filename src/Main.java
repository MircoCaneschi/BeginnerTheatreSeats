//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //hall creation and occupation
        int x=10;
        int y=12;
        Hall cinema1=new Hall("cienma1", x,y);
        for(int i=0; i<x; i++){
            boolean[][] list=cinema1.getSeats();
            list[i][5]=true;
        }   //occupy some random seats

        cinema1.freSeats();

        //new User
        User Pippo =new User.UserBuilder("Pippo", "Pacini").setDisable(true).build();
        Pippo.transaction(17.50);

        Pippo.reserveSeat(cinema1);

        cinema1.drawHall();
    }
}