package Exercise3;

public class development extends employee {
    protected String idea;
    protected String topic;
    protected int experience;

    public development(String name, int salary, String dob, String idea, String topic, int experience){
        super(name, salary, dob);
        this.idea = idea;
        this.topic = topic;
        this.experience = experience;
    }

    public void information() {
        System.out.println("This is a member of the development team named " + name + " working on " + idea + " idea with a " + topic + " topic, with an experience level of" + experience + " Sales.");
    }
}
