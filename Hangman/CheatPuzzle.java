import java.util.ArrayList;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;


public class CheatPuzzle
{
        public static String  Word = "";
   public static String BadGuess = "";
       public static ArrayList<String> Words = new ArrayList<String>();
       public static ArrayList<String> GoodGuess = new ArrayList<String>();
       public static int Difficulty = 300;
         public static int guess =0;
       
 public CheatPuzzle(){
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
    }
    
     public static boolean makeGuess(String a){
           a = a.toUpperCase();
           if(a.length() > 1)return false;
           
          if(Words.size() >= Difficulty){
           for(int i = Words.size()-1; i >= 0; i--){
             if(Words.get(i).indexOf(a) >= 0)Words.remove(i);
            if(Words.size() <= Difficulty){
             Word = Words.get((int)(Math.random()*Words.size()));   
            }
            }
             for(int z = 0; z < Word.length(); z++){
                 GoodGuess.add("_");  
                }
            BadGuess += a+", ";
             return false;     
        }
            else{
            
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
        }
    
        
          public void show(){
              System.out.println("Incorrect guesses: "+BadGuess);
              //System.out.println(Words.size());
        if(Words.size() <= Difficulty)System.out.println("Puzzle: "+GoodGuess);
    } 
    
        
         public static boolean isUnsolved(){
             // System.out.println("WELL");
     if(Words.size() >= Difficulty)return true;
     //System.out.println("SHIT");
      for(int i = 0; i < Word.length(); i++){
     if(!Word.substring(i,i+1).equalsIgnoreCase(GoodGuess.get(i)))return true;
    } 
     return false;   
    }
        
         public static String getWord(){
             if(Word.equalsIgnoreCase(""))Word = Words.get((int)(Math.random()*Words.size()));   
    return Word;
    }
}
