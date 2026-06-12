package com.turkcell.lyraapp.ui.login

sealed class LoginEvent {
    data class PhoneNumberChanged(val phoneNumber: String) : LoginEvent()
    data class PasswordChanged(val password: String) : LoginEvent()
    object LoginClicked : LoginEvent()
    object RegisterClicked : LoginEvent()
    object ForgotPasswordClicked : LoginEvent()
}

data class LoginState(
    val phoneNumber: String = "",
    val password: String = "",
    val isLoading: Boolean = false
)

sealed class LoginEffect {
    object NavigateToHome : LoginEffect()
    object NavigateToRegister : LoginEffect()
    object NavigateToForgotPassword : LoginEffect()
    data class ShowError(val message: String) : LoginEffect()
}
