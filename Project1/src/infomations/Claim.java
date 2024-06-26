package infomations;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author <Tran Duy Hung - s3928533>
 */

public class Claim {
    private String id;
    private Date claimDate;
    private String insuredPersonID;
    private String cardNumberID;
    private Date examDate;
    private ArrayList<String> listOfDocuments;
    private float claimAmount;
    private String status;
    private String receiverBankingInfo;

    public Claim() {
    }

    public Claim(String id, Date claimDate, String insuredPersonID, String cardNumberID, Date examDate,
            ArrayList<String> listOfDocuments, float claimAmount, String status, String receiverBankingInfo) {
        this.id = id;
        this.claimDate = claimDate;
        this.insuredPersonID = insuredPersonID;
        this.cardNumberID = cardNumberID;
        this.examDate = examDate;
        this.listOfDocuments = listOfDocuments;
        this.claimAmount = claimAmount;
        this.status = status;
        this.receiverBankingInfo = receiverBankingInfo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(Date claimDate) {
        this.claimDate = claimDate;
    }

    public String getInsuredPersonID() {
        return insuredPersonID;
    }

    public void setInsuredPersonID(String insuredPersonID) {
        this.insuredPersonID = insuredPersonID;
    }

    public String getCardNumberID() {
        return cardNumberID;
    }

    public void setCardNumberID(String cardNumberID) {
        this.cardNumberID = cardNumberID;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public ArrayList<String> getListOfDocuments() {
        return listOfDocuments;
    }

    public void setListOfDocuments(ArrayList<String> listOfDocuments) {
        this.listOfDocuments = listOfDocuments;
    }

    public float getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(float claimAmount) {
        this.claimAmount = claimAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReceiverBankingInfo() {
        return receiverBankingInfo;
    }

    public void setReceiverBankingInfo(String receiverBankingInfo) {
        this.receiverBankingInfo = receiverBankingInfo;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String s = "* Claim infomation:";
        s += "\n- ID: " + id + " | Claim date: " + dateFormat.format(claimDate) + " | Insured PersonID: "
                + insuredPersonID + " | CardNumberID=" + cardNumberID;
        s += "\n- Exam Date: " + dateFormat.format(examDate) + " | Claim Amount: $" + claimAmount + " | Status: "
                + status;
        s += "\n- List of documents: ";
        for (String string : listOfDocuments) {
            s += "\n  + " + string;
        }
        s += "\n- Receiver Banking Info: " + receiverBankingInfo;

        return s;
    }

    public String getDataSaveFile() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String s = "";
        s += id + "|" + dateFormat.format(claimDate) + "|" + insuredPersonID + "|"
                + cardNumberID + "|" + dateFormat.format(examDate) + "|" + claimAmount + "|" + status;
        s += "\n" + String.join("|", listOfDocuments);
        s += "\n" + receiverBankingInfo;

        return s;
    }
}