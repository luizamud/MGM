package luizfelipemoralez.amuds.mygymmanager.View;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import luizfelipemoralez.amuds.mygymmanager.Model.Treino;
import luizfelipemoralez.amuds.mygymmanager.R;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.Holder> {

    private List<Treino> dados;

    public class Holder extends RecyclerView.ViewHolder{
        TextView id_tipo;
        TextView id_treino;
        TextView id_repete;
        TextView id_intervalo;

        public Holder(@NonNull View itemView) {
            super(itemView);
            id_treino  = itemView.findViewById(R.id.id_treino);
            id_tipo = itemView.findViewById(R.id.id_tipo);
            id_repete = itemView.findViewById(R.id.id_repeticao);
            id_intervalo = itemView.findViewById(R.id.id_descanco);
        }
    }

    public HomeAdapter(List<Treino> dados) {
        this.dados = dados;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View treino_item = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_item,
                        viewGroup,
                        false);

        return new Holder(treino_item);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        Treino treinoItem = dados.get(i);
        holder.id_tipo.setText("Tipo de Treino: " + treinoItem.getTipoTreino());
        holder.id_treino.setText("Nome do Treino: " + treinoItem.getNomeTreino());
        holder.id_repete.setText("Quantidade de Repetições: " + treinoItem.getRepeteTreino());
        holder.id_intervalo.setText("Intervalo do Treino: " + treinoItem.getEsperaTreino() + " Segundos");
    }

    @Override
    public int getItemCount() {
        return dados.size();
    }
}