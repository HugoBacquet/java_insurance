import java.io.Serializable;

public class Insurance implements Serializable {

    private int insuranceId;
    private String insuranceName;
    private double annualFee;

    public Insurance(int insuranceId, String insuranceName, double annualFee, boolean isAutoTransfers) {
        this.insuranceId = insuranceId;
        this.insuranceName = insuranceName;
        this.annualFee = annualFee;

    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public double getAnnualFee() {
        return annualFee;
    }

    public void setAnnualFee(double annualFee) {
        this.annualFee = annualFee;
    }

    public int getInsuranceId() {
        return insuranceId;
    }

    @Override
    public String toString() {
        return "insuranceId=" + insuranceId +
                ", insuranceName='" + insuranceName + '\'' +
                ", annualFee=" + annualFee +" USD";
    }
}
