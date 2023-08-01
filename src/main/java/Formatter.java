class Formatter{
    public static String format(double sum, int  amount){
        int numb= (int) ((sum/amount)%100);
        if(numb>=11&&numb<=19){
            return "рублей";
        }
        int digit= (int) ((sum/amount)%10);
        switch (digit){
            case 1:
                return "рубль";
            case 2:
            case 3:
            case 4:
                return "рубля";
            default:
                return "рублей";
        }
    }
}
