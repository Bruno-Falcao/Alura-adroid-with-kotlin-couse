package com.falcao.orgs.dao

import com.falcao.orgs.models.Produto
import java.math.BigDecimal

class ProdutosDao {

    fun add(produto: Produto) {
        produtos.add(produto)
    }

    fun buscaTodos(): List<Produto> {
        return produtos.toList()
    }

    companion object {
        private val produtos = mutableListOf<Produto>(
            Produto(
                nome = "Salada de frutas",
                descricao = "Laranja, Maçãs e uva",
                valor = BigDecimal("19.99")
            )
        )
    }
}