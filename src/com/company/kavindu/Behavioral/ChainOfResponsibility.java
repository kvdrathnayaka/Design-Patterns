package com.company.kavindu.Behavioral;

import javax.swing.plaf.ColorUIResource;

/** Chain of Responsibility pattern
 *
 *
 *
 *
 * **/

// We can create a class Currency that will store the amount to dispense and used by the chain implementations.
class Currency{
    private final int amount;
    public Currency(int amount){
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
// The base interface should have a method to define the next processor in the chain and the method that will process the request.
// Our ATM Dispense interface will look like below.
interface DispenseChain{
    void setNextChain(DispenseChain nextChain);
    void dispense(Currency currency);
}

class LKR50Dispenser implements DispenseChain{
    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(Currency currency) {
        if(currency.getAmount() >= 50){
            int num = currency.getAmount()/50;
            int remainder = currency.getAmount()%50;
            System.out.println("Dispensing " + num + " 50 LKR notes");
            if(remainder != 0)
                this.chain.dispense(new Currency(remainder));
        }
        else this.chain.dispense(currency);
    }
}

class LKR20Dispenser implements DispenseChain{
    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(Currency currency) {
        if(currency.getAmount() >= 20){
            int num = currency.getAmount()/20;
            int remainder = currency.getAmount()%20;
            System.out.println("Dispensing " + num + " 20 LKR notes");
            if(remainder != 0)
                this.chain.dispense(new Currency(remainder));
        }
        else this.chain.dispense(currency);
    }
}

class LKR10Dispenser implements DispenseChain{
    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(Currency currency) {
        if(currency.getAmount() >= 10){
            int num = currency.getAmount()/10;
            int remainder = currency.getAmount()%10;
            System.out.println("Dispensing " + num + " 10 LKR notes");
            if(remainder != 0)
                this.chain.dispense(new Currency(remainder));
        }
        else this.chain.dispense(currency);
    }
}



public class ChainOfResponsibility {
    private DispenseChain c1;
    public ChainOfResponsibility(){
        this.c1 = new LKR50Dispenser();
        DispenseChain c2 = new LKR20Dispenser();
        DispenseChain c3 = new LKR10Dispenser();

        c1.setNextChain(c2);
        c2.setNextChain(c3);
    }

    public static void main(String[] args) {
        ChainOfResponsibility chainOfResponsibility = new ChainOfResponsibility();
        int amount = 130;
        if(amount%10 != 0)
            System.out.println("Amount should be in multiple of 10");
        else chainOfResponsibility.c1.dispense(new Currency(amount));
    }
}
