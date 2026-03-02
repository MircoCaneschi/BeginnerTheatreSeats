public class User {
    private final String name;
    private final String surname;
    private float balance;
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
        private float balance=0;
        private boolean disable=false;

        public UserBuilder(String name, String surname){
            this.name=name;
            this.surname=surname;
        }
        //-- these setter returns themselves to concatenate tha calls--//
        public UserBuilder setBalance(float balance) {
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


    public boolean transaction(float value){
        if(this.balance+value<0){
            System.out.println("Not enough credit!");
            return false;
        }
        this.balance=this.balance+value;
        System.out.println("Transaction finished! New balance: "+this.balance);
        return true;
    }


}
