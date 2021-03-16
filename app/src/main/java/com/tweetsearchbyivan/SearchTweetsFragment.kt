package com.tweetsearchbyivan

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import com.tweetsearchbyivan.adapter.TweetsListAdapter
import com.tweetsearchbyivan.databinding.SearchTweetsFragmentBinding

class SearchTweetsFragment : Fragment() {

    companion object {
        fun newInstance() = SearchTweetsFragment()
    }

    private val viewModel: SearchTweetsViewModel by lazy {
        ViewModelProvider(this).get(SearchTweetsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = SearchTweetsFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.tweet = viewModel

        binding.recyclerView.adapter = TweetsListAdapter(TweetsListAdapter.OnClickListener {
            viewModel.displayTweet(it)
        })

        binding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(input: String): Boolean {
                viewModel.searchTweet(input)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.searchTweet(newText)
                return true
            }

        })

        return binding.root
    }

}