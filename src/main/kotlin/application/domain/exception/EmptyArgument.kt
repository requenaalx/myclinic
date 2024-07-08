package application.domain.exception

import kotlin.reflect.KClass

class EmptyArgument(argumentType: KClass<out Any>) :
    Exception("Empty ${argumentType.simpleName} provided")
