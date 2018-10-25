package topica.edu.vn.ui;

import java.util.ArrayList;


public class Dictionary {

	 private ArrayList<Word> list_word = new ArrayList<Word>();
	
	    public Dictionary() {
	    	

	    }
	    public ArrayList<Word> getList_word(){
	        return this.list_word;
	    }

	    public void addWord(Word word){
	        this.list_word.add(word);
	    }
	  
}
