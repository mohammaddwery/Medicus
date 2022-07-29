package com.medicus.app.data.data_resource.remote_resource.api.biomarker

import com.medicus.app.data.model.Biomarker
import retrofit2.http.GET
import retrofit2.http.Path

interface BiomarkerApiProvider {

    @GET("{userId}/$biomarkers")
    suspend fun getBiomarkers(
        @Path("userId") id: String,
    ) : List<Biomarker>
}