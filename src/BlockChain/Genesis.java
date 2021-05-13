package BlockChain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Genesis extends Block{
    private final ArrayList<String> listeTransactionGenesis = new ArrayList<>(Arrays.asList("Genesis"));
    private final String hashRootMerkleGenesis;

    public Genesis(BlockChain blockChain) {
        super(blockChain);
        Date time = new Date();
        this.hashRootMerkleGenesis = calculateMerkleRoot(listeTransactionGenesis).toString();
    }

    public String getHashMerkleRoot() {
        return hashRootMerkleGenesis;
    }

    public String getHashBlockCourant() {
        String hashBlockCourantGenesis = "0";
        return hashBlockCourantGenesis;
    }

    public ArrayList<String> getListeTransactionGenesis() {
        return listeTransactionGenesis;
    }
}
