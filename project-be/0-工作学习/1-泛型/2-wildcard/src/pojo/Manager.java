package pojo;

public class Manager extends Employee {

    public Manager() {
    }

    public Manager(String name, int bonux) {
        this.bonux = bonux;
        super.setName(name);
    }

    private int bonux;

    public int getBonux() {
        return bonux;
    }

    public void setBonux(int bonux) {
        this.bonux = bonux;
    }
}
