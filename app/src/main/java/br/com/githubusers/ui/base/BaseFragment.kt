package br.com.githubusers.ui.base

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import br.com.githubusers.R
import com.google.android.material.snackbar.Snackbar


abstract class BaseFragment<VBinding : ViewBinding> :
    Fragment() {

    private var _binding: VBinding? = null
    protected val binding get() = _binding!!

    protected abstract fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?): VBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = getViewBinding(inflater, container)
        initView()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun showMessage(message: String?, onClick: () -> Unit) {
        Snackbar
            .make(binding.root, message.orEmpty(), Snackbar.LENGTH_INDEFINITE)
            .setAction(getString(R.string.error_retry)) {
                onClick()
            }.show()
    }

    abstract fun initView()
}
