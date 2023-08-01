package br.com.alura.orgs.ui.activity

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.orgs.R
import br.com.alura.orgs.model.Produto
import br.com.alura.orgs.ui.recyclerView.adapter.ListaProdutosAdapter
import java.math.BigDecimal

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
        /*val nome = findViewById<TextView>(R.id.nome);
        nome.text = "Cesta de frutas";
        val descricao = findViewById<TextView>(R.id.descricao);
        descricao.text = "Laranja, manga e maçã"
        val valor = findViewById<TextView>(R.id.valor);
        valor.text = "19.99"*/

        val recycleView = findViewById<RecyclerView>(R.id.recyclerView);
        recycleView.adapter = ListaProdutosAdapter(
            context = this, produtos = listOf(
                Produto(
                    nome = "teste",
                    descricao = "teste desc",
                    valor = BigDecimal("19.99")
                ),
                Produto(
                    nome = "teste1",
                    descricao = "teste desc1",
                    valor = BigDecimal("29.99")
                ),
            )
        );
        //recycleView.layoutManager = LinearLayoutManager(this);
    }
}