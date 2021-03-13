public class Points {
    int amountOfMatches=0;
    int amountOfLuckyNum=0;

    //Increasing amount of matches
    public void implMatches(){
        amountOfMatches++;
    }
    public void implLuckyNum(){
        amountOfLuckyNum++;
    }
    int getAmountOfMatches(){
        return amountOfMatches;
    }
    int getAmountOfLuckyNum(){
        return amountOfLuckyNum;
    }

}
