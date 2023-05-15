package br.com.githubusers.ui.userdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.domain.model.UserRepo
import br.com.domain.usecase.GetUserDetailsUseCase
import br.com.githubusers.util.ExceptionParser
import br.com.githubusers.util.RequestState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class UserDetailsViewModel(
    private val getUserDetailsUseCase: GetUserDetailsUseCase,
    private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _userDetails = MutableStateFlow<RequestState<UserRepo>>(RequestState.Loading)
    val userDetails = _userDetails.asStateFlow()

    fun getUserDetails(userLogin: String) {
        viewModelScope.launch(dispatcher) {
            _userDetails.value = RequestState.Loading
            getUserDetailsUseCase(userLogin)
                .catch { e ->
                    _userDetails.value = RequestState.Error(ExceptionParser.getMessage(e))
                }
                .collect {
                    _userDetails.value = RequestState.Success(it)
                }
        }
    }
}