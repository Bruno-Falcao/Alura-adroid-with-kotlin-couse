package com.falcao.orgs.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.falcao.orgs.databinding.ProdutoItemBinding
import com.falcao.orgs.models.Produto
import java.text.NumberFormat
import java.util.*

class ListaProdutosAdapter(
    private val context: Context,
    produtos: List<Produto>
) : RecyclerView.Adapter<ListaProdutosAdapter.ViewHolder>() {

    private val produtos = produtos.toMutableList()

    class ViewHolder(binding: ProdutoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val nome = binding.produtoItemNome
        private val descricao = binding.produtoItemDescricao
        private val valor = binding.produtoItemValor

        fun vincula(produto: Produto) {
            nome.text = produto.nome
            descricao.text = produto.descricao

            valor.text = formataParaBrl(produto)
        }

        private fun formataParaBrl(produto: Produto): String {
            val formatador = NumberFormat
                .getCurrencyInstance(Locale("pt", "br"))
            return formatador.format(produto.valor)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = ProdutoItemBinding
            .inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = produtos[position]
        holder.vincula(produto)
    }

    override fun getItemCount(): Int {
        return produtos.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun atualiza(buscaTodos: List<Produto>) {
        this.produtos.clear()
        this.produtos.addAll(buscaTodos)
        notifyDataSetChanged()
    }

}
