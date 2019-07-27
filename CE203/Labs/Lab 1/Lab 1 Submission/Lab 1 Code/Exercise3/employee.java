package Exercise3;

public abstract class employee {
    protected String name;
    protected int salary;
    protected String dob;

    public employee(String name, int salary, String dob) {
        this.name = name;
        this.salary = salary;
        this.dob = dob;
    }

    public void details() { System.out.println("\nI am an employee called " + name + ", with a salary of " + salary + " and DofB of " + dob); }

    public abstract void information();

}
