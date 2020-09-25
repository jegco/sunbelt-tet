package com.example.sunbelttest.moviedescription

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.domain.models.Movie
import com.example.domain.models.MovieDescription
import com.example.domain.utils.Result
import com.example.persistence.utils.IMAGE_API_BASE_URL
import com.example.sunbelttest.R
import com.example.sunbelttest.base.BaseFragment
import com.example.sunbelttest.conf.App
import com.example.sunbelttest.conf.ViewModelFactory
import com.example.sunbelttest.utils.MOVIE
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

        viewModel = ViewModelProvider(this, viewModelFactory).get(MovieDetailsViewModel::class.java)
        val movie = arguments?.getParcelable<Movie>(MOVIE)
        movie?.let { it ->
            it.id?.let { id -> viewModel?.fetchMovieDetail(id) }
            it.title?.let { movieName ->
                activity?.actionBar?.title = movieName
            }
            context?.let { cxt ->
                posterImage.setImageFromUrl(IMAGE_API_BASE_URL + it.posterPath, cxt)
            }
        }

        viewModel?.getMovie()?.observe(viewLifecycleOwner, {
            when (it.status) {
                Result.Status.LOADING -> showLoading(true)
                Result.Status.ERROR -> it.message?.let { errorMessage ->
                    Snackbar.make(view, errorMessage, Snackbar.LENGTH_SHORT)
                    showLoading(false)
                }
                Result.Status.SUCCESS -> it.data?.let { movieDetails ->
                    showLoading(false)
                    showDetails(movieDetails)
                }
            }
        })
    }

    private fun showLoading(isLoading: Boolean) {
        loadingDetails?.isVisible = isLoading
        detailsContainer?.isVisible = !isLoading
    }

    private fun showDetails(movieDetails: MovieDescription) {
        movieDetails.releaseDate.let {
            releaseDate?.text = String.format(getString(R.string.release_date), it)
        }
        movieDetails.overview.let {
            overview?.text = it
        }
        val genres = movieDetails.genres.joinToString()
        genre?.text = String.format(getString(R.string.genres), genres)
        val prodCompanies = movieDetails.productionCompanies.joinToString()
        productionCompanies?.text =
            String.format(getString(R.string.production_companies), prodCompanies)
        val prodCountries = movieDetails.productionCountries.joinToString()
        productionCountries?.text =
            String.format(getString(R.string.production_countries), prodCountries)
        val spokenLangs = movieDetails.spokenLanguages.joinToString()
        spokenLanguages?.text = String.format(getString(R.string.spoken_languages), spokenLangs)
        movieDetails.voteAverage.let { movieVoteAverage.rating = (it / 2).toFloat() }
        if (movieDetails.adult) category.text = String.format(getString(R.string.category), getString(R.string.adults))
        else category.text = String.format(getString(R.string.category), getString(R.string.all_public))

        trailers?.adapter = TrailersListAdapter(movieDetails.videos) { key ->
            watchTrailer(key)
        }
        trailers?.layoutManager = (GridLayoutManager(context, 1))
        trailers?.setHasFixedSize(true)
    }

    private fun watchTrailer(key: String) {
        val appIntent =
            Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.youtube_app_url) + key))
        val webIntent =
            Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.youtube_web_url) + key))
        try {
            context?.startActivity(appIntent)
        } catch (ex: ActivityNotFoundException) {
            context?.startActivity(webIntent)
        }
    }
}