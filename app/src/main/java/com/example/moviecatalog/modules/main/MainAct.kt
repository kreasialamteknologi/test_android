package com.example.moviecatalog.modules.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.moviecatalog.R
import com.example.moviecatalog.databinding.ActMainBinding
import com.example.moviecatalog.models.Movie
import com.example.moviecatalog.modules.backup.BackupAct
import com.example.moviecatalog.modules.main.adapter.MovieAdapter
import com.example.moviecatalog.modules.main.viewmodel.MainVM
import com.example.moviecatalog.modules.splash.SplashAct
import com.example.moviecatalog.utils.AuthSession
import com.example.moviecatalog.utils.context
import com.example.moviecatalog.utils.setActBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainAct : AppCompatActivity() {

    private lateinit var binding: ActMainBinding
    private lateinit var movieAdapter: MovieAdapter
    private val viewModel: MainVM by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()
        retrieveLiveData()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.logout -> {
                logoutDialog()
                true
            }
            R.id.backup -> {
                startActivity(Intent(this, BackupAct::class.java))
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun initBinding() {
        binding = setActBinding(R.layout.act_main)
        AuthSession.setLoggedIn(this, true)
    }

    private fun retrieveLiveData() {
        viewModel.getTrendingMovie.observe(this, Observer {
            initAdapter(it.results)
        })
    }

    private fun initAdapter(list: List<Movie>) {
        val rv = binding.rv
        movieAdapter = MovieAdapter(list)
        with(rv) {
            adapter = movieAdapter
            layoutManager = GridLayoutManager(context(), 2)
        }
    }

    private fun logoutDialog() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        with(builder) {
            setMessage("Do you want to logout?")
            setTitle("Alert!")
            setCancelable(false)
            setPositiveButton(
                "Yes"
            ) { _, _ ->
                AuthSession.setLoggedIn(context(), false)
                startActivity(Intent(context(), SplashAct::class.java))
            }
            setNegativeButton(
                "No"
            ) { dialog, _ -> dialog.cancel() }
        }
        val alertDialog: AlertDialog = builder.create()
        alertDialog.show()
    }
}
