package WebService.Warhammer40k.BattleReport;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BattleReport {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private float id;

    private String title;

    private String player1;

    private String player1Army;

    private String player1Detachment;

    private String player2;

    private String player2Army;

    private String player2Detachment;

    private String text;

    private String winner;

    public BattleReport() {
    }

    public float getId() {
        return id;
    }

    public void setId(float id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer1Army() {
        return player1Army;
    }

    public void setPlayer1Army(String player1Army) {
        this.player1Army = player1Army;
    }

    public String getPlayer1Detachment() {
        return player1Detachment;
    }

    public void setPlayer1Detachment(String player1Detachment) {
        this.player1Detachment = player1Detachment;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public String getPlayer2Army() {
        return player2Army;
    }

    public void setPlayer2Army(String player2Army) {
        this.player2Army = player2Army;
    }

    public String getPlayer2Detachment() {
        return player2Detachment;
    }

    public void setPlayer2Detachment(String player2Detachment) {
        this.player2Detachment = player2Detachment;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
}
