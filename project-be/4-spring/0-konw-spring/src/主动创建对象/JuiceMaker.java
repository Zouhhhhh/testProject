package 主动创建对象;

public class JuiceMaker {
    private Blender blender = null;
    private String water;
    private String fruit;
    private String sugar;

    public String makeJuice() {
        blender = new Blender();
        return blender.mix(water, fruit, sugar);
    }

    public Blender getBlender() {
        return blender;
    }

    public void setBlender(Blender blender) {
        this.blender = blender;
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public String getSugar() {
        return sugar;
    }

    public void setSugar(String sugar) {
        this.sugar = sugar;
    }
}
