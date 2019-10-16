package Models;

public class DrinkOptions {
    boolean extraHot;
    boolean sugars;

    @Override
    public String toString() {
        return "DrinkOptions{" +
                "extraHot=" + extraHot +
                ", sugars=" + sugars +
                '}';
    }

    public void setExtraHot(boolean extraHot) {
        this.extraHot = extraHot;
    }

    public void setSugars(boolean sugars) {
        this.sugars = sugars;
    }

    public boolean isExtraHot() {
        return extraHot;
    }

    public boolean isSugars() {
        return sugars;
    }
}
