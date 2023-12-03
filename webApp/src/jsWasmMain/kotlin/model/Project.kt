package model

data class Project(
    val title: String = "",
    val description: String = "",
    val technologiesImages: List<String> = emptyList(),
    val projectRepositoryUrl: String? = null
)