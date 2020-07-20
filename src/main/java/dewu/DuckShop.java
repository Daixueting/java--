package dewu;

import java.util.List;

public class DuckShop {
    private String name;

    private List<Duck> ducks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Duck> getDucks() {
        return ducks;
    }

    public void setDucks(List<Duck> ducks) {
        this.ducks = ducks;
    }

    public Duck duck5(){
        return new Duck();
    }

    public static Duck duck6(){
        return  new Duck();
    }

    @Override
    public String toString() {
        return "DuckShop{" +
                "name='" + name + '\'' +
                ", ducks=" + ducks +
                '}';
    }
}
