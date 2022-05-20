package cascade.pojo;

/**
 * @author zouhao
 * @date 2022/5/19
 */
public class FemaleEmployee extends Employee {
    private FemaleHealthForm femaleHealthForm = null;

    public FemaleHealthForm getFemaleHealthForm() {
        return femaleHealthForm;
    }

    public void setFemaleHealthForm(FemaleHealthForm femaleHealthForm) {
        this.femaleHealthForm = femaleHealthForm;
    }
}
