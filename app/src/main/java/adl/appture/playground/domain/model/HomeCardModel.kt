package adl.appture.playground.domain.model

data class HomeCardModel(
    val cardName: String,
    val cardColor: Int,
    val cardType: HomeCardEnum
)

enum class HomeCardEnum {
    CAMERA,
    COMPONENTS,
    FIREBASE,
    CLICKS,
}
