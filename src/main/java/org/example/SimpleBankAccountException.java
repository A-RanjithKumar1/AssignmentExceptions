package org.example;
import java.util.Scanner;
import java.util.logging.*;
class BankAcc{
    String s;
    private static final Logger LOGGER = Logger.getLogger("InfoLogging");
    private final String accholderName;
    private long accNumber;
    private long balance;
    BankAcc(String a,long b,long c){
        accholderName=a;accNumber=b;balance=c;
    }
    public void deposite(long namount){
        balance+=namount;
        s="Dear User! amount deposited is----- "+ namount;
        LOGGER.info(s);
    }
    public void withdraw(long mamount){
        balance-=mamount;
        s="Dear User! amount withdrawn is-----"+ mamount;
        LOGGER.info(s);
    }
    public String ame(){
        return accholderName;
    }
    public long balance(){
        return balance;
    }
}
public class SimpleBankAccountException {
    private static final Logger LOG = Logger.getLogger("InfoLogging");
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            String s;
            LOG.info("Enter the userName");
            String name = sc.next();
            LOG.info( "Enter the AccountNumber");
            long num = sc.nextLong();
            LOG.info( "Enter the Initial Amount to be deposited");
            long bal = sc.nextLong();
            BankAcc bob = new BankAcc(name, num, bal);
            int op = 0;
            while (op != 4) {
                LOG.info( "Dear User! Please Go through the below option and Enter the option" + "\n" + "1.Deposite 2.Withdraw 3.Balance 4.Exit");
                op = sc.nextInt();
                if (op == 1) {
                    LOG.info( "Enter the Deposite");
                    long dep = sc.nextLong();
                    bob.deposite(dep);
                } else if (op == 2) {
                    LOG.info("Enter the Amount  to be withdrawn");
                    long dra = sc.nextLong();
                    bob.withdraw(dra);
                } else if (op == 3) {
                    long b1 = bob.balance();
                    String na = bob.ame();
                    s="The Account holder Name is---"+na;
                    LOG.info(s);
                    s="The Current Available Balance is"+b1;
                    LOG.info(s);
                }
            }
        } catch (Exception e) {
            LOG.info("Something went wrong while giving input! "+e);
        }
    }
}