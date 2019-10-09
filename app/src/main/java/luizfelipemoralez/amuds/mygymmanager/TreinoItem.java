package luizfelipemoralez.amuds.mygymmanager;

public class TreinoItem {
    private String nomeTreino;
    private String repeteTreino;
    private String esperaTreino;

    public TreinoItem(String nomeTreino, String repeteTreino, String esperaTreino) {
        this.nomeTreino = nomeTreino;
        this.repeteTreino = repeteTreino;
        this.esperaTreino = esperaTreino;
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
}
