package cascade.pojo;

/**
 * @author zouhao
 * @date 2022/5/19
 */
public class MaleEmployee extends Employee {
    private MaleHealthForm maleHealthForm = null;

    public MaleHealthForm getMaleHealthForm() {
        return maleHealthForm;
    }

    public void setMaleHealthForm(MaleHealthForm maleHealthForm) {
        this.maleHealthForm = maleHealthForm;
    }
}
