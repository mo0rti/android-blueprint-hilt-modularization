package configuration

object Application {

    const val VersionCode = 1
    const val VersionName = "0.1"
    const val Id = "bluevelvet.blueprint.hilt"

    object DEV {
        const val BuildName = "debug"
        const val EndPoint = "\"https://myapi.dev.bluevelvet.com\""
        const val Icon = "@mipmap/ic_launcher"
        const val ApplicationIdSuffix = ".dev"
    }

    object STAGING {
        const val BuildName = "staging"
        const val EndPoint = "\"https://myapi.staging.bluevelvet.com\""
        const val Icon = "@mipmap/ic_launcher"
        const val ApplicationIdSuffix = ".staging"
    }

    object RELEASE {
        const val BuildName = "release"
        const val EndPoint = "\"https://myapi.bluevelvet.com\""
        const val Icon = "@mipmap/ic_launcher"
    }
}
