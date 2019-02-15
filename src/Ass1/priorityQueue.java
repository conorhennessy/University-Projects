package Ass1;

class pqCell {
    String data;
    int priority;
    pqCell next;

    public pqCell(String data, int priority, pqCell pq){
        this.data = data;
        this.priority = priority;
        next = pq;
    }
}


public class priorityQueue{
    private pqCell front;

    public void createpq(){
        front = null;
    }

    public boolean isempty(){
        return front == null ? true : false;
    }

    public String front(){
        return front.data;
    }

    public void deletefront(){
        if (length() == 0) System.out.println("The list is empty and so unable to remove the front!");
        front = front.next;
    }

    public int frontpri(){
        return front.priority;
    }

    public void addtopq(String data, int priority){
        //TODO
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("<");
        pqCell c = front;
        while (c != null) {
            sb.append("\"" + c.data + "\":" + c.priority);
            if (c.next != null){
                sb.append(",");
            }
            c = c.next;
        }
        return(sb+">");
    }


    //This is an additional operation too help with the finding of the length of the pq
    public int length() {
        pqCell c = front;
        int result = 0;
        while (c != null) {
            result++;
            c = c.next;
        }
        return result;
    }

    public static void main(String[] args) {
        priorityQueue myPriorityQueue = new priorityQueue();

    }
}
