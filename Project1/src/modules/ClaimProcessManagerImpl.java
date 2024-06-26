package modules;

import java.util.ArrayList;
import java.util.Date;

import UI.ClaimProcessManager;
import infomations.Claim;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author <Tran Duy Hung - s3928533>
 */

public class ClaimProcessManagerImpl implements ClaimProcessManager {
    private ArrayList<Claim> claimList;
    private static final String FILE_PATH = "src\\Claims.txt";

    public ClaimProcessManagerImpl() {
        this.claimList = new ArrayList<>();
        loadClaimsFromFile();
    }

    @Override
    public void addClaim(Claim claim) {
        claimList.add(claim);
        saveClaimsToFile();
    }

    @Override
    public void updateClaim(Claim claim) {
        for (int i = 0; i < claimList.size(); i++) {
            if (claimList.get(i).getId().equals(claim.getId())) {
                claimList.set(i, claim);
                saveClaimsToFile();
                break;
            }
        }
    }

    @Override
    public void deleteClaim(String claimId) {
        for (int i = 0; i < claimList.size(); i++) {
            if (claimList.get(i).getId().equals(claimId)) {
                claimList.remove(i);
                saveClaimsToFile();
                break;
            }
        }
    }

    @Override
    public Claim getClaim(String claimId) {
        for (Claim claim : claimList) {
            if (claim.getId().equals(claimId)) {
                return claim;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Claim> getAllClaims() {
        return claimList;
    }

    private void loadClaimsFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    String[] parts = line.split("\\|");
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date date1 = simpleDateFormat.parse(parts[1]);
                    Date date2 = simpleDateFormat.parse(parts[4]);
                    ArrayList<String> l = new ArrayList<>();
                    line = br.readLine();
                    String[] s2 = line.split("\\|");

                    for (String s : s2) {
                        l.add(s);
                    }

                    String receiverBankingInfo = br.readLine();

                    Claim claim = new Claim(parts[0], date1, parts[2], parts[3], date2, l, Float.parseFloat(parts[5]),
                            parts[6], receiverBankingInfo);

                    claimList.add(claim);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveClaimsToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Claim claim : claimList) {
                bw.write(claim.getDataSaveFile());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
