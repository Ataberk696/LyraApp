package com.turkcell.lyraapp.ui.auth.register

sealed class RegisterEvent {
    data class FirstNameChanged(val firstName: String) : RegisterEvent()
    data class LastNameChanged(val lastName: String) : RegisterEvent()
    data class PhoneNumberChanged(val phoneNumber: String) : RegisterEvent()
    data class PasswordChanged(val password: String) : RegisterEvent()
    data class TermsAcceptedChanged(val isAccepted: Boolean) : RegisterEvent()
    object RegisterClicked : RegisterEvent()
    object LoginClicked : RegisterEvent()
    object BackClicked : RegisterEvent()
}

data class RegisterState(
    val firstName: String = "",
    val lastName: String = "",
    val phoneNumber: String = "",
    val password: String = "",
    val isTermsAccepted: Boolean = false,
    val isLoading: Boolean = false,
    val passwordStrength: Int = 0 // 0-3 arası
)

sealed class RegisterEffect {
    object NavigateBack : RegisterEffect()
    object NavigateToLogin : RegisterEffect()
    object NavigateToHome : RegisterEffect()
    data class ShowError(val message: String) : RegisterEffect()
}
