public class Thief {

    public Thief(int minPriceThief) {
    }

    public int getStolenValue(int valueOfPackage){
        int sum = 0;
        sum = sum + valueOfPackage;    //считаем сумму сворованных посылок
        return sum;
    }
    public Package vorovstvo(Package oldpac){

        Package newpac = new Package("stones instead of {content}", 0);
        newpac = oldpac;     //заменяем посылку
        return newpac;
    }

}
