import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * POO HOMEWORK Ordonarea a pasagerilor
 * @author Keti Duracoska
 * @since 11.11.2019
 *
 */
public class Main
{
    static int priority(String id, String tip_bilet, String imb_pri, String nev_spec, int age)
    {
        int priority = 0;
        if (tip_bilet.equals("b"))
        {
            priority += 35;
        }
        if (tip_bilet.equals("p"))
        {
            priority += 20;
        }
        if (imb_pri.equals("true"))
        {
            priority += 30;
        }
        if (nev_spec.equals("true"))
        {
            priority += 100;
        }
        if (age >= 0 && age < 2)
        {
            priority += 20;
        }
        if (age >= 2 && age < 5)
        {
            priority += 10;
        }
        if (age >= 5 && age < 10)
        {
            priority += 5;
        }
        if (age >= 60)
        {
            priority += 15;
        }
        return priority;
    }
    public static void main(String[] args) throws IOException
    {
        String id, name, tip_bilet, imb_pri, nev_spec, command, ins_arg;
        int nr_pass, age, priority, i, j,added=0,same;
        ArrayList<Passenger> list = new ArrayList<Passenger>();

        File file = new File("queue.in");
        PrintStream file_write = new PrintStream("queue.out");
        System.setOut(file_write);
        Scanner scan = new Scanner(file);

        nr_pass = scan.nextInt();

        for (i = 0; i < nr_pass; i++)
        {
            same = 0;
            id = scan.next();
            name = scan.next();
            age = scan.nextInt();
            tip_bilet = scan.next();
            imb_pri = scan.next();
            nev_spec = scan.next();
            priority = priority(id, tip_bilet, imb_pri, nev_spec, age);
            Passenger passenger = new Passenger(id,name,age,tip_bilet,imb_pri,nev_spec,priority);
            if(id.charAt(0) == 'f')
            {
                 passenger = new Family(id,name,age,tip_bilet,imb_pri,nev_spec,priority);
            }
            else if(id.charAt(0) == 'g')
            {
                 passenger = new Group(id,name,age,tip_bilet,imb_pri,nev_spec,priority);
            }
            else if(id.charAt(0) == 's')
            {
                 passenger = new Singur(id, name, age, tip_bilet, imb_pri, nev_spec, priority);
            }
            if (added == 0)
            {
                list.add(passenger);
                added++;
            }
            else if (added == 1)
            {
                for (j = 0; j < list.size(); j++)
                {
                    if (list.get(j).id.equals(id))
                    {
                        list.get(j).priority += priority;
                        same++;
                    }
                }
                if (same == 0)
                {
                    list.add(passenger);
                }
            }
        }
        MaxHeap heap = new MaxHeap();
        while (scan.hasNext())
        {
            command = scan.next();
            if (command.equals("insert"))
            {
                ins_arg = scan.next();
                for (i = 0; i < list.size(); i++)
                {
                    if (list.get(i).id.equals(ins_arg))
                    {
                        heap.insert(list.get(i), list.get(i).priority);
                        break;
                    }
                }
            }
            if (command.equals("embark"))
            {
                heap.embark();
            }
            if (command.equals("list"))
            {
                if (scan.hasNext())
                {
                    heap.list();
                    System.out.println();
                }
                else
                {
                    heap.list();
                }
            }
            String del_arg;
            if(command.equals("delete"))
            {
                del_arg=scan.next();
                for (i = 0; i < list.size(); i++)
                {
                    if (list.get(i).id.equals(del_arg))
                    {
                        heap.delete(list.get(i));
                        break;
                    }
                }
            }
        }
        scan.close();
        file_write.close();
    }
}
