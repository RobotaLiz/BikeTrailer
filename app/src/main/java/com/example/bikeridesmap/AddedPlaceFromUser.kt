package com.example.bikeridesmap

import com.google.firebase.firestore.DocumentId
class AddedPlaceFromUser(@DocumentId var documentid : String?  = null,
                         var name : String = "",
                         var length : Double = 0.0,
                         var difficulty: Double = 0.0)  {
}