package com.example.tiktaktoe.ui.session

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tiktaktoe.R

class GameSessionFragment : Fragment() {

    companion object {
        fun newInstance() = GameSessionFragment()
    }

    private lateinit var viewModel: GameSessionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.game_session_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GameSessionViewModel::class.java)
        // TODO: Use the ViewModel
    }

}