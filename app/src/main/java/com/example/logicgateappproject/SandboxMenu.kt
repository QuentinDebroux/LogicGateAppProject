package com.example.logicgateappproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.logicgateappproject.sandbox.SandboxView2

class SandboxMenu: AppCompatActivity() {

    lateinit var sandboxView: SandboxView2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sandbox_menu)
        sandboxView = findViewById<SandboxView2>(R.id.vSandbox)
    }

    override fun onPause() {
        super.onPause()
        sandboxView.pause()
    }

    override fun onResume() {
        super.onResume()
        sandboxView.resume()
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val intent = Intent(this, Menu::class.java)
        startActivity(intent)
    }
}