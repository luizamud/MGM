package luizfelipemoralez.amuds.mygymmanager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TreinoAdapter extends RecyclerView.Adapter<TreinoAdapter.TreinoViewholder> {

    private List<Treino> dados;

    public TreinoAdapter(List<Treino> dados) {
        this.dados = dados;
    }

    @NonNull
    @Override
    public TreinoAdapter.TreinoViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_treino,parent,false);
        TreinoViewholder  treinoViewholder = new TreinoViewholder(view);
        return treinoViewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull TreinoAdapter.TreinoViewholder holder, int position) {
        Treino treino = dados.get(position);
        holder.id_treino_nome.setText(treino.getNomeTreino());
        holder.id_treino_repete.setText(treino.getRepeteTreino());
        holder.id_treino_descansa.setText(treino.getEsperaTreino());
    }

    @Override
    public int getItemCount() {
        return dados.size();
    }

    public class TreinoViewholder extends RecyclerView.ViewHolder {
        public TextView id_treino_nome;
        public TextView id_treino_repete;
        public TextView id_treino_descansa;
        public TreinoViewholder(@NonNull View itemView) {
            super(itemView);
            id_treino_nome = (TextView) itemView.findViewById(R.id.id_treino_nome);
            id_treino_repete =(TextView) itemView.findViewById(R.id.id_treino_repete);
            id_treino_descansa =(TextView)itemView.findViewById(R.id.id_treino_descanso);
        }
    }
}
