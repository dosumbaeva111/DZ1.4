package com.company;

import java.util.Random;

public class Main {
    public static int[] heroesHealth = {270, 280, 250, 300};
    public static String[] heroesNames = {" Lu Kang ", " Jax ", " Scorpion ", "Raiden"}; //Raiden-Medic
    public static int[] heroesStrike = {20, 15, 25,0};
    public static String boss = " Shao Kahn ";
    public static int bossHealth = 700;
    public static int bossDamage = 50;
    public static String superAbility = "";
    public static int raidenHealSize = 0;


    public static void main(String[] args) {
        System.out.println(" ----- The game started -----");
        while (!isGameFinished()){
            round();
        }

    }

    public static void round(){
        heroesHits();
        setBossHit();
        raidenHeal();
        printStatistics();
    }

    public static void setRandomHealSize(){
        Random random = new Random();
        int value = random.nextInt(100);
        raidenHealSize = value;
    }

    public static void raidenHeal(){
        setRandomHealSize();
        for (int i = 0; i < heroesHealth.length -1; i++) {
            if (heroesHealth[3] > 0){
                if (heroesHealth[i]<100 && heroesHealth[i]>0){
                    heroesHealth[i]+=raidenHealSize;
                    System.out.println("Raiden heal " + heroesNames[i] + " value: " + raidenHealSize);
                    break;
                }
            }
        }
    }

    public static boolean isGameFinished() {
        if (bossHealth <= 0) {
            System.out.println("Heroes won!!! " + "Game Over!!!");
            return true;
        }
        if (heroesHealth[0]<=0 && heroesHealth[1]<=0 && heroesHealth[2]<=0 && heroesHealth[3]<=0){
            System.out.println("Shao Kahn Won!!!");
            return true ;

        }
     return false;
    }

    public static void heroesHits() {
        for (int i = 0; i < heroesHealth.length; i++) {
            bossHealth = bossHealth - heroesStrike[i];
        }

    }

    public static void setBossHit() {
        for (int i = 0; i < heroesHealth.length; i++) {
           if (heroesHealth[i] - bossDamage < 0) heroesHealth[i] = 0;
           else heroesHealth[i] = heroesHealth[i] - bossDamage;

        }
    }

    public static void printStatistics() {
        System.out.println(boss + bossHealth + " [ " + bossDamage + " ]");
        for (int i = 0; i < heroesNames.length; i++) {
            System.out.println(heroesNames[i] + " " + " Health " + " "
            +heroesHealth[i] + " Damage [ " + heroesStrike[i] + " superAbility " + " ]" );
        }
        System.out.println( "------------------------------------------------------");

    }
}
