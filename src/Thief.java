/*3) Thief – вор, который ворует самые ценные посылки и игнорирует все остальное. Вор принимает в конструкторе переменную int – минимальную
стоимость посылки, которую он будет воровать. Также, в данном классе должен присутствовать метод getStolenValue,
который возвращает суммарную стоимость всех посылок, которые он своровал. Воровство происходит следующим образом: вместо посылки, которая пришла вору,
он отдает новую, такую же, только с нулевой ценностью и содержимым посылки "stones instead of {content}".   */

public class Thief implements MailService{
    private static int stolenValue;
    private static int minValueThief;
    public Thief(int minValueThief) {
        this.minValueThief = minValueThief;
    }
    public int getStolenValue(){
        return stolenValue;    //считаем сумму сворованных посылок
    }

    @Override
    public Sendable processMail(Sendable mail) {
        //Package mailnew = new Package("stones instead of {content}", 0);
        //mailnew = mail;
        MailPackage pack;
        pack = (MailPackage) mail;
        if (pack.getContent().getPrice() >= minValueThief) {
            stolenValue+= pack.getContent().getPrice();
            return new MailPackage(pack.getFrom(), pack.getTo(), new Package("stones instead of " + pack.getContent().getContent(), 0));
        }
        return mail;
    }
}
