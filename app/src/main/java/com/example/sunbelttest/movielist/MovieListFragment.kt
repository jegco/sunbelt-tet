package com.example.sunbelttest.movielist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.domain.models.Movie
import com.example.domain.utils.Result
import com.example.sunbelttest.R
import com.example.sunbelttest.base.BaseFragment
import com.example.sunbelttest.conf.App
import com.example.sunbelttest.conf.ViewModelFactory
import com.example.sunbelttest.utils.MOVIE
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_list.*
import javax.inject.Inject

class MovieListFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    var viewModel: MovieListViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MovieListViewModel::class.java)
        viewModel?.fetchMovies()

        viewModel?.getMovies()?.observe(viewLifecycleOwner, {
            when (it.status) {
                Result.Status.SUCCESS -> it.data?.let { movieList ->
                    loadList(movieList)
                    showLoading(false)
                }
                Result.Status.LOADING -> showLoading(true)
                Result.Status.ERROR -> it.message?.let { errorMessage ->
                    Snackbar.make(view, errorMessage, Snackbar.LENGTH_SHORT)
                    showLoading(false)
                    loadList(ArrayList())
                }
            }
        })
    }

    private fun loadList(fetchedMovies: List<Movie>) {
        movieList?.adapter = MovieListAdapter(fetchedMovies) { movie ->
            findNavController().navigate(
                R.id.action_FirstFragment_to_SecondFragment,
                bundleOf(MOVIE to movie)
            )
        }
        movieList?.layoutManager = (GridLayoutManager(context, 2))
        movieList?.setHasFixedSize(true)
    }

    private fun showLoading(isLoading: Boolean) {
        loadingList?.isVisible = isLoading
        movieList?.isVisible = !isLoading
    }
}