package com.example.wordsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wordsapp.databinding.FragmentWordListBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [WordListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WordListFragment : Fragment() {

    private lateinit var letterId: String

    private var _binding : FragmentWordListBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            letterId = it.getString(LETTER).toString()
        }
    }

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        _binding = FragmentWordListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this.requireContext())
        recyclerView.adapter = WordAdapter(letterId, requireContext())

        recyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {

        val LETTER = "letter"
        val SEARCH_PREFIX = "https://www.google.com/search?q="

//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            WordListFragment().apply {
//                arguments = Bundle().apply {
//                    putString(LETTER, letterId)
//                }
//            }
    }

}