package br.com.alura.aluraviagens.ui.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.alura.aluraviagens.R
import br.com.alura.aluraviagens.model.Pacote
import br.com.alura.aluraviagens.util.MoedaUtil
import kotlinx.android.synthetic.main.activity_pagamento.*
import java.math.BigDecimal

class PagamentoActivity : AppCompatActivity() {

    companion object {

        fun start(context: Context) {
            val intent = Intent(context, PagamentoActivity::class.java)
            context.startActivity(intent)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagamento)

        setTitle(R.string.payment_title)

        val pacoteSaoPaulo = Pacote(
                "São Paulo",
                "sao_paulo_sp",
                2,
                BigDecimal("243.93")
        )

        bindPrice(pacoteSaoPaulo)
    }

    private fun bindPrice(pacote: Pacote) {
        tvPaymentValue.text = MoedaUtil.formataParaBrasileiro(pacote.preco)
    }

}