### MVI Mimari Özeti (Overview)

MVI (Model-View-Intent) mimarisi bu projede "tek yönlü veri akışı" (Unidirectional Data Flow) prensibine tam sadık kalınarak uygulanır.

#### Genel Prensipler:
1. **Stateless UI:** Görsel bileşenler (Compose fonksiyonları) hiçbir iş mantığı içermemelidir. State'i parametre olarak almalı ve kullanıcı aksiyonlarını (Event) yukarıya (ViewModel'e) fırlatmalıdır.
2. **Tek Doğru Kaynağı (Single Source of Truth):** Ekranın anlık durumu sadece ViewModel içindeki `StateFlow` tarafından yönetilir.
3. **Efektler (Effects):** Navigasyon, Toast mesajı veya Snackbbar gösterimi gibi tek seferlik UI tetikleyicileri `SharedFlow` üzerinden Effect olarak gönderilir ve View katmanında `LaunchedEffect` içinde toplanır (collect edilir).
4. **Dosya Ayrımı:** Her ekran için `<ScreenName>Screen.kt`, `<ScreenName>ViewModel.kt` ve `<ScreenName>Contract.kt` dosyaları oluşturulmalıdır. İşlemler en sade haliyle ve Dependency Injection (Hilt) entegre edilerek yapılır.
