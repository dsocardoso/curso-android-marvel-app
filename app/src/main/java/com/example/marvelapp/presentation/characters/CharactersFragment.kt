package com.example.marvelapp.presentation.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.core.domain.model.Character
import com.example.marvelapp.databinding.FragmentCharactersBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharactersFragment : Fragment() {

    //back property
    private var _binding: FragmentCharactersBinding? = null
    private val binding: FragmentCharactersBinding get() = _binding!!

    private val charactersAdapter = CharacteresAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentCharactersBinding.inflate(
        inflater,
        container,
        false
    ).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initCharactersAdapter()
        @Suppress("MaxLineLength")
        charactersAdapter.submitList(
            listOf(
                Character("Spider Man", "https://meups.com.br/wp-content/uploads/2022/12/marvels-spider-man-900x503.jpg"),
                Character("Spider Man", "https://meups.com.br/wp-content/uploads/2022/12/marvels-spider-man-900x503.jpg"),
                Character("Spider Man", "https://meups.com.br/wp-content/uploads/2022/12/marvels-spider-man-900x503.jpg"),
                Character("Spider Man", "https://meups.com.br/wp-content/uploads/2022/12/marvels-spider-man-900x503.jpg"),
                Character("Spider Man", "https://meups.com.br/wp-content/uploads/2022/12/marvels-spider-man-900x503.jpg"),
                Character("Spider Man", "https://meups.com.br/wp-content/uploads/2022/12/marvels-spider-man-900x503.jpg"),
                Character("Spider Man", "https://meups.com.br/wp-content/uploads/2022/12/marvels-spider-man-900x503.jpg"),
                Character("Spider Man", "https://meups.com.br/wp-content/uploads/2022/12/marvels-spider-man-900x503.jpg"),
                Character("Spider Man", "https://meups.com.br/wp-content/uploads/2022/12/marvels-spider-man-900x503.jpg"),
                Character("Spider Man", "https://meups.com.br/wp-content/uploads/2022/12/marvels-spider-man-900x503.jpg")

            )
        )

    }

    private fun initCharactersAdapter() {
        with(binding.recycleCharacters) {
            setHasFixedSize(true)
            adapter = charactersAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
