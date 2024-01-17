import java.util.*;



class atmCardBlock extends Exception{
    public String getMessage(){
        return "YOUR CARD HAS BEEN BLOCKED ! (You have attempted 3 times incorrect PIN, Please try to contact with bank.)";
    }
}

class atmInvalidPinOrAccount extends Exception{
    public String getMessage(){
        return "INVALID CARD DETAILS ! (Try Again.)";
    }
}

class atmInvalidOperation extends Exception{
    public String getMessage(){
        return "INVALID OPERATION PERFORMED ! (Try Again.)";
    }
}



public class _3AtmInterface{
    public static void main(String[] args){
        System.out.println("**************************************************");
        System.out.println("************** WELCOME TO OUR ATM ! **************");
        System.out.println("**************************************************\n");
        Bank banking = new Bank();
        banking.setUp();
    }
}



class Bank{
    private int AccNum = 98326415, Password = 124421;
    private double AccBalance = 54000;

    public int getAccNum(){
        return AccNum;
    }
    public int getPassword(){
        return Password;
    }
    public double getAccBalance() {
        return AccBalance;
    }
//    public void setAccNum(int accNum){
//        this.AccNum = accNum;
//    }
//    public void setPassword(int password){
//        this.Password = password;
//    }
    public void setAccBalance(double balance){
        this.AccBalance = balance;
    }

    public void setUp(){
        ATM atm = new ATM();
        try{
            System.out.println("-----Please provide your credentials to perform actions (3 attempts left)-----");
            atm.acceptCredentials();
            atm.validateCredentials();
        } catch (Exception e){
            try{
                System.out.println("-----Please provide your valid credentials to perform actions (2 attempts left)-----");
                atm.acceptCredentials();
                atm.validateCredentials();
            } catch (Exception f){
                try{
                    System.out.println("-----Please provide your valid credentials to perform actions (Last 1 attempt left)-----");
                    atm.acceptCredentials();
                    atm.validateCredentials();
                } catch (Exception g){
                    atmCardBlock excep = new atmCardBlock();
                    System.err.println(excep.getMessage());
                }
            }
        }
    }
}



class ATM{
    Scanner sc = new Scanner(System.in);
    private int yourAccNo, yourPassword;

    public void acceptCredentials(){
        System.out.print("Enter your account number : ");
        yourAccNo = sc.nextInt();
        System.out.print("Enter your pin number : ");
        yourPassword = sc.nextInt();
    }

    public void validateCredentials() throws atmInvalidPinOrAccount, atmInvalidOperation{
        Bank bank = new Bank();
        boolean ifValid = true;

        if(bank.getAccNum() == yourAccNo && bank.getPassword() == yourPassword){
            while(ifValid){
                System.out.println("\nOperations to be performed (1, 2, 3 or 4) :-\n1) WITHDRAW\n2) DEPOSIT\n3) CHECK BALANCE\n4) LOGOUT\n");
                int choice = sc.nextInt();

                switch(choice){
                    case 1:
                        System.out.print("Enter the amount to withdraw : ");
                        double withdrawAmount = sc.nextDouble();
                        if(withdrawAmount > bank.getAccBalance()){
                            System.out.println("\nINSUFFICIENT BALANCE !");
                        }
                        else{
                            bank.setAccBalance(bank.getAccBalance() - withdrawAmount);
                            System.out.println("\nPlease collect your money : "+withdrawAmount);
                            System.out.println("Available balance in your account number XXXX"+bank.getAccNum()+" is : "+bank.getAccBalance()+" !");
                        }
                        ifValid = false;
                        break;
                    case 2:
                        System.out.print("Enter the amount to deposit : ");
                        double withdrawAmount2 = sc.nextDouble();
                        bank.setAccBalance(bank.getAccBalance() + withdrawAmount2);
                        System.out.println("\nDeposited "+withdrawAmount2+" to your account number XXXX"+bank.getAccNum()+" !");
                        System.out.println("Available balance in your account number XXXX"+bank.getAccNum()+" is : "+bank.getAccBalance()+" !");
                        ifValid = false;
                        break;
                    case 3:
                        System.out.println("Available balance in your account number XXXX"+bank.getAccNum()+" is : "+bank.getAccBalance()+" !");
                        break;
                    case 4:
                        ifValid = false;
                        break;
                    default:
                        atmInvalidOperation excep = new atmInvalidOperation();
                        System.err.println(excep.getMessage());
                }
            }
        }
        else{
            atmInvalidPinOrAccount excep = new atmInvalidPinOrAccount();
            System.err.println(excep.getMessage());
            throw excep;
        }
    }
}