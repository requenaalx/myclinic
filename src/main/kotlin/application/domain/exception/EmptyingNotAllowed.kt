package application.domain.exception

import kotlin.reflect.KClass

class EmptyingNotAllowed(propertyType: KClass<out Any>) :
    Exception("Emptying ${propertyType.simpleName} is not allowed")
