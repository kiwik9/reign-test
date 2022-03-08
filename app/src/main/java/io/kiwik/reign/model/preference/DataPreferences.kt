package io.kiwik.reign.model.preference

import io.kiwik.reign.domain.entities.*

class DataPreferences : SessionPreference() {
    var loggedUser: User? = null
}