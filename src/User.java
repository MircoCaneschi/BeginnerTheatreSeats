import javax.swing.*;
import java.util.Scanner;

public class User {
    private final String name;
    private final String surname;
    private double balance;
    private boolean disable;

    //---Using pattern Builder---//
    private User(UserBuilder builder){
        this.name= builder.name;
        this.surname=builder.surname;
        this.balance= builder.balance;
        this.disable= builder.disable;
        System.out.println("Congratulation "+this.name+", you got registered!");
        System.out.println("Your current balance is: "+this.balance);
    }
    public static class UserBuilder{
        private String name;
        private String surname;
        private double balance=0;
        private boolean disable=false;

        public UserBuilder(String name, String surname){
            this.name=name;
            this.surname=surname;
        }
        //-- these setter returns themselves to concatenate tha calls--//
        public UserBuilder setBalance(double balance) {
            this.balance = balance;
            return this;
        }

        public UserBuilder setDisable(boolean disable) {
            this.disable = disable;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }


    public boolean transaction(double value){
        if(this.balance+value<0){
            System.out.println("Not enough credit!");
            return false;
        }
        this.balance=this.balance+value;
        System.out.println("Transaction finished! New balance: "+this.balance);
        return true;
    }

    public void reserveSeat(Hall hall){
        if(hall.freSeats()==0){
            System.out.println("Sorry, there are no free seats for this hall! :(");
            return;
        }
        hall.drawHall();
        //todo inserire lettura coordinate da terminale e controllo validità
        System.out.println("Reserving...  Select a seat typing the coordinates:");
        Scanner scanner=new Scanner(System.in);
        int x, y, count=0;
        do{
            if(count!=0){
                System.out.println("This coordinates ar not allowed! Try again...");
            }   //only prints if it has already been put some coordinates that were out of bounds
            System.out.print("X: ");
            while(!scanner.hasNextInt()){
                System.out.println("Error, data format is incorrect! Try again...");
                System.out.print("X: ");
                scanner.next();
            }
            x= scanner.nextInt();
            System.out.print("Y: ");
            while(!scanner.hasNextInt()){
                System.out.println("Error, data format is incorrect! Try again...");
                System.out.print("Y: ");
                scanner.next();
            }
            y= scanner.nextInt();
            count++;
        }while(!(x<hall.getX()) || !(y<hall.getY()));

        if(hall.reserve(x,y,this.balance, this.disable)){       //TODO fix: check for balance must be separeted and previus of check for the seat
            if(this.disable)
                this.transaction(hall.getConcession());
            else
                this.transaction(hall.getPrice());
            System.out.println("You succesfully reserved the x,y seat! Current balance: "+this.balance);
            return;
        }

//todo inserire richiesta "vuoi scegliere una altro posto" se il posto non è valido con ciclo while

    }

}
