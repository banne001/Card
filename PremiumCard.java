import java.util.*;
/**
 * Card class that is an extension of the Card class
 * only string method is changed
 * 
 * @author Blezyl Santos
 * @version 3.4 (March 4 2019)
 */

public class PremiumCard extends Card{
   /**
    * Premium Card constructor that picks a random number and 
    * sets it both as the toughness and power
    */
   public PremiumCard(){
      super();
   }
   /**
    * Premium Card constructor that sets both toughness and power
    * as the number passed through the parameters
    * @param x number of the power of toughness
    */
   public PremiumCard(int x){
      super(x);
   }
   /**
    * Premium Card constructor that sets both toughness and power
    * as the number passed through the parameters
    * @param P number of the power
    * @param T number of toughness
    */
   public PremiumCard(int P, int T){
      super(P, T);
   }
   /**
    * @Override
    */
   public String toString(){
      return "{{" + getPower() + "/" + getToughness() + "}}";
   }
}