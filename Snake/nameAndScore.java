public class nameAndScore implements Comparable<nameAndScore> {
    String name;
    int score;

    //constructor to put the name and score items together for the new nameAndScore objects
    public nameAndScore(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(nameAndScore nameAndScore) {
        if (nameAndScore.score < this.score){
            return -1;
        }
        if (nameAndScore.score > this.score){
            return 1;
        }
        else
            return 0;
    }

    @Override
    public String toString(){
        return score + "   " + name + "<br/>";  //method to parse the attributes of the object into a format ready for the leader board. html tags used in the place of \n for newline in the Label.
    }

}