package com.falcao.orgs.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.falcao.orgs.dao.ProdutosDao
import com.falcao.orgs.databinding.ActivityFormProductBinding
import com.falcao.orgs.models.Produto
import java.math.BigDecimal

class FormProductActivity :
    AppCompatActivity() {

     private val binding by lazy {
         ActivityFormProductBinding.inflate(layoutInflater)
     }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        configuraBotaoSalvar()
        setContentView(binding.root)
    }

    private fun configuraBotaoSalvar() {
        val botaoSalvar = binding.activityFormProdutoBotaoSalvar
        val dao = ProdutosDao()

        botaoSalvar.setOnClickListener {
            val produtoNovo = criaProduto()

            dao.add(produtoNovo)

            finish()
        }
    }

    private fun criaProduto(): Produto {
        val campoNome = binding.activityFormProdutoNome
        val nome = campoNome.editText.toString()

        val campoDescricao = binding.activityFormProdutoDescricao
        val descricao = campoDescricao.editText.toString()

        val campoValor = binding.activityFormProdutoValor
        val valorString = campoValor.editText.toString()

        val valor = if (valorString.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(valorString)
        }

        return Produto(
            nome = nome,
            descricao = descricao,
            valor = valor
        )
    }
}