package machine;

import java.util.Scanner;
class CoffeeMachin{
    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int money;

    CoffeeMachin(int water,int milk,int beans,int cups,int money){
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.money = money;
    }

    private boolean resource(int waterN,int beansN,int milkN){
        if(water < waterN){
            System.out.println("Sorry, not enough water!");
            return false;
        }else if(milk < milkN){
            System.out.println("Sorry, not enough milk!");
            return false;
        }else if(beans < beansN){
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        }else if(cups == 0){
            System.out.println("Sorry, not enough cup!");
            return false;
        }else{
            System.out.println("I have enough resources, making you a coffee!");
            return true;
        }
    }

    public void info(){
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
    }

    public void fill(int water, int milk, int beans,int cups){
        this.water += water;
        this.milk += milk;
        this.beans += beans;
        this.cups += cups;
    }

    public void buy(String choose){
        boolean eq;
        switch(choose){
            case "1":
                eq = resource(250,16,0);
                if(!eq){
                    return;
                }
                water -= 250;
                beans -= 16;
                cups --;
                money += 4;
                break;
            case "2":
                eq = resource(350,20,75);
                if(!eq){
                    return;
                }
                water -= 350;
                milk -= 75;
                beans -= 20;
                cups--;
                money += 7;
                break;
            case "3":
                eq = resource(200,12,100);
                if(!eq){
                    return;
                }
                water -= 200;
                milk -= 100;
                beans -= 12;
                cups--;
                money += 6;
                break;
            case "back":
                break;
            default:
                break;
        }
    }

    public void take(){
        System.out.println("I gave you " + money);
        money = 0;
    }
}
public class CoffeeMachine {
    private static final Scanner scan = new Scanner(System.in);
    private static CoffeeMachin coffeeMachin = new CoffeeMachin(400,540,120,9,550);

    private static void fill(){
        System.out.println("Write how many ml of water do you want to add:");
        int water = scan.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        int milk = scan.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        int beans = scan.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int cups = scan.nextInt();
        coffeeMachin.fill(water,milk,beans,cups);
    }
    
    private static void buy(){
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        String choose= scan.next();
        coffeeMachin.buy(choose);
        
    }

    public static void main(String[] args) {
        
        while(true){
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String action = scan.next();
            switch(action){
                case "buy":
                    buy();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    coffeeMachin.take();
                    break;
                case "remaining":
                    coffeeMachin.info();
                    break;
                case "exit":
                    return;
            }
        }
    }
}
