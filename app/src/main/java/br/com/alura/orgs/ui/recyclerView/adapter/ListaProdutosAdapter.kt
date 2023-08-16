package br.com.alura.orgs.ui.recyclerView.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.orgs.R
import br.com.alura.orgs.databinding.FormularioImagemBinding
import br.com.alura.orgs.databinding.ProdutoItemBinding
import br.com.alura.orgs.model.Produto
import coil.load
import java.math.BigDecimal
import java.text.NumberFormat
import java.util.Locale

class ListaProdutosAdapter(
    private val context: Context,
    produtos: List<Produto>
) : RecyclerView.Adapter<ListaProdutosAdapter.ViewHolder>() {

    private val produtos = produtos.toMutableList();

    class ViewHolder(private val binding: ProdutoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun vincula(produto: Produto) {
            val nome = itemView.findViewById<TextView>(R.id.activity_formulario_produto_nome);
            nome.text = produto.nome;
            val descricao =
                itemView.findViewById<TextView>(R.id.activity_formulario_produto_descricao);
            descricao.text = produto.descricao;
            val valor = itemView.findViewById<TextView>(R.id.activity_formulario_produto_valor);
            val valorEmMoeda: String = formataParaMoedaBrasileira(produto.valor)
            valor.text = valorEmMoeda;

            val visibilidade = if (produto.imagem != null) {
                View.VISIBLE
            } else {
                View.GONE
            }

            binding.imageView.visibility = visibilidade;

            binding.imageView.load(produto.imagem) {
                fallback(R.drawable.erro)
                error(R.drawable.erro)
            }
        }

        private fun formataParaMoedaBrasileira(valor: BigDecimal): String {
            val formatador: NumberFormat = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
            return formatador.format(valor)
        }
    };

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context);
        val binding = ProdutoItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding);
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = produtos[position]
        holder.vincula(produto)
    }

    override fun getItemCount(): Int = produtos.size

    fun atualiza(produtos: List<Produto>) {
        this.produtos.clear();
        this.produtos.addAll(produtos)
        notifyDataSetChanged();
    }
}

