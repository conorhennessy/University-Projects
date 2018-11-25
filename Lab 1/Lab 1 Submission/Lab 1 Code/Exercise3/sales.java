package Exercise3;

public class sales extends employee {
    protected String project;
    protected int numOfSales;
    protected int targetSales;

    public sales(String name, int salary, String dob, String project, int numOfSales, int targetSales){
        super(name, salary, dob);
        this.project = project;
        this.numOfSales = numOfSales;
        this.targetSales = targetSales;
    }

    public void information() {
        System.out.println("This is a member of the sales team named " + name + " working on " + project + " project with " + numOfSales + " Sales, with a target of" + targetSales + " Sales.");
    }
}
