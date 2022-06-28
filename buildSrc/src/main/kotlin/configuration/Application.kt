package configuration

object Application {

    const val VersionCode = 1
    const val VersionName = "0.1"
    const val Id = "orangevelvet.androidblueprint.hilt"

    object DEV {
        const val BuildName = "debug"
        const val EndPoint = "\"https://myapi.dev.orangevelvet.com\""
        const val Label = "@string/app_label_dev"
        const val Icon = "@mipmap/ic_launcher_dev"
        const val ApplicationIdSuffix = ".dev"
    }

    object STAGING {
        const val BuildName = "staging"
        const val EndPoint = "\"https://myapi.staging.orangevelvet.com\""
        const val Label = "@string/app_label_staging"
        const val Icon = "@mipmap/ic_launcher_staging"
        const val ApplicationIdSuffix = ".staging"
    }

    object RELEASE {
        const val BuildName = "release"
        const val EndPoint = "\"https://myapi.orangevelvet.com\""
        const val Label = "@string/app_label_release"
        const val Icon = "@mipmap/ic_launcher_round"
    }
}
