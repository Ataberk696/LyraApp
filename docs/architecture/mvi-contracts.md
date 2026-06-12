### MVI Contract Kuralları (mvi-contracts.md)

Her ekranın mutlaka bir `Contract` dosyası olmalıdır (Örn: `LoginContract.kt`). Bu dosya ekranın State, Event ve Effect yapılarını tanımlar.

#### 1. Event (İntent / Aksiyonlar)
Kullanıcının veya sistemin ekrandaki her türlü etkileşimi `Event` olarak adlandırılır.
- **Sealed Class** olarak tanımlanmalıdır.
- Veri taşıyan etkileşimler `data class`, veri taşımayanlar `object` (veya `data object`) olmalıdır.
```kotlin
sealed class LoginEvent {
    data class PhoneNumberChanged(val phoneNumber: String) : LoginEvent()
    object LoginClicked : LoginEvent()
}
```

#### 2. State (Ekran Durumu)
Ekrandaki UI'ın o anki fotoğrafını (durumunu) temsil eder.
- Sadece okunabilir özellikler barındıran bir **Data Class** olmalıdır.
- ViewModel dışında hiçbir yerden doğrudan değiştirilemez.
- Property'ler mutlaka default (varsayılan) değerlere sahip olmalıdır.
```kotlin
data class LoginState(
    val phoneNumber: String = "",
    val isLoading: Boolean = false
)
```

#### 3. Effect (Tek Seferlik Olaylar)
UI tarafında sadece bir kere gösterilip kaybolacak (Navigate, Toast, vs.) durumlar içindir.
- **Sealed Class** olarak tanımlanmalıdır.
```kotlin
sealed class LoginEffect {
    object NavigateToHome : LoginEffect()
    data class ShowError(val message: String) : LoginEffect()
}
```
