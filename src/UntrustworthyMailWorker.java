public class UntrustworthyMailWorker implements MailService{
    private static MailService[] workers;
    private static RealMailService realWorker = new RealMailService();
    public UntrustworthyMailWorker (MailService[] w) {
        //code
    }
    public MailService getRealMailService(){
        //code
        return
    }

    @Override
    public Sendable processMail(Sendable mail) {
        //code
    }
}
