pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Film Match"
include(":app")
include(":source:core:core_api")
include(":source:core:core_factory")
include(":source:core:core_impl")
include(":source:main")
include(":source:ui_kit")
include(":source:home:home_api")
include(":source:home:home_impl")
include(":source:genres:genres_api")
include(":source:genres:genres_impl")
include(":source:base")
