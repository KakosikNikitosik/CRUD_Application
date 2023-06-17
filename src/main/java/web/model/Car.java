package web.model;

public class Car {
    private String model;
    private String producer;
    private int year;



    public Car() {
    }

    public Car(String model, String producer, int year) {
        this.model = model;
        this.producer = producer;
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", producer='" + producer + '\'' +
                ", year=" + year +
                '}';
    }
}
