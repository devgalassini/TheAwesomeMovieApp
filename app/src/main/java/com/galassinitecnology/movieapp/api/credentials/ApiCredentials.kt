package com.galassinitecnology.movieapp.api.credentials

import com.galassinitecnology.movieapp.utils.Env

class ApiCredentials {

    companion object {
        const val publicKey = Env.publicKey
        const val privateKey = Env.privateKey
    }

}