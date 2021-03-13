
public class User extends Database{
    int userID;
    String firstName;
    int age;
    int UserMoney;

    //setters and getters
    public void setUserID(int userID) {
        this.userID = userID;
    }

    void setFirstName(String firstName){
        this.firstName=firstName;
    }
    void setAge(int age){
        this.age=age;
    }

    //lottery payoff
    void setUserMoney(Points points){
        if(points.getAmountOfMatches()>=4 & points.getAmountOfLuckyNum()==3){
            this.UserMoney=50000;
        }else if (points.getAmountOfMatches()>=4 & points.getAmountOfLuckyNum()==2){
            this.UserMoney = 20000;
        }else if (points.getAmountOfMatches()>=4 & points.getAmountOfLuckyNum()==1) {
            this.UserMoney = 10000;
        }else if (points.getAmountOfMatches()>=4){
            this.UserMoney = 5000;
        }
    }

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getUserID() {
        return userID;
    }

    public int getUserMoney() {
        return UserMoney;
    }
}
