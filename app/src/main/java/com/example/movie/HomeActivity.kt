package com.example.movie
import android.view.MenuItem

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    private lateinit var movieRecyclerView: RecyclerView
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        movieRecyclerView = findViewById(R.id.recyclerViewMovies)
        movieRecyclerView.layoutManager = LinearLayoutManager(this)
        movieAdapter = MovieAdapter(getMovieList())
        movieRecyclerView.adapter = movieAdapter

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.item_1 -> true
                R.id.item_2 -> true
                R.id.item_3 -> true
                R.id.item_4 -> true
                else -> false
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        val searchItem = menu.findItem(R.id.action_search)
        val searchView = searchItem.actionView as SearchView
        searchView.queryHint = "Search movies"

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                performSearch(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                performSearch(newText)
                return true
            }
        })

        return true
    }

    private fun performSearch(query: String) {
        val filteredMovies = getMovieList().filter { movie ->
            movie.title?.contains(query, ignoreCase = true) == true
        }
        movieAdapter.updateList(filteredMovies)
    }

    private fun getMovieList(): List<Movie> {
        val movies = mutableListOf<Movie>()
        movies.add(Movie("Movie 1", "Genre 1"))
        movies.add(Movie("Movie 2", "Genre 2"))
        movies.add(Movie("Movie 3", "Genre 3"))
        return movies
    }
}
