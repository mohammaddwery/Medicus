package com.medicus.app.data.repository.biomarker

import com.medicus.app.data.model.Biomarker

interface BiomarkerRepository {
    suspend fun fetchBiomarkers(userId: String): List<Biomarker>
}