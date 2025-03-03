public class ExitGate {
    Ticket ticket;
    CostComputation cost;

    public void priceCal(Ticket t, int exitTime){
        System.out.println("Pay "+cost.priceCal(t, exitTime));
    }
}
