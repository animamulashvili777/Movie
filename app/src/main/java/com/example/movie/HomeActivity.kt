package com.example.movie

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import android.content.Intent

class HomeActivity : AppCompatActivity() {

    private lateinit var movieRecyclerView: RecyclerView
    private lateinit var movieAdapter: MovieAdapter
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private var isDrawerOpen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        movieRecyclerView = findViewById(R.id.recyclerViewMovies)
        movieRecyclerView.layoutManager = LinearLayoutManager(this)
        movieAdapter = MovieAdapter(getMovieList())
        movieRecyclerView.adapter = movieAdapter

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.item_1 -> {
                    // Handle item 1 click (HomeActivity)
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.item_2 -> {
                    // Handle item 2 click (FavoritesFragment)
                    val fragment = FavoritesFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, fragment)
                        .commit()
                    true
                }
                R.id.item_3 -> {
                    // Handle item 3 click
                    true
                }
                R.id.item_4 -> {
                    // Handle item 4 click
                    if (isDrawerOpen) {
                        drawerLayout.closeDrawer(navigationView)
                    } else {
                        drawerLayout.openDrawer(navigationView)
                    }
                    isDrawerOpen = !isDrawerOpen
                    true
                }
                else -> false
            }
        }

        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.navigationView)
        navigationView.setNavigationItemSelectedListener { menuItem ->
            // Handle navigation drawer item click
            when (menuItem.itemId) {
                R.id.profile_item -> {
                    // Handle profile item click
                }
                R.id.my_list_item -> {
                    // Handle my list item click
                }
                R.id.settings_item -> {
                    // Handle settings item click
                }
            }
            // Close the drawer
            drawerLayout.closeDrawer(navigationView)
            isDrawerOpen = false
            true
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

    private fun navigateToFavorites() {
        val fragment = FavoritesFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

    private fun getMovieList(): List<Movie> {
        val movies = mutableListOf<Movie>()
        movies.add(Movie("Movie 1", "Genre 1"))
        movies.add(Movie("Movie 2", "Genre 2"))
        movies.add(Movie("Movie 3", "Genre 3"))
        return movies
    }
}
