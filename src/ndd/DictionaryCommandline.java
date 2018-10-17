package ndd;

import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryCommandline {
    Scanner sc = new Scanner(System.in);
    private DictionaryManagement myDictionaryManager;

    public DictionaryCommandline() {
        this.myDictionaryManager = new DictionaryManagement();
    }

    /**
     * show English
     */
    public void showAllWords() {
        System.out.println("No\t|English\t|Vietnamese");
        ArrayList<Word> myListWord = this.myDictionaryManager.getDataDictionary();
        for (int i = 0; i < myListWord.size(); i++) {
            Word word = myListWord.get(i);
            System.out.print(i + 1);
            System.out.print("\t|" + word.getWord_taget() + "\t|" + word.getWord_explain());
            System.out.println();
        }
    }

    /**
     * mention insert and show
     */
    public void dictionaryBasic() {
        this.myDictionaryManager.insertFromCommandLine();
        showAllWords();
    }
    public void dictionarySeacher() {
        ArrayList<Word> myListWord = this.myDictionaryManager.getDataDictionary();

        System.out.print("Enter the word want search : ");
        String splitE = sc.nextLine().toLowerCase();
        int length = splitE.length();
        if(length==1){
            for(Word word : myListWord){
                String cut = word.getWord_taget().substring(0,1);
                if(splitE.equals(cut)){
                    System.out.println(word.getWord_taget());
                }
            }
        }
        if(length==2){
            for(Word word : myListWord){
                String cut = word.getWord_taget().substring(0,2);
                if(splitE.equals(cut)){
                    System.out.println(word.getWord_taget());
                }
            }
        }
        if(length==3){
            for(Word word : myListWord){
                String cut = word.getWord_taget().substring(0,3);
                if(splitE.equals(cut)){
                    System.out.println(word.getWord_taget());
                }
            }
        }
        if(length==4){
            for(Word word : myListWord){
                String cut = word.getWord_taget().substring(0,4);
                if(splitE.equals(cut)){
                    System.out.println(word.getWord_taget());
                }
            }
        }
    }

    /**
     * mention insert, show, lookup
     */
    public void dictionaryAdvanced() {

        try{
            this.myDictionaryManager.insertFromFile();
            showAllWords();
            System.out.println("Menu : ");
            System.out.println("1: Translate");
            System.out.println("2: Insert word");
            System.out.println("3: Change word");
            System.out.println("4: Delete word");
            System.out.println("5: Quit");
            System.out.println("Pl your choise : ");
            int choise = sc.nextInt();

            switch (choise){
                case 1 : {


                    System.out.print("Do you want to continue :y/n ");
                    String choi = sc.nextLine().toLowerCase();
                    if(choi.equals("y")){
                        dictionarySeacher();
                    }
                    else {
                        break;
                    }

                } break;

                case 2 : {

                    System.out.print("Do you want to continue :y/n ");
                    String choi = sc.nextLine().toLowerCase();
                    if(choi.equals("y")){
                        this.myDictionaryManager.insert();
                    }
                    else {
                        break;
                    }
                } break;

                case 3 :{

                    System.out.print("Do you want to continue :y/n ");
                    String choi = sc.nextLine().toLowerCase();
                    if(choi.equals("y")){
                        this.myDictionaryManager.change();
                    }
                    else {
                        break;
                    }
                } break;

                case 4 :{

                    System.out.print("Do you want to continue :y/n ");
                    String choi = sc.nextLine().toLowerCase();
                    if(choi.equals("y")){
                        this.myDictionaryManager.delete();
                    }
                    else {
                        break;
                    }
                } break;

                case 5 : {
                    System.exit(0);
                } break;
                default: System.out.print("null");  break;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
