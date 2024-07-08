package application.domain.exception

import application.domain.model.Status

class ActionNotAllowed(status: Status) :
    Exception("Action not allowed for a $status service")