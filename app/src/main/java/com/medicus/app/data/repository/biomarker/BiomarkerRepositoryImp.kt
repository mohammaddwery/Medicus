package com.medicus.app.data.repository.biomarker

import com.medicus.app.data.model.Biomarker

class BiomarkerRepositoryImp : BiomarkerRepository {
    override suspend fun fetchBiomarkers(userId: String): List<Biomarker> = getDummyBiomarkers() // TODO


    private fun getDummyBiomarkers(): List<Biomarker> = listOf(
        Biomarker(
            id= 1,
            date= "May 25, 2021 6:58 PM",
            info= "There is no need to specially prepare for this test. Ensure that your healthcare provider knows about all of medications you are taking",
            color= "#E64A19",
            value= "100",
            symbol= "HbA1C",
            insight= "Long-term high blood sugar levels can injure your small blood vessels",
            category= "Blood"
        ),
        Biomarker(
            id= 1,
            date= "May 25, 2021 6:58 PM",
            info= "There is no need to specially prepare for this test. Ensure that your healthcare provider knows about all of medications you are taking",
            color= "#00BCD4",
            value= "100",
            symbol= "HbA1C",
            insight= "Long-term high blood sugar levels can injure your small blood vessels",
            category= "Blood"
        ),
        Biomarker(
            id= 1,
            date= "May 25, 2021 6:58 PM",
            info= "There is no need to specially prepare for this test. Ensure that your healthcare provider knows about all of medications you are taking",
            color= "#E64A19",
            value= "100",
            symbol= "HbA1C",
            insight= "Long-term high blood sugar levels can injure your small blood vessels",
            category= "Blood"
        ),
        Biomarker(
            id= 1,
            date= "May 25, 2021 6:58 PM",
            info= "There is no need to specially prepare for this test. Ensure that your healthcare provider knows about all of medications you are taking",
            color= "#E64A19",
            value= "100",
            symbol= "HbA1C",
            insight= "Long-term high blood sugar levels can injure your small blood vessels",
            category= "Blood"
        ),
        Biomarker(
            id= 1,
            date= "May 25, 2021 6:58 PM",
            info= "There is no need to specially prepare for this test. Ensure that your healthcare provider knows about all of medications you are taking",
            color= "#E64A19",
            value= "100",
            symbol= "HbA1C",
            insight= "Long-term high blood sugar levels can injure your small blood vessels",
            category= "Blood"
        ),
        Biomarker(
            id= 1,
            date= "May 25, 2021 6:58 PM",
            info= "There is no need to specially prepare for this test. Ensure that your healthcare provider knows about all of medications you are taking",
            color= "#E64A19",
            value= "100",
            symbol= "HbA1C",
            insight= "Long-term high blood sugar levels can injure your small blood vessels",
            category= "Blood"
        ),
        Biomarker(
            id= 1,
            date= "May 25, 2021 6:58 PM",
            info= "There is no need to specially prepare for this test. Ensure that your healthcare provider knows about all of medications you are taking",
            color= "#E64A19",
            value= "100",
            symbol= "HbA1C",
            insight= "Long-term high blood sugar levels can injure your small blood vessels",
            category= "Blood"
        ),
        Biomarker(
            id= 1,
            date= "May 25, 2021 6:58 PM",
            info= "There is no need to specially prepare for this test. Ensure that your healthcare provider knows about all of medications you are taking",
            color= "#E64A19",
            value= "100",
            symbol= "HbA1C",
            insight= "Long-term high blood sugar levels can injure your small blood vessels",
            category= "Blood"
        ),
        Biomarker(
            id= 1,
            date= "May 25, 2021 6:58 PM",
            info= "There is no need to specially prepare for this test. Ensure that your healthcare provider knows about all of medications you are taking",
            color= "#E64A19",
            value= "100",
            symbol= "HbA1C",
            insight= "Long-term high blood sugar levels can injure your small blood vessels",
            category= "Blood"
        ),
        Biomarker(
            id= 1,
            date= "May 25, 2021 6:58 PM",
            info= "There is no need to specially prepare for this test. Ensure that your healthcare provider knows about all of medications you are taking",
            color= "#E64A19",
            value= "100",
            symbol= "HbA1C",
            insight= "Long-term high blood sugar levels can injure your small blood vessels",
            category= "Blood"
        ),
        Biomarker(
            id= 1,
            date= "May 25, 2021 6:58 PM",
            info= "There is no need to specially prepare for this test. Ensure that your healthcare provider knows about all of medications you are taking",
            color= "#E64A19",
            value= "100",
            symbol= "HbA1C",
            insight= "Long-term high blood sugar levels can injure your small blood vessels",
            category= "Blood"
        ),
        Biomarker(
            id= 1,
            date= "May 25, 2021 6:58 PM",
            info= "There is no need to specially prepare for this test. Ensure that your healthcare provider knows about all of medications you are taking",
            color= "#E64A19",
            value= "100",
            symbol= "HbA1C",
            insight= "Long-term high blood sugar levels can injure your small blood vessels",
            category= "Blood"
        ),
        Biomarker(
            id= 1,
            date= "May 25, 2021 6:58 PM",
            info= "There is no need to specially prepare for this test. Ensure that your healthcare provider knows about all of medications you are taking",
            color= "#E64A19",
            value= "100",
            symbol= "HbA1C",
            insight= "Long-term high blood sugar levels can injure your small blood vessels",
            category= "Blood"
        ),
        Biomarker(
            id= 1,
            date= "May 25, 2021 6:58 PM",
            info= "There is no need to specially prepare for this test. Ensure that your healthcare provider knows about all of medications you are taking",
            color= "#E64A19",
            value= "100",
            symbol= "HbA1C",
            insight= "Long-term high blood sugar levels can injure your small blood vessels",
            category= "Blood"
        ),
    )
}