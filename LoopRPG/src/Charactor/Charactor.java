package charactor;

public class Charactor {

   public String name;

   public Charactor(String name){
       this.name = name;
       this.ad = ad;
       this.hp = hp;
   }

   public int ad;

   public int hp;

   public int atk(int ad){
       return ad;
   }

   public int hit(int hp){
       hp -= ad;
       return hp;
   }


    public int getAd() {
        return ad;
    }

    public void setAd(int ad) {
        this.ad = ad;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
