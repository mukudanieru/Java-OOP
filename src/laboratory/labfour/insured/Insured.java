package laboratory.labfour.insured;

public class Insured {
    private final String companyName;
    private String customerId;
    private String modelName;
    private String name;
    private int year;
    private int mileage;

    private final String[] survey;

    public Insured() {
        this.companyName = "TOYOTA";
        this.survey = new String[3];
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getModelName() {
        return this.modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return this.mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String[] getSurvey() {
        return this.survey;
    }

    public String getMillegeLegend() {
        if (this.mileage > 0 && this.mileage <= 5000) {
            return "have only 3M INSURED";
        } else if (this.mileage > 5000 && this.mileage <= 10000) {
            return "have only 2M INSURED";
        } else if (this.mileage > 10000 && this.mileage <= 50000) {
            return "have only 1M INSURED";
        } else if (this.mileage > 50000) {
            return "need an approval";
        }

        return "have only INVALID";
    }
}
