public class nameAndScore implements Comparable<nameAndScore> {
    String name;
    int score;

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
        return score + "   " + name + "<br/>";
    }

}