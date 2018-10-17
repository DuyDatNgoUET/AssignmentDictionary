package ndd;

public class Word {
    private String word_taget;
    private String word_explain;

    public Word() {
    }

    public Word(String word_taget, String word_explain) {
        this.word_taget = word_taget;
        this.word_explain = word_explain;
    }

    public String getWord_taget() {
        return word_taget;
    }

    public void setWord_taget(String word_taget) {
        this.word_taget = word_taget;
    }

    public String getWord_explain() {
        return word_explain;
    }

    public void setWord_explain(String word_explain) {
        this.word_explain = word_explain;
    }
    public String toString(){
        return getWord_taget()+"\t"+getWord_explain();
    }
}
