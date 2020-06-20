package br.com.alura.aluraviagens.ui.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.alura.aluraviagens.R
import br.com.alura.aluraviagens.model.Pacote
import br.com.alura.aluraviagens.util.DiasUtil
import br.com.alura.aluraviagens.util.MoedaUtil
import br.com.alura.aluraviagens.util.ResourceUtil
import br.com.alura.aluraviagens.util.toDatePeriod
import kotlinx.android.synthetic.main.activity_resumo_pacote.*
import java.math.BigDecimal
import java.text.SimpleDateFormat
import java.util.*

class ResumoPacoteActivity : AppCompatActivity() {

    companion object {

        fun start(context: Context) {
            val intent = Intent(context, ResumoPacoteActivity::class.java)
            context.startActivity(intent)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumo_pacote)

        title = "Resumo do pacote"

        val pacoteSaoPaulo = Pacote(
                "São Paulo",
                "sao_paulo_sp",
                2,
                BigDecimal("243.93")
        )

        bindPacote(pacoteSaoPaulo)

        PagamentoActivity.start(this)

    }

    private fun bindPacote(pacote: Pacote) {
        ivResumoPacote.setImageDrawable(ResourceUtil.devolveDrawable(this, pacote.imagem))
        tvResumoPacoteCidade.text = pacote.local
        tvResumoPacoteDias.text = DiasUtil.formataEmTexto(pacote.dias)
        tvResumoPacotePreco.text = MoedaUtil.formataParaBrasileiro(pacote.preco)
        tvResumoPacoteDate.text = pacote.dias.toDatePeriod()
    }

}