### MVI ViewModel ve View Kuralları (mvi-viewmodel-rules.md)

#### 1. ViewModel Kuralları
- Tüm ViewModel'lar `@HiltViewModel` ile işaretlenmeli ve `ViewModel()` sınıfından türetilmelidir.
- `State` yönetimi için `MutableStateFlow` ve onu dışarı açan `StateFlow` kullanılmalıdır.
- `Effect` yönetimi için `MutableSharedFlow` ve onu dışarı açan `SharedFlow` kullanılmalıdır.
- View'dan gelen tüm etkileşimler sadece tek bir fonksiyon üzerinden (`onEvent(event: <Screen>Event)`) alınmalı ve `when` bloğu ile eşleştirilmelidir.
- State güncellemeleri Thread-safe olabilmesi adına `.value = ...` yerine **`.update { it.copy(...) }`** fonksiyonu kullanılarak yapılmalıdır.
- Effect fırlatma işlemleri mutlaka `viewModelScope.launch { _effect.emit(...) }` içinde yapılmalıdır.

**Örnek Şablon:**
```kotlin
@HiltViewModel
class ExampleViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(ExampleState())
    val state: StateFlow<ExampleState> = _state.asStateFlow()

    private val _effect = MutableSharedFlow<ExampleEffect>()
    val effect: SharedFlow<ExampleEffect> = _effect.asSharedFlow()

    fun onEvent(event: ExampleEvent) {
        when (event) {
            is ExampleEvent.SomeAction -> { /* handle */ }
        }
    }
}
```

#### 2. UI / Screen Kuralları
- Ekran kodu (View) her zaman stateful ve stateless olmak üzere iki Composables fonksiyona bölünmelidir.
    - **`<ScreenName>Screen` (Stateful):** `hiltViewModel()` üzerinden ViewModel'i alır. State'i `.collectAsState()` ile toplar. Effect'leri `LaunchedEffect(viewModel.effect)` ve `.collectLatest` ile dinler ve işler (Navigasyon, Toast vb.).
    - **`<ScreenName>ScreenContent` (Stateless):** Yalnızca `state: <ScreenName>State` ve `onEvent: (<ScreenName>Event) -> Unit` parametrelerini alır. Hilt veya ViewModel barındırmaz. Görsel bileşenlerin çizimini yapar.
- Component Preview (Görüntüleme) fonksiyonları her zaman Stateless olan `Content` fonksiyonunu kullanmalıdır. Stateful fonksiyon Preview yapılamaz (Hilt Context hatası verir).
