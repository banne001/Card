import java.util.*;
/**
 * Card List that holds an array of cards. 
 * 
 * 
 * @author Blezyl Santos
 * @version 3.4 (March 4 2019)
 */

public class CardArrayList{
   private Card[] cardArray;
   private int size;
   
   public CardArrayList(){
      cardArray = new Card[10];
      size = 0;
   }
   public CardArrayList(int x ){
      if(x<0) throw new IllegalArgumentException();
      cardArray = new Card[x];
      size=0;
   }   
   public String toString(){
      String answer = "[0: "+ cardArray[0];
      for( int i=1;i<size;i++){
         answer += "," + cardArray[i] ;
      } 
      answer += ":" + size + "]";
      return answer;
   }
   public int size(){
      return size;
   }
   public void add(Card x){
      if(isRoom()) expand();
      cardArray[size] = x;
      size++;
   }
   
   public Card remove(){
      size--;
      return cardArray[size];
   }
   
   public Card get(int x){
      if (x >= size) throw new IllegalArgumentException();
      else return cardArray[x];
   }   
   
   public int indexOf(Card x){
      for( int i = 0; i<size;i++){
         if (cardArray[i].compareTo(x)==0){
            return i-1;
         }
      } return -1;
   } 
   
   public void add(int L, Card X){
      if(L>size){ throw new IllegalArgumentException();
      } else if (L == size){
         if(isRoom()) expand();
         add(X);
      } else {
         if(isRoom()) expand();
         for (int i=size; i>=L+1;i--){
            cardArray[i] = cardArray[i-1];
         }  
         cardArray[L] = X;
         size++;
      }
   }
   public Card remove(int j){
      Card temp = cardArray[j];
      if (j > size) {throw new IllegalArgumentException();
      }else if(j==size){ 
         remove();
      }else{
         for (int i = j; i < size - 1; i++){
            cardArray[i] = cardArray[i+1];
         }
         size--;
      }  return temp;
   }
   public void sort(){
      Card[] left = Arrays.copyOfRange(cardArray, 0, size/2);
      Card[] right = Arrays.copyOfRange(cardArray, size/2, size);
      mergeSort(left);
      mergeSort(right);
      merge (cardArray, left, right);
   }
   public void mergeSort(Card[] x){
      if (size>=2){
         Card[] left = Arrays.copyOfRange(x, 0, x.length/2);
         Card[] right = Arrays.copyOfRange(x, x.length/2, x.length);
         mergeSort(left);
         mergeSort(right);
         
         merge (x, left, right); 
      }
   }
   public void merge(Card[] x, Card[] left, Card[] right){
      int i1 = 0;
      int i2 = 0;
      int s = left.length + right.length; 
      for (int i = 0; i<s;i++){
         if ( i2 >= right.length ||
               i1 < left.length && left[i1].compareTo(right[i2]) > 0){
                  x[i] = left[i1];
                  i1++;
         } else {
            x[i] = right[i2];
            i2++;
         }
      }
   }

   public void shuffle(){
      Random rand = new Random();
      swap(0,size-1);
      for(int i=0;i<5*size;i++){
         int a = rand.nextInt(size-1);
         int b = rand.nextInt(size-1);
         swap(a,b);
      }
   }
   private boolean isRoom(){
      if (cardArray[cardArray.length-1]!=null) return true;
      else return false;
   }
   private void expand(){
      int num = cardArray.length*2;
      Card[] temp = new Card[num];
      for(int i=0; i<cardArray.length;i++){
         temp[i] = cardArray[i];
      }
      cardArray = temp;
   }
   private void swap(int a, int b){
      Card temp = cardArray[a];
      cardArray[a] = cardArray[b];
      cardArray[b] = temp;
   }
   public void clear(){
      cardArray = new Card[10];
      size=0;
   }
   
}