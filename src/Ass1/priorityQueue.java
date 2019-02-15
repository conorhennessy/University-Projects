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

class pqListException extends RuntimeException {
    public pqListException(String s) { super(s); }
}

public class priorityQueue{
    private pqCell front;

    public void priorityQueue(){
        front = null;
    }

    public boolean isempty(){
        return front == null ? true : false;
    }

    public String front(){
        if (isempty()) {
            throw new pqListException("The list is empty and so unable to find the front values's data!");
        }
        return front.data;
    }

    public void deletefront(){
        if (isempty()) {
            throw new pqListException("The list is empty and so unable to remove the front item!");
        }
        front = front.next;
    }

    public int frontpri(){
        if (isempty()) {
            throw new pqListException("The list is empty and so unable to find the front value priority!");
        }
        return front.priority;
    }

    public void addtopq(String data, int priority){
        if (20 <= priority && priority <= 1){
            throw new pqListException("Priority is not in the range of 1 to 20!");
        }
        if (isempty()){
            front = new pqCell(data, priority, front);
        }
        else {
            pqCell c = front;
            while (c != null) {
                if (c.next == null){  //it is adding to the end. So just add it and all done
                    c.next = new pqCell(data, priority, null);
                    break;
                }
                if (priority < c.next.priority){
                    c.next = new pqCell(data, priority, c.next);
                    break;
                }
                c = c.next;
            }
        }
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


    public static void main(String[] args) {
        priorityQueue myPriorityQueue = new priorityQueue();

        myPriorityQueue.addtopq("apple", 1);
        System.out.println(myPriorityQueue);

        myPriorityQueue.addtopq("orange", 3);
        myPriorityQueue.addtopq("pineapple", 7);
        System.out.println(myPriorityQueue);

        myPriorityQueue.addtopq("mango", 4);
        System.out.println(myPriorityQueue);

        myPriorityQueue.addtopq("kiwi", 3);
        System.out.println(myPriorityQueue);

        myPriorityQueue.addtopq("guava", 3);
        System.out.println(myPriorityQueue);

    }
}
