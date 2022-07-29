package com.medicus.app.data.repository.biomarker

import com.medicus.app.data.data_resource.remote_resource.api.biomarker.BiomarkerApiProvider
import com.medicus.app.data.model.Biomarker

class BiomarkerRepositoryImp(
    private val biomarkerApiProvider: BiomarkerApiProvider
) : BiomarkerRepository {
    override suspend fun fetchBiomarkers(userId: String): List<Biomarker> {
        return biomarkerApiProvider.getBiomarkers(userId)
    }
}