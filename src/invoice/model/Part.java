package invoice.model;

/**
 * Created by jthomann on 10/24/16.
 */
public class Part {

    private int id;
    private String partNumber;
    private String description;
    private double cost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPart_number() {
        return partNumber;
    }

    public void setPartNumber(String part_number) {
        this.partNumber = part_number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

}
