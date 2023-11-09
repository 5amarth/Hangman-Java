import java.util.*;

public class hangman{
    static int lives;
    static int count =0;
    static String word;
    static String dashedWord = " ";
    static char[] c ;
    static char[] usedChar = new char[26];
    public static void main(String[] args){
        randomwordgen.Initialize();
        lives = 7;
        Scanner s = new Scanner(System.in);
        System.out.println(DashMaker());
        while(DashChecker() == false && lives !=0){
            System.out.print("Enter your letter choice :  ");
            char choice = s.next().toLowerCase().charAt(0);
            System.out.println(DashChanger(choice));
            System.out.println("Used Characters are : ");
            for(int i =0; i<count; i++){
                System.out.println(usedChar[i]+ ", ");
            }
            if(lives ==0){
                System.out.println("You lose the word was : " + word);
            }
            if (DashChecker()== true){
                System.out.println("Congrats you won!!!");
            }

        }
        s.close();
    }

    public static String DashChanger(char choice){
        StringBuilder string = new StringBuilder(dashedWord);
        if(CharChecker(choice)== false){
            lives--;
            usedChar[count] = choice;
            count++;
            return "Wrong, You lost a life! You have " + lives + " lives left" + "\n" + dashedWord;
        }
        else{
            for(int i =0; i<c.length; i++){
                if(choice == c[i]){
                    string.setCharAt((2*i)+1, choice);
                }
            }
            usedChar[count] = choice;
            count++;
            dashedWord = string.toString();
            return dashedWord;
        }
    }
    
    public static boolean DashChecker(){
        String newstr = "";
        for(int i =0; i<dashedWord.length(); i++){
            if(dashedWord.charAt(i) != ' '){
                newstr = newstr + dashedWord.charAt(i);
            }
        }
        if(newstr.equals(word)){
            return true;
        }
        return false;
    }

    public static String DashMaker(){
        word = WordChooser();
        for(int i =0; i<word.length();i++){
            dashedWord = dashedWord + "_";
            dashedWord = dashedWord + " ";
        }

        return dashedWord;
    }

    public static String WordChooser(){
        Random r = new Random();
        int a = r.nextInt(10000);
        return randomwordgen.words[a];
    }

    public static Boolean CharChecker(char choice){
        c = word.toCharArray();
        for(int i=0; i<c.length; i++){
            if(choice == c[i]){
                return true;
            }
        }
        return false;      
    }

}