import java.util.Scanner;


public class Stack
{
    int bottom = 0;
    int top = -1;

    String array[] = new String[10];

    public static void main (String args[])
    {
        Scanner InputFromUser = new Scanner(System.in);

        Stack make_call = new Stack();
        
        int choice = 0;
        
        do
        {
         
            System.out.println("\nChoose an operation: ");
            System.out.println("1. PUSH\n2. POP\n3. EMPTY\n");

            choice = InputFromUser.nextInt();
            if (choice == 1)
            {
                make_call.push();
            }

            else if (choice == 2)
            {
                make_call.pop();
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

        if (top == -1 )
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

        if (top == array.length - 1)
        {
            return true;
        }

        else
        {
            return false;
        }

    }

    void push()
    {

        if ( isFull() == false )
        {
            Scanner InputFromUser = new Scanner(System.in);

            System.out.print("\nEnter a string to push into the stack : ");
            String data = InputFromUser.next();

            top = top + 1;

            array[top] = data;
        
        }

        else
        {
            System.out.println("\nStack is full! overflow");
        }
    
    }


    void pop()
    {

        if ( isEmpty() == false)
        {

            top = top - 1;
            System.out.println(array[top + 1]);
            
        }

        else
        {

            System.out.println("\nStack is empty! underflow");

        }

    }
}