package tdm.pml.PackageSubtypes;

import tdm.pml.Package;

public class GasTank extends Package {
    /**
     * @param weight
     * @param height
     * @param width
     * @param length
     */
    public GasTank (double weight, double height, double width, double length) {
        super(weight, height, width, length);
    }

    /**
     * Creates a new copy of the curretn object
     * @return a new copy of GasTank
     */
    public GasTank copy(){
        return new GasTank(this.getWeight(), this.getHeight(), this.getWidth(), this.getLength());
    }

    public String getName() {
        return "GasTank";
    }

    @Override
    public void performTask() {
        // None
    }
}