package com.example.semana5_pdm

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.semana5_pdm.databinding.ActivityContatoBinding

class ContatoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContatoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityContatoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.tvTelefone.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:31975850700")
            startActivity(intent)
        }

        binding.tvEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:arthur.alexandrino@estudante.iftm.edu.br")
            startActivity(intent)
        }

        binding.tvWebsite.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.linkedin.com/in/seuusuario")
            startActivity(intent)
        }

        binding.btnShare.setOnClickListener {
            val nome = getString(R.string.my_name)
            val tel = getString(R.string.label_phone)
            val mail = getString(R.string.label_email)
            
            val texto = "contato de $nome\n$tel\n$mail"

            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, texto)
            
            val chooser = Intent.createChooser(intent, "partilhar via")
            startActivity(chooser)
        }
    }
}
