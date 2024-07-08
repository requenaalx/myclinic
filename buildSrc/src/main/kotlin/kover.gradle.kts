
plugins {
    id("org.jetbrains.kotlinx.kover")
}

kover {
    reports {
        total {
            xml {
                title = "Coverage Report"
                onCheck = true
            }

            html {
                title = "Coverage Report"
                charset = "UTF-8"
                onCheck = true
            }
        }

        filters {
            excludes {
                classes(
                    "starter.**",
                    "driver.http.**.dtos.**",
                    "application.ports.**",
                )
            }
        }
    }
}
