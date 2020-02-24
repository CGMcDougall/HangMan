import java.util.ArrayList;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Puzzle
{
   public static String  Word = "";
   public static String BadGuess = "";
   public static ArrayList<String> GoodGuess = new ArrayList<String>();
 public static ArrayList<String> Words = new ArrayList<String>();
   public static int guess =0;
  
   public Puzzle(){
       try{
         File file = new File("words.txt");
           Scanner scanner = new Scanner(file);
       HangingMan.addLife(3);
        
           while(scanner.hasNext()){
             String tempWord = scanner.next().toUpperCase();
             Words.add(tempWord);
            }
        scanner.close();
      
             }
        catch(FileNotFoundException e){System.out.println("No File Found");}   
       
       Word = Words.get((int)(Math.random() * Words.size()));
       Word = Word.toUpperCase();
      for(int i = 0; i < Word.length(); i++){
     GoodGuess.add("_");  
    }  
    }
    
    
  public void show(){
     System.out.println("Incorrect guesses: "+BadGuess);
       System.out.println("Puzzle: "+GoodGuess);
    } 
    
    
    public static boolean isUnsolved(){
      for(int i = 0; i < Word.length(); i++){
     if(!Word.substring(i,i+1).equalsIgnoreCase(GoodGuess.get(i)))return true;
    } 
     return false;   
    }
    
     public static boolean makeGuess(String a){
         a = a.toUpperCase();
         
         
     if(a.length() >= 2){
           for(int i = 0; i < Word.length(); i++){
               if(!Word.substring(i,i+1).equalsIgnoreCase(a.substring(i,i+1))){
                 
                System.out.println("test");
                  return false;
                }
     
            } 
           for(int i = 0; i < Word.length(); i++){
               GoodGuess.set(i,Word.substring(i,i+1));
            }
            return true;
        }
        
     while(Word.indexOf(a,guess) >= 0){
        GoodGuess.set(Word.indexOf(a,guess), a);
        guess = Word.indexOf(a,guess) +1;
        if(guess >= Word.length())break;
        }
        if(guess >= 1){
         guess = 0;   
            return true; 
        }
        guess = 0;   
        BadGuess += a+", ";
        return false;
        
    }
    public static String getWord(){
     return Word;   
    }
    
}
