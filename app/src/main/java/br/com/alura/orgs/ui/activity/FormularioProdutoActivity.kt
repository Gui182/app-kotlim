package br.com.alura.orgs.ui.activity

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.orgs.R
import br.com.alura.orgs.dao.ProdutosDao
import br.com.alura.orgs.databinding.ActivityFormularioProdutoBinding
import br.com.alura.orgs.databinding.FormularioImagemBinding
import br.com.alura.orgs.extensions.tentaCarregarImagem
import br.com.alura.orgs.model.Produto
import br.com.alura.orgs.ui.dialog.FormularioImagemDialog
import coil.load
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity() {

    private val binding by lazy {
       ActivityFormularioProdutoBinding.inflate(layoutInflater)
    }

    private var url: String? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        title = "Cadastrar produto"
        configuraBotaoSalvar()
        binding.actitivityFormularioProdutoImagem.setOnClickListener {
            FormularioImagemDialog(this).mostra(url) {
                imagem ->
                    url = imagem
                    binding.actitivityFormularioProdutoImagem.tentaCarregarImagem(url)
            }
        }
    }

    private fun configuraBotaoSalvar() {
        val botaoSalvar = findViewById<Button>(R.id.activity_formulario_produto_botao_salvar);
        botaoSalvar.setOnClickListener(View.OnClickListener {
            val produtoNovo = criaProduto()
            val dao = ProdutosDao();
            dao.adiciona(produtoNovo);
            finish();
        })
    }

    private fun criaProduto(): Produto {
        val campoNome = findViewById<EditText>(R.id.activity_formulario_produto_nome);
        val nome = campoNome.text.toString();
        val campoDescricao = findViewById<EditText>(R.id.activity_formulario_produto_descricao);
        val descricao = campoDescricao.text.toString();
        val campoValor = findViewById<EditText>(R.id.activity_formulario_produto_valor);
        val valorEmTexto = campoValor.text.toString();
        val valor = if (valorEmTexto.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(valorEmTexto)
        }

        return Produto(
            nome = nome,
            descricao = descricao,
            valor = valor,
            imagem = url
        )
    }
}
