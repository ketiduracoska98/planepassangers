public class Family extends Passenger
{
    public Family(String id, String name, int age, String tip_bilet, String imb_pri, String nev_spec, int priority)
    {
        super(id, name, age, tip_bilet, imb_pri, nev_spec,priority+10);
    }
}
