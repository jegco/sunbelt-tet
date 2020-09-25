package com.example.sunbelttest.moviedescription

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.transition.ChangeBounds
import androidx.transition.TransitionInflater
import com.example.domain.models.MovieDescription
import com.example.domain.utils.Result
import com.example.sunbelttest.R
import com.example.sunbelttest.base.BaseFragment
import com.example.sunbelttest.conf.App
import com.example.sunbelttest.conf.ViewModelFactory
import com.example.sunbelttest.utils.MOVIE_ID
import com.example.sunbelttest.utils.setImageFromUrl
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_details.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class MovieDetailsFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    var viewModel: MovieDetailsViewModel? = null

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity?.applicationContext as App).component.inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MovieDetailsViewModel::class.java)
        arguments?.getInt(MOVIE_ID)?.let { viewModel?.fetchMovieDetail(it) }
        viewModel?.getMovie()?.observe(viewLifecycleOwner, {
            when(it.status) {
                Result.Status.LOADING -> showLoading(true)
                Result.Status.ERROR -> it.message?.let {errorMessage ->
                    Snackbar.make(view, errorMessage, Snackbar.LENGTH_SHORT)
                    showLoading(false)
                }
                Result.Status.SUCCESS -> it.data?.let { movieDetails ->
                    showDetails(movieDetails)
                    showLoading(false)
                }
            }
        })
    }

    private fun showLoading(isLoading: Boolean) {
        loadingDetails.isVisible = isLoading
    }

    private fun showDetails(movieDetails: MovieDescription) {
        context?.let { cxt ->
            movieDetails.posterPath?.let { posterImage.setImageFromUrl(it, cxt) }
        }
        movieDetails.releaseDate?.let { release_date.text = String.format(getString(R.string.release_date), it) }
        movieDetails.overview?.let { overview.text = String.format(getString(R.string.overview), it) }
        movieDetails.budget?.let { budget.text = String.format(getString(R.string.budget), it) }
        movieDetails.voteAverage?.let { movieVoteAverage.text = String.format(getString(R.string.vote_average), it) }
        movieDetails.videos?.let {
            if (it.isEmpty()) {
                trailers.isVisible = false
                emptyTrailers.isVisible = true
            } else trailers.adapter = TrailersListAdapter(it) { key ->
                watchTrailer(key)
            }
        }
    }

    private fun watchTrailer(key: String) {
        val appIntent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:$key"))
        val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=$key"))
        try {
            context?.startActivity(appIntent)
        } catch (ex: ActivityNotFoundException) {
            context?.startActivity(webIntent)
        }
    }
}