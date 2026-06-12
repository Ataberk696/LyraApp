package com.turkcell.lyraapp.ui.auth.register

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
class RegisterViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(RegisterState())
    val state: StateFlow<RegisterState> = _state.asStateFlow()

    private val _effect = MutableSharedFlow<RegisterEffect>()
    val effect: SharedFlow<RegisterEffect> = _effect.asSharedFlow()

    fun onEvent(event: RegisterEvent) {
        when (event) {
            is RegisterEvent.FirstNameChanged -> {
                _state.update { it.copy(firstName = event.firstName) }
            }
            is RegisterEvent.LastNameChanged -> {
                _state.update { it.copy(lastName = event.lastName) }
            }
            is RegisterEvent.PhoneNumberChanged -> {
                _state.update { it.copy(phoneNumber = event.phoneNumber) }
            }
            is RegisterEvent.PasswordChanged -> {
                _state.update { 
                    it.copy(
                        password = event.password,
                        passwordStrength = calculatePasswordStrength(event.password)
                    ) 
                }
            }
            is RegisterEvent.TermsAcceptedChanged -> {
                _state.update { it.copy(isTermsAccepted = event.isAccepted) }
            }
            is RegisterEvent.RegisterClicked -> {
                performRegister()
            }
            is RegisterEvent.LoginClicked -> {
                emitEffect(RegisterEffect.NavigateToLogin)
            }
            is RegisterEvent.BackClicked -> {
                emitEffect(RegisterEffect.NavigateBack)
            }
        }
    }

    private fun calculatePasswordStrength(password: String): Int {
        var strength = 0
        if (password.length >= 8) strength++
        if (password.any { it.isDigit() }) strength++
        if (password.any { it.isLetter() } && strength == 2) strength++
        return strength
    }

    private fun performRegister() {
        val currentState = _state.value
        
        if (currentState.firstName.isBlank() || currentState.lastName.isBlank() || 
            currentState.phoneNumber.isBlank() || currentState.password.isBlank()) {
            emitEffect(RegisterEffect.ShowError("Tüm alanları doldurunuz."))
            return
        }

        if (currentState.password.length < 8 || !currentState.password.any { it.isDigit() }) {
            emitEffect(RegisterEffect.ShowError("Şifre en az 8 karakter ve bir rakam içermeli."))
            return
        }

        if (!currentState.isTermsAccepted) {
            emitEffect(RegisterEffect.ShowError("Kullanım Koşulları ve Gizlilik Politikası'nı kabul etmelisiniz."))
            return
        }

        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            
            // Simüle edilmiş kayıt işlemi
            delay(1500)
            
            emitEffect(RegisterEffect.NavigateToHome)
            
            _state.update { it.copy(isLoading = false) }
        }
    }

    private fun emitEffect(effect: RegisterEffect) {
        viewModelScope.launch {
            _effect.emit(effect)
        }
    }
}
