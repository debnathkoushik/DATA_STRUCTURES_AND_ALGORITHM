package LinkedListExecution;

import java.util.Scanner;

public class LinkedList
{
    Node head = null;
    Node tail = null;

    int number_of_nodes = 0;
    
    void addNewNode(int data)
    {
        Node new_node = new Node(data);

        if (head == null)
        {
            head = new_node;
            tail = new_node;
        }

        else
        {
            tail.next_address = new_node;
            tail = new_node;
        }
    }


    void dispaly()
    {
        Node current_node = head;

        while(current_node != null)
        {
            System.out.println(current_node.data);
            current_node = current_node.next_address;
            
            number_of_nodes++;
        }

        System.out.println("There are total " + number_of_nodes + " nodes.");
    }


    void delete()
    {
        System.out.println("There are total " + number_of_nodes + " nodes.\nWhich position you want to delete ?");
        Scanner InputFromUser = new Scanner(System.in);
        int choice = InputFromUser.nextInt();

        int count = 0;
        
        if (choice > 0 && choice <= number_of_nodes)
        {
            Node current_node = head;

            while(current_node != null)
            {
                if ( choice - 1 == count )
                {
                        head = head.next_address;

                        dispaly();
                        System.out.println("There are total " + number_of_nodes + " nodes.");
                }

                else if (count + 2 == choice)
                {
                    Node temp_1 = current_node;
                    current_node = current_node.next_address;
                    Node temp_2 = current_node.next_address;
                    current_node.next_address = null;
                    current_node = temp_1;
                    current_node.next_address = temp_2;

                    dispaly();
                    System.out.println("There are total " + number_of_nodes + " nodes.");
                }

                else if ( choice == number_of_nodes - 1 && count == number_of_nodes - 1 )
                {
                    tail = current_node;
                    current_node.next_address = null;

                    dispaly();
                    System.out.println("There are total " + number_of_nodes + " nodes.");
                }

                else
                {
                    count++;
                    current_node = current_node.next_address;
                }
            }
        }

        else
        {
            System.out.println("Wrong Input!");
        }
    }

    public static void main(String args[])
    {
        LinkedList new_node = new LinkedList();

        new_node.addNewNode(10);
        new_node.addNewNode(20);
        new_node.addNewNode(30);
        new_node.addNewNode(40);
        new_node.addNewNode(50);

        new_node.dispaly();

        new_node.delete();

    }
}