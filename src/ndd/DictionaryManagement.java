package ndd;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryManagement {
    Scanner sc = new Scanner(System.in);
    private Dictionary myDictionary;
    public DictionaryManagement(){
        this.myDictionary = new Dictionary();
    }

    public ArrayList<Word> getDataDictionary(){
        return this.myDictionary.getList_word();
    }

    /**
     * type word
     */
    public void insertFromCommandLine() {

        // number of words
        System.out.print("number of words is : ");
        int number_vocabulary = sc.nextInt();
        sc.nextLine();
        // type from keyboard
        for (int i = 0; i < number_vocabulary; i++) {
            System.out.print("type English word : ");
            String english = sc.nextLine().toLowerCase();
            System.out.print("type Vietnamese word : ");
            String vietnamese = sc.nextLine().toLowerCase();
            Word newWord = new Word(english,vietnamese);
            this.myDictionary.addWord(newWord);
        }
    }

    /**
     * from *txt
     */
        public void insertFromFile(){
            String line = null ;
            try{
                FileReader docFile = new FileReader(
                        "src\\dictionaries.txt");
                BufferedReader bfr = new BufferedReader(docFile);
                while((line= bfr.readLine())!= null ){
                    String E ="";
                    String V = "";
                    String []lineWord = line.split("\t");
                    E = lineWord[0];
                    V = lineWord[1];
                    Word word = new Word(E,V);
                    this.myDictionary.addWord(word);
                }
                bfr.close();
            }
            catch (Exception ex ){
                ex.printStackTrace();
                System.out.println("eror");
            }
        }
    /**
     * Dictionary lookup by commandline
     */

        public String dictionaryLookup() {
            String not = "can't lookup Eng";
            ArrayList<Word> myListWord = this.getDataDictionary();

            System.out.print("Search English: ");
            String look_word = sc.nextLine().toLowerCase();

            for (Word word : myListWord) {
                if (look_word.equals(word.getWord_taget().toLowerCase())) {
                    not = word.getWord_explain();
                }
            }
            return not;
        }



    /**
     * add,set,delete
     */
    /*public void ASD(){
        ArrayList<Word> myListWord = this.getDataDictionary();

        System.out.print("You need? add ? set ? delete ? ");
        String need = sc.nextLine().toLowerCase();
        switch (need) {
            case "add": {
                System.out.println("add word : ");
                System.out.print("add E : ");
                String addE = sc.nextLine().toLowerCase();
                System.out.println();
                System.out.print("add Vietnamese : ");
                String addV = sc.nextLine().toLowerCase();
                Word addWord = new Word(addE, addV);
                myListWord.add(addWord);

            }
            break;
            case "set": {
                System.out.println("set word : ");
                String setWord = sc.nextLine().toLowerCase();
                for(int i =0;i<myListWord.size();i++){
                    if(setWord.equals(myListWord.get(i).getWord_taget())){
                        System.out.println("type change :" );
                        String changeWord = sc.nextLine().toLowerCase();
                        myListWord.get(i).setWord_explain(changeWord);
                        System.out.println("last change : "+myListWord.get(i));
                    }
                    else {
                        System.out.println("eror");
                    }
                }
            } break;
            case "delete" :{
                System.out.println("delete word : ");
                String deleteE = sc.nextLine().toLowerCase();
                for(int i =0;i<myListWord.size();i++) {
                    if (deleteE.equals(myListWord.get(i).getWord_taget())) {
                        myListWord.remove(i);
                        break;
                    }
                    else {
                        System.out.println("eror");
                    }
                }
            }break;
            default:
                System.out.println("null"); break;
        }
    }*/

    /**
     * insert
     */
    public void insert (){
        System.out.println("new word ");
        System.out.print("Write target word: ");
        String target = sc.nextLine().toLowerCase();
        System.out.print("Write explain that word : ");
        String explain = sc.nextLine().toLowerCase();
        Word newWord = new Word(target,explain);
        this.myDictionary.addWord(newWord);
    }

    /**
     * thay đổi từ
     */
    public void change(){
        System.out.print("Write the word which you want to change : ");
        String changeWord = sc.nextLine().toLowerCase();
        for(Word word: this.getDataDictionary()){
            if(changeWord.equals(word.getWord_taget())){
                System.out.print("Change word to: ");
                String change_word = sc.nextLine().toLowerCase();
                System.out.print("Change explain to: ");
                String change_explain = sc.nextLine().toLowerCase();
                word.setWord_taget(change_word);
                word.setWord_explain(change_explain);
                System.out.print("Word changed : "+word.toString());
            }
            else{
                System.out.println("Don't find the word!");
            }
        }
    }

    /**
     * delete word
     */
    public void delete (){
        System.out.print("Write the word which you want to delete : ");
        String delete = sc.nextLine().toLowerCase();
        for(Word word: this.getDataDictionary()){
            if(delete.equals(word.getWord_taget())){
                this.getDataDictionary().remove(word);
            }
        }
    }

    public void dictionaryExportToFile(){
        try
        {
            FileOutputStream fos=new FileOutputStream("src\\dictionaries");
            OutputStreamWriter osw=new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter bw=new BufferedWriter(osw);
            for(Word word: this.getDataDictionary())
            {
                String line = word.getWord_taget()+"\t"+word.getWord_explain();
                bw.write(line);
                bw.newLine();
            }
            bw.close();
            osw.close();
            fos.close();

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}



