import java.util.ArrayList;
class MaxHeap
{
    ArrayList<Passenger> list = new ArrayList<Passenger>();
    int parent_index(int i)
    {
        return (i-1)/2;
    }
    int left_index(int i)
    {
        return (2*i+1);
    }
    int right_index(int i)
    {
        return (2*i+2);
    }
    void heapify_down(int i)
    {
        int left=left_index(i);
        int right=right_index(i);
        int root=i;
        if( left < list.size() && list.get(left).priority> list.get(i).priority)
        {
            root=left;
        }
        if(right < list.size() && list.get(right).priority > list.get(root).priority)
        {
            root=right;
        }
        if(root!=i)
        {
            String temp_id=list.get(i).id;
            String temp_name=list.get(i).name;
            int temp_age=list.get(i).age;
            String temp_tip_bilet=list.get(i).tip_bilet;
            String temp_imb_pri=list.get(i).imb_pri;
            String temp_nev_spec=list.get(i).nev_spec;
            int temp_priority=list.get(i).priority;

            list.get(i).id=list.get(root).id;
            list.get(i).name=list.get(root).name;
            list.get(i).age=list.get(root).age;
            list.get(i).tip_bilet=list.get(root).tip_bilet;
            list.get(i).imb_pri=list.get(root).imb_pri;
            list.get(i).nev_spec=list.get(root).nev_spec;
            list.get(i).priority=list.get(root).priority;

            list.get(root).id=temp_id;
            list.get(root).name=temp_name;
            list.get(root).age=temp_age;
            list.get(root).tip_bilet=temp_tip_bilet;
            list.get(root).imb_pri=temp_imb_pri;
            list.get(root).nev_spec=temp_nev_spec;
            list.get(root).priority=temp_priority;

            heapify_down(root);
        }
    }
    void heapify_up(int i)
    {
        int parent=parent_index(i);
        if(list.get(parent).priority < list.get(i).priority)
        {
            String temp_id=list.get(i).id;
            String temp_name=list.get(i).name;
            int temp_age=list.get(i).age;
            String temp_tip_bilet=list.get(i).tip_bilet;
            String temp_imb_pri=list.get(i).imb_pri;
            String temp_nev_spec=list.get(i).nev_spec;
            int temp_priority=list.get(i).priority;

            list.get(i).id=list.get(parent).id;
            list.get(i).name=list.get(parent).name;
            list.get(i).age=list.get(parent).age;
            list.get(i).tip_bilet=list.get(parent).tip_bilet;
            list.get(i).imb_pri=list.get(parent).imb_pri;
            list.get(i).nev_spec=list.get(parent).nev_spec;
            list.get(i).priority=list.get(parent).priority;

            list.get(parent).id=temp_id;
            list.get(parent).name=temp_name;
            list.get(parent).age=temp_age;
            list.get(parent).tip_bilet=temp_tip_bilet;
            list.get(parent).imb_pri=temp_imb_pri;
            list.get(parent).nev_spec=temp_nev_spec;
            list.get(parent).priority=temp_priority;
            heapify_up(parent);
        }
    }
    int print=0;
    void insert(Passenger p,int priority)
    {
            list.add(p);
            heapify_up(list.size()-1);
            print++;
    }
    void embark()
    {
        list.get(0).id=list.get(list.size()-1).id;
        list.get(0).name=list.get(list.size()-1).name;
        list.get(0).age=list.get(list.size()-1).age;
        list.get(0).tip_bilet=list.get(list.size()-1).tip_bilet;
        list.get(0).imb_pri=list.get(list.size()-1).imb_pri;
        list.get(0).nev_spec=list.get(list.size()-1).nev_spec;
        list.get(0).priority=list.get(list.size()-1).priority;

        list.remove(list.size()-1);
        heapify_down(0);
        print--;
    }
    int printed=1;

    void PreorderRec(int root)
    {
        if(root>=list.size())
        {
            return;
        }
        if(print!=printed)
        {
            System.out.print(list.get(root).id+" ");
            printed++;
        }
        else
        {
            System.out.print(list.get(root).id);
            printed++;
        }
        PreorderRec(2*root+1);
        PreorderRec(2*root+2);
    }
    void list()
    {
        PreorderRec(0);
        printed=1;
    }
    int i;
    void delete(Passenger p)
    {
        for (i = 0; i < list.size(); i++)
        {
            if(p.id.equals(list.get(i).id))
            {
                list.get(i).id=list.get(list.size()-1).id;
                list.get(i).name=list.get(list.size()-1).name;
                list.get(i).age=list.get(list.size()-1).age;
                list.get(i).tip_bilet=list.get(list.size()-1).tip_bilet;
                list.get(i).imb_pri=list.get(list.size()-1).imb_pri;
                list.get(i).nev_spec=list.get(list.size()-1).nev_spec;
                list.get(i).priority=list.get(list.size()-1).priority;
                list.remove(list.size()-1);
                heapify_down(i);
            }
        }
    }
}

