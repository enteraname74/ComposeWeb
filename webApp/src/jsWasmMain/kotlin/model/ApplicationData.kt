package model

object ApplicationData {
    val projects: List<Project> = listOf(
        Project(
            title = "Soul Searching",
            description = "An offline music application for Android 8 and above, with Jetpack Compose.",
            technologiesImages = listOf("kotlin.png","compose.png"),
            projectRepositoryUrl = "https://github.com/enteraname74/SoulSearching"
        ),
        Project(
            title = "Bagit Desktop",
            description = "A Desktop application for managing Git projects.",
            technologiesImages = listOf("rust.png","gtk.png", "libadwaita.png"),
            projectImages = listOf("b1.png","b2.png","b3.png","b4.png")
        ),
        Project(
            title = "Sweet Music",
            description = "An offline music application for Android 8 and above.",
            technologiesImages = listOf("kotlin.png"),
            projectRepositoryUrl = "https://github.com/enteraname74/SweetMusic"
        ),
        Project(
            title = "USMD BACK",
            description = "A server application, made for testing Ktor.",
            technologiesImages = listOf("kotlin.png", "ktor.png")
        ),
        Project(
            title = "Compose Web",
            description = "A web app, made for testing Compose for Web.",
            technologiesImages = listOf("kotlin.png","compose.png"),
            projectRepositoryUrl = "https://github.com/enteraname74/ComposeWeb",
            projectImages = listOf("cw1.png","cw2.png","cw3.png","cw4.png","cw5.png")
        )
    )

    val technologies: List<TechnologyList> = listOf(
        TechnologyList(
            title = "Back End",
            technologiesImages = listOf("ktor.png", "spring_boot.png")
        ),
        TechnologyList(
            title = "Front End",
            technologiesImages = listOf("angular.png", "typescript.png")
        ),
        TechnologyList(
            title = "Dev Ops",
            technologiesImages = listOf("docker.png")
        ),
        TechnologyList(
            title = "Desktop",
            technologiesImages = listOf("gtk.png", "libadwaita.png", "rust.png")
        ),
        TechnologyList(
            title = "Cross Platform",
            technologiesImages = listOf("compose.png", "flutter.png")
        )
    )
}