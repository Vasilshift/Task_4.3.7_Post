//import static com.sun.tools.javac.code.Type.contains;

/*4) Inspector – Инспектор, который следит за запрещенными и украденными посылками и бьет тревогу в виде исключения,
если была обнаружена подобная посылка. Если он заметил запрещенную посылку с одним из запрещенных содержимым
("weapons" и "banned substance"), то он бросает IllegalPackageException.
Если он находит посылку, состоящую из камней (содержит слово "stones"),
то тревога прозвучит в виде StolenPackageException. Оба исключения вы должны объявить самостоятельно в виде непроверяемых исключений.*/
class IllegalPackageException extends RuntimeException {
    public IllegalPackageException() {
    }
    public IllegalPackageException(String message) {
    }
}
class StolenPackageException extends RuntimeException {
    public StolenPackageException() {
    }

    public StolenPackageException (String message) {
    }
}

public class Inspector implements MailService {
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";

    @Override
    public Sendable processMail(Sendable mail) {
        //MailPackage mailPackage = null;
        //Package ipackage;


        if (mail instanceof MailPackage) {
            Package iPackage = ((MailPackage) mail).getContent();
            //mailPackage = (String) mail;
            //String mailPackage = (String) mail;
            //ipackage = (Package) mail;
            if ( iPackage.getContent().contains("weapons") || ( iPackage.getContent().contains("weapons") )) {
                throw new IllegalPackageException();
            }
            if (iPackage.getContent().contains("stones")) {
                throw new StolenPackageException();
            }
        }
        return mail;
    }
}
