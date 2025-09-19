###############################
## Android 기본 설정
###############################
#-keep public class * extends android.app.Application { *; }
#-keep public class * extends android.content.BroadcastReceiver { *; }
#-keep public class * extends android.app.Service { *; }
#-keep public class * extends android.content.ContentProvider { *; }
#
###############################
## Data, Domain, Presentation Layer 보호
###############################
#-keep class kr.bitbyte.data.** { *; }
#-keep class kr.bitbyte.domain.** { *ㅁ; }
#-keep class kr.bitbyte.moneypig.** { *; }
#
###############################
## Hilt (DI) 보호
###############################
#-keep class dagger.hilt.** { *; }
#-keep class javax.inject.** { *; }
#-keep @dagger.hilt.android.lifecycle.HiltViewModel class * { *; }
#
###############################
## Room Database 유지
###############################
#
## Room Database 유지
#-keep class androidx.room.** { *; }
#-keep interface androidx.room.** { *; }
#
## Room Database 관련 클래스 유지
#-keep class kr.bitbyte.domain.model.database.** { *; }
#-keep class kr.bitbyte.data.database.** { *; }
#
## Room의 DAO 및 Entity 유지
#-keep @androidx.room.Dao class * { *; }
#-keep @androidx.room.Entity class * { *; }
#-keep @androidx.room.Database class * { *; }
#
###############################
## Retrofit 및 OkHttp 유지
###############################
#
## Retrofit 및 OkHttp 관련 클래스 보호
#-keep class retrofit2.** { *; }
#-keep class okhttp3.** { *; }
#-keep class com.squareup.okhttp3.** { *; }
#-keep class com.squareup.retrofit2.** { *; }
#
## Retrofit에서 제네릭 타입 유지
#-keepclassmembers,allowobfuscation interface * {
#    @retrofit2.http.* <methods>;
#}
#
## Coroutine (비동기 처리 유지)
#-keep class kotlinx.coroutines.** { *; }
#
#
# # With R8 full mode generic signatures are stripped for classes that are not
# # kept. Suspend functions are wrapped in continuations where the type argument
# # is used.
# -keep,allowobfuscation,allowshrinking class kotlin.coroutines.Continuation
#
# # R8 full mode strips generic signatures from return types if not kept.
# -if interface * { @retrofit2.http.* public *** *(...); }
# -keep,allowoptimization,allowshrinking,allowobfuscation class <3>
#
# # With R8 full mode generic signatures are stripped for classes that are not kept.
# -keep,allowobfuscation,allowshrinking class retrofit2.Response
#
#
###############################
## Gson (JSON 직렬화 유지)
###############################
## Gson 관련 클래스 유지
#-keep class com.google.gson.** { *; }
#-keepattributes Signature
#-keep class kr.bitbyte.domain.model.api.** { *; }
#
## TypeToken 관련 클래스 보호
#-keep class com.google.gson.reflect.TypeToken { *; }
#-keep class com.google.gson.internal.** { *; }
#
#
###############################
## ViewBinding, Navigation 유지
###############################
#-keep class * implements androidx.viewbinding.ViewBinding { *; }
#-keep class androidx.navigation.** { *; }
#
###############################
## Firebase 관련 클래스 유지
###############################
#-keep class com.google.firebase.** { *; }
#
###############################
## Glide 이미지 로딩 라이브러리 유지
###############################
#-keep class com.bumptech.glide.** { *; }
#
###############################
## Airbridge SDK 유지
###############################
#-keep class io.airbridge.** { *; }
#
###############################
## Mixpanel 유지
###############################
#-keep class com.mixpanel.android.** { *; }
#
###############################
## WorkManager 유지
###############################
#-keep class androidx.work.** { *; }
#
###############################
## Parcelable (직렬화된 객체 유지)
###############################
#-keepclassmembers class * implements android.os.Parcelable {
#    public static final android.os.Parcelable$Creator *;
#}
#
###############################
## 디버깅용 로그 제거 (릴리즈 빌드에서 로그 삭제)
###############################
#-assumenosideeffects class android.util.Log { *; }
#
###############################
## 카카오 로그인
###############################
#-keep class com.kakao.sdk.**.model.* { <fields>; }
#-keep class * extends com.google.gson.TypeAdapter
#
## https://github.com/square/okhttp/pull/6792
#-dontwarn org.bouncycastle.jsse.**
#-dontwarn org.conscrypt.*
#-dontwarn org.openjsse.**
