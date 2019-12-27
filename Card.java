import java.util.*;
/**
 * Card class that holds a power and toughness. Also has
 * a cost which is a caluculation of both power and toughness
 * also has a method to weaken and boost the card by 10%
 * 
 * @author Blezyl Santos
 * @version 3.4 (March 4 2019)
 */
public class Card implements Comparable<Card>{
   private int power;
   private int toughness;
   /**
    * Card constructor that picks a random number and 
    * sets it both as the toughness and power
    */
   public Card(){
      Random rand = new Random();
      int num = rand.nextInt(1000)+1;
      power = num;
      toughness = num;
   }
   /**
    * Card constructor that sets both toughness and power
    * as the number passed through the parameters
    * @param x number of the power of toughness
    */
   public Card(int x){
      power = x;
      toughness = x;
   }
   /**
    * Card constructor that sets both toughness and power
    * as the number passed through the parameters
    * @param P number of the power
    * @param T number of toughness
    */
   public Card(int P, int T){ 
      power = P;
      toughness = T;
   }
   /**
    * @return power the power of the card
    */
   public int getPower(){
      return power;
   }
   /**
    * @return toughness the toughness of the card
    */
   public int getToughness(){
      return toughness;
   }
   /**
    * calculates the cost of the card by using a formula
    * using the power and toughness
    * @return cost the cost of the card
    */
   public int getCost(){
      int cost = Math.abs((int)Math.sqrt(1.5*power+0.9*toughness));
      return cost;
   }
   /**
    * @Override
    */
   public String toString(){
      return "[" + power + "/" + toughness + "]";
   }
   /**
    * implements the comparable class
    * first compares the cost of the cards
    * if the cost is equal checks the power
    * if the power is equal it checks the toughness
    * @param other card to be compared with
    * @return int the number if it is before or after the other card
    */
   public int compareTo(Card other){
      if (getCost() != other.getCost()){
         return getCost() - other.getCost();
      } else {
         if(power != other.power){
            return power - other.power;
         } else {
            return toughness - other.toughness;
         }
      }
   }
   /**
    * decreases the power and toughness of the card by 10%
    */
   public void weaken(){
       power -= power*(.1);
       toughness -= toughness*(.1);
   }
   /**
    * increases the power and toughness of the card by 10%
    */
   public void boost(){
      power += power*(.1);
      toughness += toughness*(.1);
   }
}