package Exercise3;

public class managers extends employee {
    protected String office;
    protected int numOfClients;
    protected int numOfProjects;

    public managers(String name, int salary, String dob, String office, int numOfClients, int numOfProjects){
        super(name, salary, dob);
        this.office = office;
        this.numOfClients = numOfClients;
        this.numOfProjects = numOfProjects;
    }

    public void information() {
        System.out.println("This is a manager named " + name + " based in " + office + " office with " + numOfClients + " Clients & " + numOfProjects + " Projects.");
    }

}
