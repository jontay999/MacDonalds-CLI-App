package MacDonalds.New;

enum MembershipType{GOLD, SILVER, GREEN};

public class Membership {
    MembershipType type;
    double discount;

    Membership(MembershipType type){
        switch(type){
            case GOLD:
                this.discount=0.15;
                break;
            case SILVER:
                this.discount=0.10;
                break;
            case GREEN:
                this.discount=0.05;
                break;
        }
    }

    public MembershipType getType() {
        return this.type;
    }

    public void setType(MembershipType type) {
        this.type = type;
    }

    public double getDiscount() {
        return this.discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
