package za.co.prog6112.q3;

/** Represents the information read for one snake type. */
public class SnakeInfo {
    private final String type;
    private final String fatalityRanking;
    private final String medicalAssistance;

    public SnakeInfo(String type, String fatalityRanking, String medicalAssistance) {
        this.type = type;
        this.fatalityRanking = fatalityRanking;
        this.medicalAssistance = medicalAssistance;
    }

    public String getType() { return type; }
    public String getFatalityRanking() { return fatalityRanking; }
    public String getMedicalAssistance() { return medicalAssistance; }

    @Override public String toString() {
        return type + " | " + fatalityRanking + " | " + medicalAssistance;
    }
}
