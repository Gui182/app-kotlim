package br.com.alura.orgs.ui.recyclerView.adapter

<<<<<<< HEAD
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.orgs.R
import br.com.alura.orgs.model.Produto

class ListaProdutosAdapter(
    private val context: Context,
    private val produtos: List<Produto>
) : RecyclerView.Adapter<ListaProdutosAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun vincula(produto: Produto) {
            val nome = itemView.findViewById<TextView>(R.id.nome);
            nome.text = produto.nome;
            val descricao = itemView.findViewById<TextView>(R.id.descricao);
            descricao.text = produto.descricao;
            val valor = itemView.findViewById<TextView>(R.id.valor);
            valor.text = produto.valor.toPlainString();
        }
    };

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context);
        val view = inflater.inflate(R.layout.produto_item, parent, false);
        return ViewHolder(view);
=======
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.orgs.model.Produto

class ListaProdutosAdapter(
    private  val produtos: List<Produto>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
>>>>>>> 8011c06d142320a1f44138e07e11ae9bdbac5c71
    }

    override fun getItemCount(): Int = produtos.size

<<<<<<< HEAD
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = produtos[position];
        holder.vincula(produto);
=======
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
>>>>>>> 8011c06d142320a1f44138e07e11ae9bdbac5c71
    }

}
