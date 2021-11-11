import java.util.Scanner;

public class Queue
{
    int head = 0;
    int tail = 0;

    String array[] = new String[10];

    public static void main (String args[])
    {
        Scanner InputFromUser = new Scanner(System.in);

        Queue make_call = new Queue();
        
        int choice = 0;
        
        do
        {
         
            System.out.println("\nChoose an operation: ");
            System.out.println("1. ENQUEUE\n2. DEQUEUE\n3. EMPTY\n");

            choice = InputFromUser.nextInt();
            if (choice == 1)
            {
                make_call.enqueue();
            }

            else if (choice == 2)
            {
                make_call.dequeue();
            }

            else if (choice == 3)
            {
                System.out.println( make_call.isEmpty() );
            }

            else
            {
                System.out.println("Wrong input!");
            }

        }
        
        while (choice > 0 && choice < 4);
    }


    boolean isEmpty()
    {

        if (head == tail )
        {
            return true;
        }

        else
        {
            return false;
        }
    }


    boolean isFull()
    {

        if (head == array.length - 1)
        {
            return true;
        }

        else
        {
            return false;
        }

    }

    void enqueue()
    {

        Scanner InputFromUser = new Scanner(System.in);

        System.out.print("\nEnter a string to insert into the queue : ");
        String data = InputFromUser.next();
        
        array[tail] = data; 

        if ( tail  == array.length - 1)
        {
            
            tail = 0;
        
        }

        else
        {
            tail = tail + 1;
        }
    
    }


    void dequeue()
    {

        String dequeued_data = array[head];

        if ( head  == array.length - 1)
        {
            head = 1;
        }

        else
        {

            head = head + 1;

        }

        System.out.println(dequeued_data);
    }
}