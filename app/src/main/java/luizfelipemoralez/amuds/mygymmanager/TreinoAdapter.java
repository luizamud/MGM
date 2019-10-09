package luizfelipemoralez.amuds.mygymmanager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TreinoAdapter extends RecyclerView.Adapter<TreinoAdapter.Holder> {

    private List<Treino> dados;

    public class Holder extends RecyclerView.ViewHolder{

        TextView id_treino;
        TextView id_repete;
        TextView id_intervalo;

        public Holder(@NonNull View itemView) {
            super(itemView);
            id_treino  = itemView.findViewById(R.id.id_treino);
            id_repete = itemView.findViewById(R.id.id_repeticao);
            id_intervalo = itemView.findViewById(R.id.id_descanco);
        }
    }

    public TreinoAdapter(List<Treino> dados){
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

        holder.id_treino.setText(treinoItem.getNomeTreino());
        holder.id_repete.setText(treinoItem.getRepeteTreino());
        holder.id_intervalo.setText(treinoItem.getEsperaTreino());
    }

    @Override
    public int getItemCount() {
        return dados.size();
    }
}