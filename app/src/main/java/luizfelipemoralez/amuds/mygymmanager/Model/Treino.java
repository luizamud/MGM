package luizfelipemoralez.amuds.mygymmanager.Model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Treino {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    private String nomeTreino;
    @NonNull
    private String repeteTreino;
    @NonNull
    private String esperaTreino;
    @NonNull
    private String tipoTreino;

    public Treino( @NonNull String nomeTreino, @NonNull String repeteTreino, @NonNull String esperaTreino, @NonNull String tipoTreino) {
        this.nomeTreino = nomeTreino;
        this.repeteTreino = repeteTreino;
        this.esperaTreino = esperaTreino;
        this.tipoTreino = tipoTreino;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getNomeTreino() {
        return nomeTreino;
    }

    public void setNomeTreino(@NonNull String nomeTreino) {
        this.nomeTreino = nomeTreino;
    }

    @NonNull
    public String getRepeteTreino() {
        return repeteTreino;
    }

    public void setRepeteTreino(@NonNull String repeteTreino) {
        this.repeteTreino = repeteTreino;
    }

    @NonNull
    public String getEsperaTreino() {
        return esperaTreino;
    }

    public void setEsperaTreino(@NonNull String esperaTreino) {
        this.esperaTreino = esperaTreino;
    }

    @NonNull
    public String getTipoTreino() {
        return tipoTreino;
    }

    public void setTipoTreino(@NonNull String tipoTreino) {
        this.tipoTreino = tipoTreino;
    }
}
