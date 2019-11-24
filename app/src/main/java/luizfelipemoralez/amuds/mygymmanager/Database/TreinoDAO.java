package luizfelipemoralez.amuds.mygymmanager.Database;

public class TreinoDAO {
    private String nomeTreino;
    private String repeteTreino;
    private String esperaTreino;
    private String tipoTreino;
   public TreinoDAO(String nomeTreino, String repeteTreino, String esperaTreino, String tipoTreino) {

        this.nomeTreino = nomeTreino;
        this.repeteTreino = repeteTreino;
        this.esperaTreino = esperaTreino;
        this.tipoTreino = tipoTreino;
    }

    public String getNomeTreino() {
        return nomeTreino;
    }

    public void setNomeTreino(String nomeTreino) {
        this.nomeTreino = nomeTreino;
    }

    public String getRepeteTreino() {
        return repeteTreino;
    }

    public void setRepeteTreino(String repeteTreino) {
        this.repeteTreino = repeteTreino;
    }

    public String getEsperaTreino() {
        return esperaTreino;
    }

    public void setEsperaTreino(String esperaTreino) {
        this.esperaTreino = esperaTreino;
    }

    public String getTipoTreino() {
        return tipoTreino;
    }

    public void setTipoTreino(String tipoTreino) {
        this.tipoTreino = tipoTreino;
    }
}
