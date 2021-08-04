package org.myclinic.model

import org.myclinic.model.contact.Contactable

interface Provider: Contactable {
    val name: String
}
