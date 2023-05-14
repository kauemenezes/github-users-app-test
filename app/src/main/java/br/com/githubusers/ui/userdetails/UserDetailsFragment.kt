package br.com.githubusers.ui.userdetails

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import br.com.domain.model.UserRepo
import br.com.githubusers.databinding.FragmentUserDetailsBinding
import br.com.githubusers.ui.base.BaseFragment
import br.com.githubusers.ui.extension.image
import br.com.githubusers.util.RequestState
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserDetailsFragment : BaseFragment<FragmentUserDetailsBinding>() {

    private val userDetailsViewModel: UserDetailsViewModel by viewModel()
    private val args: UserDetailsFragmentArgs by navArgs()
    private val userDetailsListAdapter: UserDetailsListAdapter by lazy {
        UserDetailsListAdapter {
            openRepository(it)
        }
    }

    override fun initView() {
        registerObserver()
        binding.rvUserRepos.adapter = userDetailsListAdapter
        userDetailsViewModel.getUserDetails(args.userLogin)
    }

    private fun registerObserver() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                userDetailsViewModel.userDetails.collect {
                    when (it) {
                        is RequestState.Loading -> {
                            displayLoadingState()
                        }
                        is RequestState.Success -> {
                            hideLoadingState()
                            fillData(it.data)
                        }
                        is RequestState.Error -> {
                            hideLoadingState()
                            showMessage(getString(it.message)) {
                                userDetailsViewModel.getUserDetails(args.userLogin)
                            }
                        }
                    }
                }
            }
        }
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentUserDetailsBinding {
        return FragmentUserDetailsBinding.inflate(inflater, container, false)
    }

    private fun fillData(userRepo: UserRepo) {
        binding.userImage.image(userRepo.user.avatarUrl)
        binding.userName.text = userRepo.user.name
        binding.userLogin.text = userRepo.user.login
        userDetailsListAdapter.submitList(userRepo.userRepos)
    }

    private fun openRepository(repoUrl: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(repoUrl)
        startActivity(intent)
    }

    private fun displayLoadingState() {
        binding.group.visibility = View.GONE
        binding.progressUsers.visibility = View.VISIBLE
    }

    private fun hideLoadingState() {
        binding.group.visibility = View.VISIBLE
        binding.progressUsers.visibility = View.GONE
    }
}