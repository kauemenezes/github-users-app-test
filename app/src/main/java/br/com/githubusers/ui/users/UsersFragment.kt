package br.com.githubusers.ui.users

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import br.com.githubusers.util.UiState
import br.com.domain.model.User
import br.com.githubusers.databinding.FragmentUsersBinding
import br.com.githubusers.ui.base.BaseFragment
import br.com.githubusers.ui.extension.hide
import br.com.githubusers.ui.extension.show
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val DEBOUNCE_TIME = 300L

class UsersFragment : BaseFragment<FragmentUsersBinding>() {

    private val usersViewModel: UsersViewModel by viewModel()
    private var searchJob: Job? = null
    private val githubUsers = mutableListOf<User>()
    private val usersListAdapter: UsersListAdapter by lazy {
        UsersListAdapter {
            callUserDetails(it)
        }
    }

    override fun initView() {
        setupListener()
        registerObserver()
        binding.rvUsers.adapter = usersListAdapter
    }

    private fun registerObserver() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                usersViewModel.users.collect {
                    when (it) {
                        is UiState.Loading -> {
                            displayLoadingState()
                        }
                        is UiState.Success -> {
                            hideLoadingState()
                            githubUsers.apply {
                                clear()
                                addAll(it.data)
                            }
                            usersListAdapter.submitList(githubUsers)
                        }
                        is UiState.Error -> {
                            hideLoadingState()
                            showMessage(getString(it.message)) {
                                usersViewModel.getUsers()
                            }
                        }
                    }
                }
            }
        }
    }

    private fun setupListener() {
        binding.etInputSearch.doAfterTextChanged { editable ->
            editable?.toString()?.let { search ->
                searchJob?.cancel()
                if (search.trim().isNotEmpty()) {
                    searchJob = lifecycleScope.launch {
                        delay(DEBOUNCE_TIME)
                        val filteredUsers= githubUsers.filter {
                            it.name.contains(search, true) || it.login.contains(search, true)
                        }
                        if (filteredUsers.isNotEmpty()) {
                            showUsersList()
                            usersListAdapter.submitList(
                                filteredUsers
                            )
                        } else {
                            hideUsersList()
                        }
                    }
                } else {
                    showUsersList()
                    usersListAdapter.submitList(
                        githubUsers
                    )
                }
            }
        }
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentUsersBinding {
        return FragmentUsersBinding.inflate(inflater, container, false)
    }

    private fun callUserDetails(userLogin: String) {
        val action = UsersFragmentDirections.actionUsersFragmentToUserDetailsFragment(userLogin)
        findNavController().navigate(action)
    }

    private fun displayLoadingState() {
        binding.group.hide()
        binding.progressUsers.show()
    }

    private fun hideLoadingState() {
        binding.group.show()
        binding.progressUsers.hide()
    }

    private fun showUsersList() {
        binding.rvUsers.show()
        binding.tvNoResult.hide()
    }

    private fun hideUsersList() {
        binding.rvUsers.hide()
        binding.tvNoResult.show()
    }
}