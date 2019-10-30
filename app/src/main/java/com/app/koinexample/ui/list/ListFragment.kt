package com.app.koinexample.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.app.koinexample.R
import com.app.koinexample.databinding.FragmentListBinding
import com.app.koinexample.model.User
import org.koin.android.viewmodel.ext.android.viewModel

class ListFragment : Fragment() {

    var adapter: ListUserAdapter? = null
    private lateinit var binding: FragmentListBinding

    val viewModel: ListViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
    }

    private fun init() {
        adapter = ListUserAdapter(ArrayList(), this::onItemClick)
        binding.rvUsers.adapter = adapter
        viewModel.loadData()
        viewModel.data.observe(this, Observer {
            it?.let { adapter?.updateList(it) }
        })
    }

    private fun onItemClick(user: User) {

        findNavController().navigate(object : NavDirections {
            override fun getArguments(): Bundle {
                val bundle = Bundle()
                bundle.putParcelable("user", user)
                return bundle
            }

            override fun getActionId(): Int = R.id.action_list_to_detail
        })
    }
}