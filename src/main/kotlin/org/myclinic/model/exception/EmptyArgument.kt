package org.myclinic.model.exception

class EmptyArgument(argumentType: String) :
    Exception("Empty $argumentType provided")
