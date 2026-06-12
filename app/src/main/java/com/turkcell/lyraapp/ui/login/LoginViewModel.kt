package com.turkcell.lyraapp.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(LoginState())
    val state: StateFlow<LoginState> = _state.asStateFlow()

    private val _effect = MutableSharedFlow<LoginEffect>()
    val effect: SharedFlow<LoginEffect> = _effect.asSharedFlow()

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.PhoneNumberChanged -> {
                _state.update { it.copy(phoneNumber = event.phoneNumber) }
            }
            is LoginEvent.PasswordChanged -> {
                _state.update { it.copy(password = event.password) }
            }
            is LoginEvent.LoginClicked -> {
                performLogin()
            }
            is LoginEvent.RegisterClicked -> {
                emitEffect(LoginEffect.NavigateToRegister)
            }
            is LoginEvent.ForgotPasswordClicked -> {
                emitEffect(LoginEffect.NavigateToForgotPassword)
            }
        }
    }

    private fun performLogin() {
        val currentState = _state.value
        if (currentState.phoneNumber.isBlank() || currentState.password.isBlank()) {
            emitEffect(LoginEffect.ShowError("Telefon numarası ve şifre boş olamaz"))
            return
        }

        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            
            // Simüle edilmiş login işlemi
            delay(1500)
            
            if (currentState.password == "123456") {
                emitEffect(LoginEffect.NavigateToHome)
            } else {
                emitEffect(LoginEffect.ShowError("Hatalı şifre"))
            }
            
            _state.update { it.copy(isLoading = false) }
        }
    }

    private fun emitEffect(effect: LoginEffect) {
        viewModelScope.launch {
            _effect.emit(effect)
        }
    }
}
