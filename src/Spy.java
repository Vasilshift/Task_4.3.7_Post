/*Spy – шпион, который логгирует о всей почтовой переписке, которая проходит через его руки.
Объект конструируется от экземпляра Logger, с помощью которого шпион будет сообщать о всех действиях.
Он следит только за объектами класса MailMessage и пишет в логгер следующие сообщения (в выражениях нужно заменить части в фигурных скобках на значения полей почты):
2.1) Если в качестве отправителя или получателя указан "Austin Powers", то нужно написать в лог сообщение с уровнем WARN:
Detected target mail correspondence: from {from} to {to} "{message}"
2.2) Иначе, необходимо написать в лог сообщение с уровнем INFO: Usual correspondence: from {from} to {to}  */
import java.util.logging.*;
public class Spy implements MailService{
    public static final String AUSTIN_POWERS = "Austin Powers";
    private Logger logger;
    //private static final Logger logger = Logger.getLogger(Spy.class.getName());
    public Spy(Logger logger) {
        this.logger = logger;
    }
    @Override
    public Sendable processMail(Sendable mail) {
        String from;
        String to;
        String message;
        if (mail instanceof MailMessage){
            MailMessage mailMessage = (MailMessage) mail;
            to = mail.getTo();
            from = mail.getFrom();
            message = mailMessage.getMessage();
            if (from.equals(AUSTIN_POWERS) || to.equals(AUSTIN_POWERS)){
                logger.log(Level.WARNING,
                    "Detected target mail correspondence: from " + from + "to" + to + " \"" + mailMessage.getMessage() + "\"",
                        new Object[] {from, to, message});
            }else {
                logger.log(Level.INFO,"Usual correspondence: from " + from + "to" + to, new Object[] {from,to});
            }
        }
        return mail;
    }
}
