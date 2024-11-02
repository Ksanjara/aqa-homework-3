public class Main {

    public static void main(String[] args) {
        byte myByte = 120;
        short myShort = -32128;
        float myFloat = 2.012F;
        double myDouble = 0.641564;
        int myInt = 2500;
        int myBigInt = 1_000_000;
        boolean isSkyBlue = true;
        boolean isSkyGray = false;

        System.out.println("Умножение разных типов: " + (myByte * myShort * myInt * myFloat) * myInt);

        System.out.println("Деление: " + myInt / myDouble);

        System.out.println("Вычитание: " + (myFloat - myShort));

        System.out.println("Сложение: " + (myDouble + myByte));

        System.out.println("Сравнение: " + myDouble + ">" + myFloat + "=" + (myDouble > myFloat));
        System.out.println("Сравнение: " + myDouble + "<" + myFloat + "=" + (myDouble < myFloat));
        System.out.println("Сравнение: " + myDouble + "!=" + myFloat + "=" + (myDouble != myFloat));
        System.out.println("Сравнение: " + myDouble + "==" + myFloat + "=" + (myDouble == myFloat));
        System.out.println("Сравнение: " + myDouble + ">=" + myFloat + "=" + (myDouble >= myFloat));

        System.out.println("Логичеcкое вычиcление ||: " + (isSkyGray || isSkyBlue));
        System.out.println("Логичеcкое вычиcление &&: " + (isSkyGray && isSkyBlue));
        System.out.println("Логичеcкое вычиcление !: " + (!isSkyBlue));


        System.out.println("Переполнение: " + myBigInt * myInt);
    }
}
