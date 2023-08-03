package br.com.alura.orgs.ui.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.orgs.R
import br.com.alura.orgs.dao.ProdutosDao
import br.com.alura.orgs.model.Produto
import br.com.alura.orgs.ui.recyclerView.adapter.ListaProdutosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.math.BigDecimal

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

        val recycleView = findViewById<RecyclerView>(R.id.recyclerView);
        val dao = ProdutosDao();

        recycleView.adapter = ListaProdutosAdapter(
            context = this, produtos = dao.buscaTodos());
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton);
        fab.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, FormularioProdutoActivity::class.java)
            startActivity(intent);
        })
        //recycleView.layoutManager = LinearLayoutManager(this);
    }
}