package BlockChain;
import java.util.Date;
import HashUtil.HashUtil;

public class Blocks {
    private int index; //Block Genesis = 0
    private Date timeStamp = new Date(); //La date au moment de la création
    private String hashPrecedent; //Hash du block précédent de la chaine
    private String hashRootMerkle;
    private BlockChain blockChain;
    private String hashBlockCourant;
    private String listeTransaction = "";
    private int nbTranstaction;
    private int nonce = 0; //En cryptographie, un nonce est un nombre arbitraire destiné à être utilisé une seule fois. Il s'agit souvent d'un nombre aléatoire ou pseudo-aléatoire émis dans un protocole d'authentification pour garantir que les anciennes communications ne peuvent pas être réutilisées dans des attaques par rejeu

    public Blocks(int index, BlockChain blockChain){
        this.index = index;
        this.blockChain = blockChain;
    }

    public int getIndex() {
        return index;
    }

    public String getHashBlockCourant() {
        return hashBlockCourant;
    }

    public String getListeTransaction() {
        return listeTransaction;
    }

    public String transaction(String input, int difficulte){ //TODO Minage
        listeTransaction += input + " ";
        nbTranstaction++;
        return hashing(listeTransaction, hashPrecedent, difficulte);
    }

    public String hashing(String message, String hashPrecedent, int difficulte){ //TODO ajouter arbre de Merkle
        this.hashPrecedent = hashPrecedent;
        do {
            hashBlockCourant = HashUtil.applySha256(String.valueOf(nonce) + message + timeStamp + hashPrecedent);
            nonce++;
        }while(!hashBlockCourant.matches("[0]{"+difficulte+"}(.*)"));
        return hashBlockCourant;
    }

}
