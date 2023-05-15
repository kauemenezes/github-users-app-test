package br.com.githubusers.ui.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.githubusers.util.RequestState
import br.com.domain.model.User
import br.com.domain.usecase.GetUsersUseCase
import br.com.githubusers.util.ExceptionParser
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class UsersViewModel(
    private val getUsersUseCase: GetUsersUseCase,
    private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _users = MutableStateFlow<RequestState<List<User>>>(RequestState.Loading)
    val users = _users.asStateFlow()

    init {
        getUsers()
    }

    fun getUsers() {
        viewModelScope.launch(dispatcher) {
            _users.value = RequestState.Loading
            getUsersUseCase()
                .catch { e ->
                    _users.value = RequestState.Error(ExceptionParser.getMessage(e))
                }
                .collect {
                    _users.value = RequestState.Success(it)
                }
        }
    }
}