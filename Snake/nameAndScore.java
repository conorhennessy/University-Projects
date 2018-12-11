public class nameAndScore implements Comparable<nameAndScore> {
    String name;
    int score;

    public nameAndScore(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(nameAndScore nameAndScore) {
        return name.compareTo(String.valueOf(nameAndScore.score));
    }

    @Override
    public String toString(){
        return score + "   " + name + "<br/>";
    }

}